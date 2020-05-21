package dulk.baseMan.web.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


/**
 * @description:
 * @author: lvws
 * @create 2018-12-27 16:34
 */
@Aspect
@Component
public class OptimizeLogAspect {

    @Around(value="execution(public * dulk.baseMan.web.controller.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        String methodName = point.getSignature().getName();
        //开始时间
        long start = System.currentTimeMillis();
        //执行方法
        Object result =null;

        //请求的方法名
        String className = point.getTarget().getClass().getName();
        long end = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) point.getSignature();
        
        System.out.println("【接口执行时间】接口名：{"+className+"}.{"+methodName+"},执行时间:{"+(end-start)+"}毫秒"+result+"");
         result = point.proceed();
         end = System.currentTimeMillis();
         signature = (MethodSignature) point.getSignature();
        System.out.println("【接口执行时间】接口名：{"+className+"}.{"+methodName+"},执行时间:{"+(end-start)+"}毫秒"+result+"");
        return result;
    }

}