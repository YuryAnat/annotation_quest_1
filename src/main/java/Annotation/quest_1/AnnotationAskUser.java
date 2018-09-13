package Annotation.quest_1;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Scanner;

public class AnnotationAskUser {

    public static void main(String[] args) {

        boolean exit = false;

        do {
            System.out.print("Enter annotation name: ");
            Scanner scan = new Scanner(System.in);
            String userAnnotationName = scan.nextLine();

            if (userAnnotationName.equals("exit")) {
                exit = true;
            }else {
                AnnotationClass annotationClass = new AnnotationClass();
                try {
                    runMetodIfFindeAnnotation(annotationClass,userAnnotationName);
                } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }while (!exit);
    }

    public static void runMetodIfFindeAnnotation(Object object,String userAnnotationName) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Class cl = object.getClass();
        Method[] method = cl.getDeclaredMethods();
        for (Method mt: method){
            Annotation[] annotation = mt.getDeclaredAnnotations();
            for (Annotation an: annotation){
                if (an.annotationType().getSimpleName().equals(userAnnotationName)){
                    if (an.toString().contains("delay")){
                        String string = an.toString();
                        long sleep = 0;
                        String [] arrString = string.split(",");
                        for (String s : arrString) {
                            if (s.contains("delay")){
                                if (s.endsWith(")")){
                                    sleep = Long.valueOf(s.substring(s.indexOf("=")+1,s.length()-1));
                                }else {
                                    sleep = Long.valueOf(s.substring(s.indexOf("=")+1,s.length()));
                                }
                            }
                        }
                        System.out.println("Run method "+ mt.getName() + " and sleep " + sleep);
                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Object askObject = cl.newInstance();
                    mt.invoke(askObject);
                }
            }
        }
    }
}

