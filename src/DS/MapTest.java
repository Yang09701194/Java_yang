package DS;

import java.util.*;

//By definition, the put command replaces the previous value associated with the given key in the map (conceptually like an array indexing operation for primitive types).
//
//The map simply drops its reference to the value. If nothing else holds a reference to the object, that object becomes eligible for garbage collection. Additionally, Java returns any previous value associated with the given key (or null if none present), so you can determine what was there and maintain a reference if necessary.


public class MapTest {

    public void Test1(){
        Map<String, String> map = new HashMap<>();
        //加入元素，加入時如果出現相同的鍵，則新的値會覆蓋原有的鍵對應值，並put方法會返回被覆蓋的値
        map.put("01","a");
        map.put("02","b");
        map.put("03","c");
        System.out.println("containKey: "+map.containsKey("02"));//true
        System.out.println("remove: "+map.remove("03"));//c
        //System.out.println(map);//{01=a, 02=b}
        //可以通過get方法的返回值來判斷一個鏈是否存在，通過返回null來判斷
        System.out.println("get: "+map.get("01"));//get: a
        map.put("04",null);

        //獲取集合中所有的値
        Collection<String> col = map.values();
        // [null, a, b]
        //System.out.println(col);//{01=a, 02=b}
    }

}
