package DS;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTest {


    public static void HashTestFunc() {

        Enumeration names;
        String key;

        // Creating a Hashtable
        Hashtable<String, String> hashtable =
                new Hashtable<String, String>();

        // Adding Key and Value pairs to Hashtable
        hashtable.put("Key1","Chaitanya");
        hashtable.put("Key2","Ajeet");
        hashtable.put("Key3","Peter");
        hashtable.put("Key4","Ricky");
        hashtable.put("Key5","Mona");
        //  竟然是後蓋前  不是 每個key對一個 LinkedList
        //  證實確實如此 https://stackoverflow.com/questions/7212351/does-put-overwrite-existing-values/7212364
        //  這就讓我想起之前面 瑞 的時候  那時候記得考 的時候   看了一個介紹影片   是左邊每個key   對應到右邊  是一個Linked List
        //  這是印象   結果剛才一直查 都沒看到這種說法  反而看到了linear probing的做法   也就是發現collision的時候
        //  直接一直遞增  找下一個空位直接塞   然後這邊又看到  竟然也沒用linear probing 直接後蓋前  這麼沒創意的處理方式
        //  讓我反思  難道我之前看錯了
        //  結果才又找到一篇  說  右邊 LinkedList  也是一種處理方式

        //Option 1: By having each bucket contain a linked list of elements that are hashed to that bucket. This is
        // why a bad hash function can make lookups in hash tables very slow.
        //
        //Option 2: If the hash table entries are all full then the hash table can increase the number of buckets
        // that it has and then redistribute all the elements in the table. The hash function returns an integer and the hash table has to take the result of the hash function and mod it against the size of the table that way it can be sure it will get to bucket. So by increasing the size, it will rehash and run the modulo calculations which if you are luckymight send the objects to different buckets.
        //

        //  這也是一篇重點文章   HashMap和Hashtable的區別    面是必考題
        //  https://sziyu.pixnet.net/blog/post/30233792
        // HashMap幾乎可以等價於Hashtable，除了HashMap是非synchronized 的，並可以接受null(HashMap可以接受為null的鍵值(key)和值
        // (value)，而Hashtable則不行)。
        // HashMap是非synchronized，而Hashtable是synchronized
        // ，這意味著Hashtable是線程安全的，多個線程可以共享一個Hashtable
        // ；而如果沒有正確的同步的話，多個線程是不能共享HashMap的。Java 5提
        // 供了ConcurrentHashMap，它是HashTable的替代，比HashTable的擴展性更好。

        hashtable.put("Key5","Mona2");

        names = hashtable.keys();
        while(names.hasMoreElements()) {
            key = (String) names.nextElement();
            System.out.println("Key: " +key+ " & Value: " +
                    hashtable.get(key));
        }


    }
}
