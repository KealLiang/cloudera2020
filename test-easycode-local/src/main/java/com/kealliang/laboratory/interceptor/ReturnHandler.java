package com.kealliang.laboratory.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author lsr
 * @ClassName ReturnHandler
 * @Date 2020-04-08
 * @Vertion 1.0
 */
public class ReturnHandler implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return true;
    }

    /**
     * 注意：不能拦截到@ResponseBody 和 @RestController修饰的返回值
     * @author lsr
     * @description handleReturnValue
     * @Date 2020/4/8
     */
    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        System.out.println("结果集处理器 handleReturnValue");
    }
}
