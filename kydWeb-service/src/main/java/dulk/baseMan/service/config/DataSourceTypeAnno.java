package dulk.baseMan.service.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 在运行时可见
@Target(ElementType.METHOD) // 注解可以用在方法上
public @interface DataSourceTypeAnno { //使用方式在service层方法上添加@DataSourceTypeAnno(DataSourceEnum.数据源枚举类型)用于指定所使用的数据源
    DataSourceContextHolder.DataSourceEnum value() default DataSourceContextHolder.DataSourceEnum.master; }