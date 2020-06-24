package com;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface methodInfo {
    String author() default "kalyan";
    String date();
    int revision() default 1;
    String comments();
}
