package com.kealliang.laboratory.mock.anno;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 从当前 classpath 读取 @FakeBeanFor 注解的类，并替换指定名称的 bean
 */
@Slf4j
@Configuration
@ConditionalOnExpression("${unitcases.enable.fake:true}")
// 通过 BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry 可以将 Bean 动态注入容器
// 通过 BeanFactoryAware 可以自动注入 BeanFactory
public class FakeBeanConfiguration implements BeanDefinitionRegistryPostProcessor, BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.debug("searching for classes annotated with @FakeBeanFor");

        // 自定义 Scanner 扫描 classpath 下的指定注解
        ClassPathFakeAnnotationScanner scanner = new ClassPathFakeAnnotationScanner(registry);
        try {
            List<String> packages = AutoConfigurationPackages.get(this.beanFactory); // 获取包路径
            if (log.isDebugEnabled()) {
                for (String pkg : packages) {
                    log.debug("Using auto-configuration base package: {}", pkg);
                }
            }
            scanner.doScan(StringUtils.toStringArray(packages)); // 扫描所有加载的包
        } catch (IllegalStateException ex) {
            log.debug("could not determine auto-configuration package, automatic fake scanning disabled.", ex);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        // empty
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    private static class ClassPathFakeAnnotationScanner extends ClassPathBeanDefinitionScanner {

        ClassPathFakeAnnotationScanner(BeanDefinitionRegistry registry) {
            super(registry, false);
            // 设置过滤器。仅扫描 @FakeBeanFor
            addIncludeFilter(new AnnotationTypeFilter(FakeBeanFor.class));
        }

        @Override
        public Set<BeanDefinitionHolder> doScan(String... basePackages) {
            List<String> fakeClassNames = new ArrayList<>();
            // 扫描全部 package 下 annotationClass 指定的 Bean
            Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);

            GenericBeanDefinition definition;
            for (BeanDefinitionHolder holder : beanDefinitions) {
                definition = (GenericBeanDefinition) holder.getBeanDefinition();

                // 获取类名，并创建 Class 对象
                String className = definition.getBeanClassName();
                Class<?> clazz = classNameToClass(className);

                // 解析注解上的 value
                FakeBeanFor annotation = clazz.getAnnotation(FakeBeanFor.class);
                if (annotation == null || StringUtils.isEmpty(annotation.value())) {
                    continue;
                }

                // 使用当前加载的 @FakeBeanFor 指定的 Bean 替换 value 里指定名称的 Bean
                if (getRegistry().containsBeanDefinition(annotation.value())) {
                    getRegistry().removeBeanDefinition(annotation.value());
                    getRegistry().registerBeanDefinition(annotation.value(), definition);
                    fakeClassNames.add(clazz.getName());
                }
            }
            log.info("found fake beans: " + fakeClassNames);

            return beanDefinitions;
        }

        // 反射通过 class 名称获取 Class 对象
        private Class<?> classNameToClass(String className) {
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException e) {
                log.error("create instance failed.", e);
            }
            return null;
        }
    }
}
