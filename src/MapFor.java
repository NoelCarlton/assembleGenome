import java.util.HashMap;
import java.util.Map;

/**
 * Created by noel on 2018/7/31.
 */
public class MapFor {

    public static void main(String[] args){
        forMap();
    }
    public static void forMap(){
        Map<String, String> map = new HashMap<String, String>();
        String key, value;
        for (int i = 1; i <= 100; i++) {
            key = "" +i;
            value = "value"+i+"==";
            map.put(key, value);
        }
        for(String kesy:map.keySet()){
            String values = map.get(kesy);
            System.out.println(kesy+"------------------"+values);
        }
    }
}
