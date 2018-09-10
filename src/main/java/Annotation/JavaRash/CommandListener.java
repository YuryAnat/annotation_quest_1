package Annotation.JavaRash;

import java.lang.reflect.Method;

public class CommandListener {
    @Command(name = "привет", args = "", desc = "будь культурным, поздаровайся", aliases = {"ку"} )
    public void hello(){
        
    }
    @Command(name = "пока", args = "", desc = "", aliases ={"чао"})
    public void bai(){

    }
    @Command(name = "помощь", args = "", desc = "список команд", aliases ={"?","помощь","команды"} )
    public void help(){
        StringBuilder sb = new StringBuilder("Список команд \n");
        for (Method m : this.getClass().getDeclaredMethods()){
            if (m.isAnnotationPresent(Command.class)){
                Command com = m.getAnnotation(Command.class);
                if (com.showHelp()){
                    sb.append("Бот, ").append(com.name()).append(" ").append(com.args()).append(" - ");
                }
            }
        }
        System.out.println(sb.toString());
    }
}

