package Annotation.JavaRash;

import com.sun.xml.internal.bind.v2.TODO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MessageListener {
    private static final Map<String ,Method> commands = new HashMap<>();
    private static final CommandListener listener = new CommandListener();

    static
    {
        for (Method method: listener.getClass().getDeclaredMethods()){
            if (method.isAnnotationPresent(Command.class)){
                Command com = method.getAnnotation(Command.class);
                commands.put(com.name(),method);
                for (String s: com.aliases()){
                    commands.put(s,method);
                }
            }
        }
    }
    public void onMessageReceived(String st){
        String message = st.toLowerCase();
        if (message.startsWith("бот")){
            try{
                String[] arrayMess = message.split(" ");
                String command = arrayMess[1];
                String[] arrayArgs = Arrays.copyOfRange(arrayMess,2,arrayMess.length);
                Method m = commands.get(command);
                if (m == null){
                    //TODO
                    System.out.println("m == null");
                    return;
                }
                Command com = m.getAnnotation(Command.class);
                if (arrayArgs.length < com.minArgs()){
                    //TODO
                    System.out.println("<");
                }
                if (arrayArgs.length > com.maxArgs()){
                    //TODO
                    System.out.println(">");
                }
                m.invoke(listener,arrayArgs);
            }catch (ArrayIndexOutOfBoundsException e){

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
