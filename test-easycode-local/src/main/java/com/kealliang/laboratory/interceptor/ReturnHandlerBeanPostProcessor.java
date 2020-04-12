package com.kealliang.laboratory.interceptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.ArrayList;
import java.util.Optional;

/**
 * 将ReturnHandler注册到RequestMappingHandlerAdapter
 * ReturnHandler放到RequestResponseBodyMethodProcessor之前， 保证优先处理
 * @author lsr
 * @ClassName ReturnHandlerBeanPostProcessor
 * @Date 2020-04-11
 * @Vertion 1.0
 */
public class ReturnHandlerBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RequestMappingHandlerAdapter) {
            ArrayList<HandlerMethodReturnValueHandler> list = new ArrayList<>();
            RequestMappingHandlerAdapter adapter = (RequestMappingHandlerAdapter) bean;
            for (HandlerMethodReturnValueHandler handler : Optional.ofNullable(adapter.getReturnValueHandlers()).orElse(new ArrayList<>())) {
                if (handler.getClass() == RequestResponseBodyMethodProcessor.class) {
                    System.err.println("ReturnHandler放到RequestResponseBodyMethodProcessor之前，保证优先处理");
                    list.add(new ReturnHandler());
                }
                list.add(handler);
            }
            adapter.setReturnValueHandlers(list);
        }
        return bean;
    }

}
