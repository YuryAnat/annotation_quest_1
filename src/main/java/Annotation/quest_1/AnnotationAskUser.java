package Annotation.quest_1;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class AnnotationAskUser {

    public static void main(String[] args) throws ClassNotFoundException {
        String userAnnotation;
        Scanner scan = new Scanner(System.in);
        userAnnotation = scan.toString();
        Class cl = Class.forName("Annotation.quest_1.AnnotationClass");
        Method[] method = cl.getMethods();
        for (Method m : method){
            if (m.isAnnotationPresent(annotationPrintSomsing.class)){
                System.out.println();
            }
        }
        System.out.println(Arrays.deepToString(method));
    }
}

