package Annotation.Test;

public class SimpleService {

    @Service(name = "Service initService")
    public static void initService(){
        System.out.println("Method run 4");
    }
    @Init
    public static void laziService(){
        System.out.println("Method run 3");
    }

}
