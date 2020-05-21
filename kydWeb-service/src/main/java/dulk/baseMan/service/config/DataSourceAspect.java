package dulk.baseMan.service.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component
@Aspect
@Order(-100)//为了保证可以拦截到
public class DataSourceAspect {
    @Pointcut("execution(* dulk.baseMan.service..*(..)) " +     //这里扫描的切点包是主要是service层，根据service层方法的上边所说的的自定义注解，去判断所使用的数据源类型，并动态切换数据源
            "&& @annotation(dulk.baseMan.service.config.DataSourceTypeAnno)")
    public void dataSourcePointcut() {
        
    }

    @Around("dataSourcePointcut()")
    public Object doAround(ProceedingJoinPoint pjp) {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        DataSourceTypeAnno typeAnno = method.getAnnotation(DataSourceTypeAnno.class);
        DataSourceContextHolder.DataSourceEnum sourceEnum = typeAnno.value();

        if (sourceEnum == DataSourceContextHolder.DataSourceEnum.master) {
            DataSourceContextHolder.setDataSourceType(DataSourceContextHolder.DataSourceEnum.master);
        } else if (sourceEnum == DataSourceContextHolder.DataSourceEnum.slave1) {
            DataSourceContextHolder.setDataSourceType(DataSourceContextHolder.DataSourceEnum.slave1);
        }else if(sourceEnum == DataSourceContextHolder.DataSourceEnum.slave2){
            DataSourceContextHolder.setDataSourceType(DataSourceContextHolder.DataSourceEnum.slave2);
        }

        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            DataSourceContextHolder.resetDataSourceType();
        }

        return result;
    }
}