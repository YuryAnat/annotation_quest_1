package Annotation.quest_1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface annotationSumm{
        int num_1();
        int num_2();
    }
