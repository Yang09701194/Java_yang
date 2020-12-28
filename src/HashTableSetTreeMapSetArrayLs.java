import java.util.*;


//

public class HashTableSetTreeMapSetArrayLs {
    public void Test1()
    {
        Map<String, String> map = new HashMap<>();
        //加入元素，加入時如果出現相同的鍵，則新的値會覆蓋原有的鍵對應值，並put方法會返回被覆蓋的値
        map.put("01", "a");
        map.put("02", "b");
        map.put("03", "c");
        System.out.println("containKey: " + map.containsKey("02"));//true
        System.out.println("remove: " + map.remove("03"));//c
        System.out.println(map);//{01=a, 02=b}
        //可以通過get方法的返回值來判斷一個鏈是否存在，通過返回null來判斷
        System.out.println("get: " + map.get("01"));//get: a
        map.put("04", null);

        //獲取集合中所有的値
        Collection<String> col = map.values();
        // [null, a, b]
        System.out.println(col);
    }
    public void Test2()
    {
        Map<String, String> map = new HashMap<>();
        map.put("01", "a");
        map.put("02", "b");
        map.put("03", "c");
        //獲取map集合中的所有鍵的Set集合, keySet()
        Set keySet = map.keySet();
        //有了set集合就可以獲取迭代器
        Iterator it = keySet.iterator();
        while(it.hasNext()){
            String key = it.next().toString();
            //有了鍵就可以通過map集合的get方法獲取其對應的値
            String value = map.get(key);
            System.out.println("key: " + key + ", vaule: " + value);
            //key:01, vaule: a  key: 02,vaule: b  key: 03, vaule: c
        }
    }
    public void Test3()
    {
        Map map = new HashMap();
        map.put("01", "a");
        map.put("02", "b");
        map.put("03", "c");
        //將map集合中的映射關係取出，存入到Set集合中
        Set entrySet = map.entrySet();

        Iterator it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            String key = (String)me.getKey();//
            String value = (String) me.getValue();
            System.out.println("key: " + key + ", vaule: " + value);
        }
    }
//    Map.Entry: 其實Entry也是一個介面，他是Map介面中的一個內部介面
//
//    interface Map{
//        public static interface Entry{
//            public abstract Object getKey();
//            public abstract Object getValue();
//        }
//    }
//
//    class HashMap implements Map{
//        class Hash implements Map.Entry{
//            public Object getKey();
//            public Object getValue();
//        }
//    }

    public void Test4()
    {

    }
    public void Test5()
    {

    }
    public void Test5()
    {

    }
    public void Test5()
    {

    }

}



class Student implements Comparable{
    private String name;
    private int age;

    @Override
    public int compareTo(Object o){
        var s = (Student)o;
        int num = new Integer(this.age).compareTo(new Integer(s.age));
        if(num == 0)
            return this.name.compareTo(s.name);
        return num;
    }
    //hasCode()與equals()方法用來排除相同元素的重覆
    public int hashCode(){
        return name.hashCode() + age*34;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Student))
            throw new ClassCastException("不屬於Student類");
        Student s = (Student)obj;
        return this.name.equals(s.name) && this.age == s.age;
    }

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String toString(){
        return name + ": " + age;
    }


}
