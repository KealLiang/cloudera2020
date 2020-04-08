package com.kealliang.laboratory.aop;

import cn.hutool.core.io.watch.WatchException;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 想拦截任意的返回值，这是最简的方法
 * @author lsr
 * @ClassName ResultAspects
 * @Date 2020-04-08
 * @Vertion 1.0
 */
// 声明切面
@Aspect
public class ResultAspects {

    // 定义公共切入点
    @Pointcut("execution(* com.kealliang.laboratory.controller.HouseController.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before() {
        System.out.println("前置通知~");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("后置通知~");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("异常通知~");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturing(JoinPoint jp, Object result) {
        System.out.println(String.format("执行了%s方法，afterReturing将结果封装为Page失败", jp.getSignature().getName()));
        Page<Object> page = new Page<>(1, 1);
        page.setRecords(Arrays.asList(result));
        // java 中，一旦修改形参的指向，将失去对实参的引用，因此
        // afterReturing 能获取到返回值，但不能修改它，要改还得走around
    }

    // JoinPoint 必须出现在参数表第一位
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        try {
            System.out.println("环绕前 =>");
            long begin = System.currentTimeMillis();
            Object result = pjp.proceed();
            System.out.println(String.format("方法执行了%s毫秒", System.currentTimeMillis() - begin));
            System.out.println("环绕后 =>\r\n" + JSONUtil.toJsonPrettyStr(result));

            // 修改结果
            System.out.println(String.format("执行了%s方法，around将结果封装为Page", pjp.getSignature().getName()));
            Page<Object> page = new Page<>(1, 1);
            page.setRecords(Arrays.asList(result));
            return page;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new WatchException("环绕异常了！！");
        }
    }
}
