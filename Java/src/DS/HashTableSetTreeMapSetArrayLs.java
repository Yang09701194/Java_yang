package DS;

import java.util.*;
import java.lang.Object;
import java.lang.Number;
import java.lang.Integer;


public class HashTableSetTreeMapSetArrayLs {


    //https://dotblogs.com.tw/kent2480/2014/01/10/139465

    //摘要:JAVA 集合(4) Map
    //
    //Map集合
    //該集合存儲鍵值對，而且要保證鍵的唯一性
    //增加
    // put(K key, V value)
    //putAll(Map<? extneds K, ?extends V> m)
    //刪除
    //clear()
    //remove(Object key)
    //判斷
    //containsKey(Object key)
    //containsVaule(Object value)
    //isEmpty()
    //獲取
    //value get(Object key)
    //size()
    //values()
    //entrySet()
    //keySet()

    //Map子類

    //Hashtable: 底層是雜湊表數據結構，不可存入null鍵null值，該集合是線程同步
    //HashMap: 底層是雜湊表數據結構，允許存入null鍵null值，該集合是不同步
    //TreeMap: 底層是二元樹數據結構，線程不同步，可以用於map集合中的鍵進行排序
    //Map和Set很像，Set底層就是使用Map集合

    public void Test1()
    {
        HashMap<String, String> map = new HashMap<String, String>();
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
        HashMap<String, String> map = new HashMap<String, String>();
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
        HashMap map = new HashMap();
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
    interface Map{
        public static interface Entry{
            public abstract Object getKey();
            public abstract Object getValue();
        }
    }
//
//    class HashMap implements Map{
//        class Hash implements Map.Entry{
//            public Object getKey();
//            public Object getValue();
//        }
//    }

    public void Test4()
    {
        //自定義比較器 依姓名排序 在依年齡排序
        TreeMap tm = new TreeMap(new StuNameComparator());
        tm.put(new Student("B", 21), "TW");
        tm.put(new Student("A", 18), "HK");
        tm.put(new Student("D", 25), "US");
        tm.put(new Student("C", 30), "JP");


        Set entrySet = tm.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            Student stu = (Student)me.getKey();
            String addr = (String)me.getValue();
            System.out.println(stu + "... " + addr);
        }
    }
    public void Test6()
    {
        String result = charCount("aiejoeifcea");
    }
    public String charCount(String str)
    {
        char[] chs = str.toCharArray();
        TreeMap tm = new TreeMap();

        for(int x = 0; x < chs.length ; x++){
            Integer value = (Integer)tm.get(chs[x]);
            if(value == null){
                tm.put(chs[x], 1);
            }else{
                value = value + 1;
                tm.put(chs[x], value);
            }
        }
        StringBuilder sb = new StringBuilder();
        Set entrySet = tm.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            Character ch = (Character)me.getKey();
            Integer value = (Integer)me.getValue();
            sb.append(ch + "(" + value + ")");
        }
        return sb.toString();
    }
    public static void mainSortDemo(String[] args){
        sortDemo();
    }
    public static void sortDemo(){
        List list = new ArrayList();
        list.add("asc");
        list.add("vdko");
        list.add("aqsqs");
        list.add("zaxce");
        list.add("plldw");

        sop(list); //[asc, vdko, aqsqs, zaxce, plldw]
        //Collections.sort(list);
        Collections.sort(list, new StrLenComparator());
        sop(list); //[asc, vdko, aqsqs, plldw, zaxce]
        sop(Collections.max(list)); // zaxce
    }
    public static void sop(Object obj){
        System.out.println(obj);
    }
    public static void sortDemo2(){
        List list = new ArrayList();
        list.add("c");
        list.add("b");
        list.add("a");

        Collections.reverse(list);
        sop(list);//[a, b, c]
        //fill方法可以將list集合中所有元素替換成指定元素
        Collections.fill(list, "123");
        sop(list);//[123, 123, 123]
        Collections.replaceAll(list, "123", "a");
        sop(list);//[a, a, a]
    }
    public static void Demo(){
        //reverseOrder
        TreeSet ts = new TreeSet(Collections.reverseOrder());
        ts.add("a");
        ts.add("b");
        ts.add("c");
        ts.add("d");
        Iterator it = ts.iterator();
        while(it.hasNext()){
            sop(it.next());
        }
    }

    //reverseOrder  原本是由字串長度由小到大，反轉後變由大到小
    public static void Demo3(){
        TreeSet ts = new TreeSet(Collections.reverseOrder(new StrLenComparator()));
        ts.add("aaaa");
        ts.add("bb");
        ts.add("c");
        ts.add("dddddd");

        Iterator it = ts.iterator();
        while(it.hasNext()){
            sop(it.next());
        }
    }

    //Collections其他方法:
    //非同步方法轉為同步方法:   static <T>List<T> synchronizedList(List<T> list)
    //隨機排列方法:   static void shuffle(List<?> list)

    //Collections其他方法:
    //非同步方法轉為同步方法:   static <T>List<T> synchronizedList(List<T> list)
    //隨機排列方法:   static void shuffle(List<?> list)
    //
    //Arrays用於操作陣列的工具類，其方法為靜態
    //Arrays轉List

    public static void array1(String[] args){
        int[] arr = {1, 2, 3};
        sop(Arrays.toString(arr));

        //asList將陣列轉為list集合
        //好處為可以使用集合的方法來操作陣列中的元素
        //注意: 將陣列轉為集合後, 不可以使用集合的增刪方法
        //因為陣列的長度是固定, 誤用會發生異常
        String[] arrStr = {"a", "b", "c"};
        List list = Arrays.asList(arrStr);
        sop(list);

        int[] nums = {2, 4, 5};
        List list2 = Arrays.asList(nums);
        sop(list2);//[[I@af993e]
        //如果陣列中的元素為物件, 那轉為集合後, 陣列中元素可直接轉為集合中的元素
        //如果陣列中的元素為基本數據類型, 那會將該陣列作為集合中的元素存在
        Integer[] nums2 = {1, 2, 3};
        List list3 = Arrays.asList(nums2);
        sop(list3);//[1, 2, 3]

    }

    public static void array2(String[] args){
        ArrayList al = new ArrayList();
        al.add("a");
        al.add("b");
        al.add("c");

        /**
         * 1. 指定類型陣列所需定義的長度?
         * 2. 若定義小於集合的size 則該方法內部會創建一個新的陣列 長度為集合size
         * 3. 若定義大於集合的size 則不會創建新陣列 而是使用傳遞過來的陣列
         * 利用al.size()最正確*/

        /**
         * 集合轉陣列原因
         * 為了限定元素的操作 限定增刪操做*/
        String[] arr = (String[])al.toArray(new String[0]);
        sop(Arrays.toString(arr));

    }

    //foreach
    //for(數據類型 變量名: 被遍歷集合或陣列)
    //對集合進行遍歷
    //只能獲取集合元素，但是不能對集合進行操作
    //
    //迭代器除了遍歷，還可以進行remove集合中元素的動作
    //如果用ListIterator，還可以在遍歷過程中對集合進行增刪改查的動作


    public static void for1 (String[] args){
        ArrayList al = new ArrayList();
        al.add("a");
        al.add("b");
        al.add("c");

        for(Object s : al){
            //s只能取出 不能修改
            sop(s);
        }
    }

    public static void CanVarParmLength(String[] args){
        show(2, 3, 4);
    }
    public static void show(int ...arr){
        System.out.println(arr.length);
    }


}


//import java.util.ArrayList;
////靜態導入: 導入的是Arrays這個類中所有靜態成員
//import static java.util.Arrays.*;
//import static java.lang.System.*;
//
//class Hello{
//    public static void main(String[] args){
//        int[] arr = {3, 1, 5};
//        sort(arr);
//        //當類名重名時,需指定具體的包名
//        //當方法重名時,指定具備所屬的物件或類
//        out.println(Arrays.toString(arr));
//    }
//}



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


//new Interger(value)  會被標為 deprecated  是因為
//有新的 Integer.valueOf()
//這邊是  官 方  文件   有提到
//https://docs.oracle.com/javase/9/docs/api/java/lang/Integer.html

//自定義比較器 依姓名排序 在依年齡排序
class StuNameComparator implements Comparator{
    public int compare(Object o1, Object o2){
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;
        int num = s1.getName().compareTo(s2.getName());
        if(num == 0)
            return Integer.valueOf(s1.getAge()).compareTo(new Integer(s2.getAge()));
        return num;
    }
}

class StrLenComparator implements Comparator{
    public int compare(Object o1, Object o2){
        String s1 = (String)o1;
        String s2 = (String)o2;
        if(s1.length() > s2.length()){
            return 1;
        }
        if(s1.length() < s2.length()){
            return -1;
        }
        return s1.compareTo(s2);
    }
}
