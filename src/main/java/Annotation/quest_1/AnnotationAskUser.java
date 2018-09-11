package Annotation.quest_1;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Scanner;

public class AnnotationAskUser {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {

        System.out.print("Enter name annotation: ");
        Scanner scan = new Scanner(System.in);
        String userAnnotationName = "Annotation.quest_1." + scan.nextLine();

        Class cl = Class.forName("Annotation.quest_1.AnnotationClass");
        Method[] method = cl.getDeclaredMethods();
        for (Method mt: method){
            Annotation[] annotation = mt.getDeclaredAnnotations();
            for (Annotation an: annotation){
                if (an.annotationType().getName().equals(userAnnotationName)){
                    if (an.toString().contains("delay")){
                        String string = an.toString();
                        long sleep =  Long.valueOf(string.substring(string.indexOf("delay=")+6,string.indexOf(")")));
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

