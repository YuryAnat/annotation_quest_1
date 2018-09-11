package Annotation.Test;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Service {
    String name();
    boolean lazyLoad() default false;
}
