package Annotation.quest_1;

import Annotation.quest_1.annotation.annotationPrintSomething;
import Annotation.quest_1.annotation.annotationRandom;
import Annotation.quest_1.annotation.annotationSleep;
import Annotation.quest_1.annotation.annotationSumm;

public class AnnotationClass {

    @annotationRandom()
    public void Test1(){
        System.out.println("run Test1");
    }

    @annotationSumm()
    public void Test2(){
        System.out.println("run Test2");
    }

    @annotationSleep(delay = 5000)
    @annotationPrintSomething()
    public void Test3(){
        System.out.println("run Test3");
    }

    @annotationRandom()
    @annotationSleep(delay=10000)
    public void Test4(){
        System.out.println("run Test4");
    }
}
