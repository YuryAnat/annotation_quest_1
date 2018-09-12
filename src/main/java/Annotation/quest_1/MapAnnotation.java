package Annotation.quest_1;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MapAnnotation {

    public static void main(String[] args) {
        AnnotationClass aClazz = new AnnotationClass();
        Map<String,forList> newMap = annotationHashMap(aClazz);
        for (Map.Entry<String, forList> entry : newMap.entrySet()) {
            System.out.println("Method name: " + entry.getKey());
            forList fl = entry.getValue();
            for (Map.Entry<String,Integer> stringIntegerEntry : fl.getAnnotationNameAndArgs().entrySet()) {
                if (stringIntegerEntry.getValue()> 0){
                    System.out.println("\tAnnotation name: " + stringIntegerEntry.getKey() + " delay fo run: " + stringIntegerEntry.getValue());
                    Object newObject = fl.getObject();
                    Method newMetod = fl.getMethod();
                    try {
                        try {
                            Thread.sleep(stringIntegerEntry.getValue());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        newMetod.invoke(newObject);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("\tAnnotation name: " + stringIntegerEntry.getKey());
                }
            }
        }
    }

    public static Map<String, forList> annotationHashMap (Object object){
        HashMap<String, forList> methodHashMap = new HashMap<>();

        Class clazz = object.getClass();
        Method[] allMethod = clazz.getDeclaredMethods();
        for (Method method : allMethod){
            forList newList = new forList();
            newList.setObject(object);
            newList.setMethod(method);
            newList.setMethodName(method.getName());
            Annotation[] allAnnotation = method.getDeclaredAnnotations();
            for (Annotation annotation : allAnnotation){
                if(annotation.annotationType().equals(annotationSleep.class)){
                    annotationSleep ann = (annotationSleep) annotation;
                    HashMap<String, Integer> map = new HashMap();
                    newList.putMap(ann.name(),ann.delay());
                }
                if(annotation.annotationType().equals(annotationSumm.class)){
                    annotationSumm ann = (annotationSumm) annotation;
                    HashMap<String, Integer> map = new HashMap();
                    newList.putMap(ann.name(),new Integer(0));
                }
                if(annotation.annotationType().equals(annotationRandom.class)){
                    annotationRandom ann = (annotationRandom) annotation;
                    HashMap<String, Integer> map = new HashMap();
                    newList.putMap(ann.name(),new Integer(0));
                }
                if(annotation.annotationType().equals(annotationPrintSomething.class)){
                    annotationPrintSomething ann = (annotationPrintSomething) annotation;
                    HashMap<String, Integer> map = new HashMap();
                    newList.putMap(ann.name(),new Integer(0));
                }
             }
            methodHashMap.put(method.getName(),newList);
        }

        return methodHashMap;
    }
}
