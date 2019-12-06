/**
 * Created by noel on 2018/7/6.
 */
public class Reflect {
}
class Hello{
    public static void main(String[] args){
        Reflect reflect = new Reflect();
        System.out.println(reflect.getClass());
        System.out.println(reflect.getClass().getName());
        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
