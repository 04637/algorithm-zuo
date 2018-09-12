import java.lang.reflect.Method;
import java.util.Collections;

public class Test {
    private String toString1(){
        return "1";
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls = Test.class;
        Method[] methods = cls.getDeclaredMethods();

        for (Method m :
                methods) {
            System.out.println(m);
        }
        System.out.println(methods);
    }
}
