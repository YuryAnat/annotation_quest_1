package Annotation.Test;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Init {
    boolean suppressExeption() default false;
}
