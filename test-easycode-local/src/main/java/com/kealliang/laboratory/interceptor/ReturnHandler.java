package com.kealliang.laboratory.interceptor;

import cn.hutool.core.lang.Assert;
import cn.hutool.json.JSONUtil;
import com.kealliang.laboratory.config.KealConfigProperties;
import com.kealliang.laboratory.dto.MyDTO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author lsr
 * @ClassName ReturnHandler
 * @Date 2020-04-08
 * @Vertion 1.0
 */
@Component
public class ReturnHandler implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return true;
    }

    /**
     * 注意：不能拦截到@ResponseBody 和 @RestController修饰的返回值
     * 因为RequestResponseBodyMethodProcessor先一步处理并返回了
     * 需要修改处理的顺序
     * @author lsr
     * @description handleReturnValue
     * @Date 2020/4/8
     */
    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        System.out.println("结果集处理器 handleReturnValue");
        // 在这里拦截，可以通过写输出流的方式改变返回值类型
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        Assert.state(response != null, "没有HttpServletResponse！");
        mavContainer.setRequestHandled(true);

        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        response.getWriter().write(JSONUtil.toJsonStr(new MyDTO("张三", 18, new Date(), "Hello，这里是经过篡改的返回值！！！")));
    }
}
