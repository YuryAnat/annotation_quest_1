package Annotation.quest_1;

@annotationInit
public class AnnotationClass {

    @annotationRandom(num = 100+1)
    public void Test1(){

    }

    @annotationSumm(num_1 = 20, num_2 = 10)
    public void Test2(){

    }

    @annotationSleep(delay = 5)
    @annotationPrintSomsing(somesing = "Doves say ururu")
    public void Test3(){

    }

    @annotationRandom(num = 50+1)
    @annotationSleep(delay = 10)
    public void Test4(){

    }
}
