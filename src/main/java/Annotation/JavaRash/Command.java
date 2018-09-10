package Annotation.JavaRash;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
    String name();
    String args();
    int minArgs() default 0;
    int maxArgs()default Byte.MAX_VALUE;
    String desc();
    boolean showHelp() default true;
    String[] aliases();
}
