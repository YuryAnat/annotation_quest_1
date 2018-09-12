package Annotation.quest_1;

import java.lang.reflect.Method;
import java.util.HashMap;


public class forList {
    private Object object;
    private Method method;
    private String methodName;
    private HashMap<String,Integer> annotationNameAndArgs = new HashMap<>();

    public HashMap<String, Integer> getAnnotationNameAndArgs() {
        return annotationNameAndArgs;
    }

    public void putMap(String name, Integer arg) {
        this.annotationNameAndArgs.put(name,arg);
    }






    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

}
