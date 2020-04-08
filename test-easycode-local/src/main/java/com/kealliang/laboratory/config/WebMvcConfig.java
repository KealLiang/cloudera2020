package com.kealliang.laboratory.config;

import com.kealliang.laboratory.interceptor.ReturnHandler;
import com.kealliang.laboratory.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author lsr
 * @ClassName WebMvcConfig
 * @Date 2020-04-08
 * @Vertion 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("添加自定义的拦截器");
        TestInterceptor testInterceptor = new TestInterceptor();
        registry.addInterceptor(testInterceptor)
                .addPathPatterns("/**");
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        System.out.println("添加自定义的结果处理器");
        ReturnHandler returnHandler = new ReturnHandler();
        handlers.add(returnHandler);
    }
}
