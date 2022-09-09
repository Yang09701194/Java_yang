package DS;

import java.util.HashMap;
import java.util.*;

public class IteratorTest {

    public void Test1(){
        Map<String, String> map = new HashMap<>();
        //加入元素，加入時如果出現相同的鍵，則新的値會覆蓋原有的鍵對應值，並put方法會返回被覆蓋的値
        map.put("01","a");
        map.put("02","b");
        map.put("03","c");

        //https://stackoverflow.com/questions/46898/how-do-i-efficiently-iterate-over-each-entry-in-a-java-map
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        long i = 0;
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = it.next();
            System.out.println(pair.getKey() + "/" + pair.getValue());
        }


    }

}
