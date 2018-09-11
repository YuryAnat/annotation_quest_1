package Annotation.Test;
public class LazyService {

    @Service(name = "Srvice lazi")
    public static void lazyServ(){
        System.out.println("Method run 1");
    }

    @Init
    public static void InitServ(){
        System.out.println("Method run 2");
    }
}
