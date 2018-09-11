package Annotation.Test;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class operation {

    static Map<String,Object> serviceMap = new HashMap<>();

    public static void main(String[] args) {
//        inspectService(SipleService.class);
//        inspectService(LazyService.class);
//        inspectService(String.class);

        try {
            loadService("Annotation.Test.SimpleService");
            loadService("Annotation.Test.LazyService");
            loadService("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        for (Map.Entry entry:serviceMap.entrySet()){
            System.out.println("Name: " + entry.getKey() + "| object: " + entry.getValue().getClass());

        }
    }

    public static void loadService(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> cl = Class.forName(className);
        Method[] methods = cl.getDeclaredMethods();
        for (Method mt:methods) {
            if (mt.isAnnotationPresent(Service.class)){
                Object servObject = cl.newInstance();
                Annotation[] ann = mt.getAnnotations();
                for (Annotation sv : ann) {
                    Service sr = (Service) sv;
                    serviceMap.put(sr.name(),servObject);
                    try {
                        mt.invoke(servObject);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static void inspectService(Class<?> service){
        Method[] allMetod = service.getMethods();
        for (Method m:allMetod){
            if (m.isAnnotationPresent(Init.class)){
                Annotation[] an = m.getDeclaredAnnotations();
                for (Annotation init: an){
                    Init in = (Init) init;
                    if (in.suppressExeption()){
                        System.out.println("Exeption "+ in.suppressExeption());
                    }else {
                        System.out.println("Exeption true");
                    }
                }
                System.out.println(m.getName());
            }else{
                System.out.println("Nop.. " + m.getName());
            }
        }
    }
}
