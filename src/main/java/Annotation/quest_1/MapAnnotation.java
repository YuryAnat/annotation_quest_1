package Annotation.quest_1;

import Annotation.quest_1.annotation.annotationPrintSomething;
import Annotation.quest_1.annotation.annotationRandom;
import Annotation.quest_1.annotation.annotationSleep;
import Annotation.quest_1.annotation.annotationSumm;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapAnnotation {

    public static void main(String[] args) {
        boolean exit = true;
        boolean tmp = true;

        while (exit){
            System.out.println("Enter \"exit\" for out.");
            System.out.print("Enter name annotation: ");
            Scanner scan = new Scanner(System.in);
            String userAnnotationName = scan.nextLine();

            AnnotationClass aClazz = new AnnotationClass();
            Map<String,ForList> newMap = annotationHashMap(aClazz);


                if (userAnnotationName.toLowerCase() == "exit") exit = false;
                for (Map.Entry<String, ForList> entry : newMap.entrySet()) {
                    ForList fl = entry.getValue();
                    for (Map.Entry<String,Integer> stringIntegerEntry : fl.getAnnotationNameAndArgs().entrySet()) {
                        if (stringIntegerEntry.getKey().equals(userAnnotationName)){
                            Object newObject = fl.getObject();
                            Method newMethod = fl.getMethod();
                            if (stringIntegerEntry.getValue()> 0){
                                System.out.println("\tAnnotation name: " + stringIntegerEntry.getKey() + ", delay: " + stringIntegerEntry.getValue());
                                tmp = false;
                                try {
                                    try {
                                        Thread.sleep(stringIntegerEntry.getValue());
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    newMethod.invoke(newObject);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }else {
                                System.out.println("\tAnnotation name: " + stringIntegerEntry.getKey());
                                tmp = false;
                                try {
                                    newMethod.invoke(newObject);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                }
                if (tmp) System.out.println("Annotation not found");
            }




    }

    public static Map<String, ForList> annotationHashMap (Object object){
        HashMap<String, ForList> methodHashMap = new HashMap<>();

        Class clazz = object.getClass();
        Method[] allMethod = clazz.getDeclaredMethods();

        for (Method method : allMethod){
            ForList newList = new ForList();
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
