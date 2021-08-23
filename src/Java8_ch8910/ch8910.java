package Java8_ch8910;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.*;

//  https://docs.oracle.com/javase/8/docs/
//  https://docs.oracle.com/javase/8/docs/api/index.html
public class ch8910 {
    public static void content() {

        //ch8.content();
        ch9.content();
        //ch10.content();
    }
}

class ch8 {
    public static void content() {
        int[] arr = new int[10];
        //  例外處理  8-2 p262
        try {
            arr[50] = 120;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: " + e.toString());
            // java.lang.ArrayIndexOutOfBoundsException: 50

            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter( writer );
            e.printStackTrace( printWriter );
            printWriter.flush();
            String stackTrace = writer.toString();
            System.out.println("Exception: " + stackTrace);
            //Ex: java.lang.ArrayIndexOutOfBoundsException: 50
            //	at Java8_ch8910.ch8.content(ch8910.java:22)
            //	at Java8_ch8910.ch8910.content(ch8910.java:11)
            //	at test.main(test.java:11)

        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.toString());
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
        } finally {
            System.out.println("finally");
        }
        System.out.println("end");

        //https://medium.com/@clu1022/java%E7%AD%86%E8%A8%98-exception-%E8%88%87-error-dbdf9a9b0909
        //關於 Exception 與 Error 的基本概念
        //Exception 與 Error 都是繼承自 Throwable, 在 Java 的世界裡, 只有 Throwable 類型的 instance 才可以被 throw 或著 catch, 其為 exception handling 的基本組成類型. 至於 Exception 與 Error 的差異, 這部分就體現出了 Java 設計者對不同異常情境的分類:
        //Exception: 通常指程式運行時所出現的可預料之意外狀況, 基本上都要進行 catch 的動作, 然後進行相應處理, 如 IOException.
        //Error: 指在正常情況下, 不太可能出現的問題, 絕大部分的 Error 都會導致程式 (e.g. JVM 本身) 處於一種不正常且不可恢復的狀態. 所以對於這種情況, 你也不太需要去 catch 了, 因為也沒什麼意義. 常見的如 OutOfMemoryError / StackOverflowError 這些, 都是繼承自 Error.

        // throw
        try {
            Scanner scn = new Scanner(System.in);
            double dividend = 55;
            System.out.println("請輸入除數:");
            double divisor = scn.nextDouble();
            if(divisor == 0)
                throw new ArithmeticException("denominator is zero");
            System.out.println("香除結果:" + dividend/divisor);
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.toString());
        }

        //  throws 宣告方法可能產生的例外
        //  static void showSalary(String name, int money) throws IllegalArgumentException, ArithmeticException

        //  自訂 Exception  8-18 p278
        //  extends Exception 後 override Throwable  常用的方法
        //  String getLocalizedMessage()  String getMessage()
        //  String toString()  Throwable getCause()  Throwable fillInStackTrace()
        //  void printStackTrace()
    }
}

class ch9 {
    public static void content() {

        //  集合與泛型
        //  Java Collections Framework
        //  集合介面
        //  Collections
        //    > Set > Sorted Set
        //    > List
        //  Map > SortedMap

        //  介面  實作類別
        //  Set  HashSet // 唯一性
        //  SortedSet TreeSet  //  排序性  唯一性
        //  List  ArrayList LinkedList  //  可重複 循序性
        //  Map HashMap // 鍵值對應唯一
        //  SortedMap  TreeMap //  排序性 鍵值對應唯

        //  集合可以存不同類型的物件 取出時要知道元素型別再轉換 不方便
        //  使用有樣板性質的 泛型型別 Generic Type 就可存同型別的資料
        //  集合實作<E> ls = new 集合實作<E>();
        HashSet<Integer> hset = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Collection<Integer> collection = new HashSet<>();
        //  TreeSet SortedSet 同
        Set<Integer> testSet = new HashSet<>();
        testSet.add(2); testSet.add(3);
        set.isEmpty(); set.add(3);// 不存在 true 已存在 false
        set.addAll(testSet); set.size();
        set.contains(4); set.containsAll(testSet); set.remove(4);
        set.removeAll(testSet); set.retainAll(testSet);//保留 test 移除其他
        set.clear();  set.equals(testSet);//元素相同

        //https://stackoverflow.com/questions/18021218/create-a-list-of-primitive-int
        //In Java the type of any variable is either a primitive type or a reference type. Generic type arguments must be reference types. Since primitives do not extend Object they cannot be used as generic type arguments for a parametrized type.

        //  HashSet 三種建構式
        HashSet hs = new HashSet();// initial capacity 16
        HashSet hs2 = new HashSet(testSet);
        HashSet hs3 = new HashSet(64); // 指定 initial capacity
        System.out.println(hs2);//[2, 3]

        //  9-10 p298
        SortedSet<String> testTs = new TreeSet<>();
        testTs.add("test1");testTs.add("test2");
        TreeSet<String> ts = new TreeSet<>();// 三種建構式
        TreeSet<String> ts2 = new TreeSet<>(testTs);// treeset
        TreeSet<String> ts3 = new TreeSet<>(hs);// collection
        ts.first(); ts.last(); ts.headSet("test3");//所有小於 ele
        ts.tailSet("test0");//大於等於 ele
        ts.subSet("test1", "test3");//大於等於 小於 ele

        List<Boolean> test = new ArrayList<>();// init capacity 10
        List<Boolean> arrLs = new ArrayList<>();
        arrLs.add(true); arrLs.add(1, false);
        arrLs.addAll(test); arrLs.addAll(2, test);
        arrLs.get(3);//by index
        arrLs.indexOf(3);/*by ele*/ arrLs.lastIndexOf(3);//by ele
        arrLs.remove(3);/*by index*/ arrLs.set(2,false);
        arrLs.subList(2, 5); // =< <   C# GetRange

        List<Boolean> ls2 = new ArrayList<>(hs);//collection
        ArrayList<Boolean> ls3 = new ArrayList<>(65);//capacity
        ls3.ensureCapacity(263); ls3.trimToSize();

        //  LinkedList  節點指向 null 表結尾
        //  記憶體可能散布  每個節點有  資料欄本身 和鏈結指標  指向下個節點記憶體位置
        LinkedList<String> testlls = new LinkedList<>();
        LinkedList<String> lls = new LinkedList<>(testTs);//collection
        //  共用 List 的方法
        lls.addFirst("8"); lls.addLast("6"); lls.removeFirst(); lls.removeLast();
        lls.getFirst(); lls.getLast();
        //  適合實作  Queue FIFO  Stack LIFO

        Map<String, String> mtest = new HashMap<>();
        Map<String, String> m = new HashMap<>();
        m.put("8","5");//upsert
        mtest.put("3","5");
        m.containsKey("8");m.containsValue("5");m.isEmpty(); m.putAll(mtest);
        m.get("3"); m.remove("4"); m.size();
        m.keySet();//key 唯一 故可轉 Set
        m.values();//key 不唯一 故轉 Collection
        m.clear();

        Map<String, String> m2 = new HashMap<>(mtest);
        Map<String, String> m3 = new HashMap<>(321);//init cap

        SortedMap<String, String> sortedMap = new TreeMap<>();
        SortedMap<String, String> sortedMap2 = new TreeMap<>(m2);
        SortedMap<String, String> sortedMap3 = new TreeMap<>(sortedMap);
        sortedMap.put("p","p");sortedMap.put("p2","p3");sortedMap.put("p3","p3");
        sortedMap.firstKey(); sortedMap.lastKey();
        sortedMap.headMap("p2"); // < key
        sortedMap.tailMap("p2"); // >= key
        sortedMap.subMap("p2", "p3"); //  =<  <

        //  9-27 p315
        //  Collections 非介面 是 Coleection 介面的工具類別 都 static
        Collections.sort(ls3); Collections.reverse(ls3);
        Collections.copy(ls3, ls2); Collections.fill(ls3, false);
        Collections.max(ls3); // min
        Collections.swap(ls3, 1, 3); // min
        //  ascii  uppercase < lowercase   A 65 a 97

        //  fill example https://www.geeksforgeeks.org/collections-fill-method-in-java-with-examples/
        // creating object of List<Integer>
        List<String> arrlist = new ArrayList<String>();
        // Adding element to srclst
        arrlist.add("A");arrlist.add("B");arrlist.add("C");
        // print the elements
        System.out.println("List elements before fill: " + arrlist);
        Collections.fill(arrlist, "TAJMAHAL");
        //List elements before fill: [A, B, C]
        //List elements after fill: [TAJMAHAL, TAJMAHAL, TAJMAHAL]

        //  Iterator<E> 集合走訪器  Collection 都支援  可讀可刪  單向走訪
        Iterator<Integer> iter = hset.iterator();
        iter.hasNext(); iter.next(); iter.remove();

        //  ListIterator 雙向走訪器
        ListIterator<Boolean> lsIter = arrLs.listIterator();
        ListIterator<Boolean> lsIter2 = arrLs.listIterator(2);
        lsIter.hasNext(); lsIter.hasPrevious();
        lsIter.next(); lsIter.previous(); lsIter.nextIndex();
        lsIter.previousIndex(); lsIter.add(true);
        lsIter.set(true);/*update*/  lsIter.remove();
    }
}

class ch10 {
    public static void content() throws InterruptedException {
        //  多執行緒
        //  OS 是一套系統軟體 管理電腦硬體軟體資源的程式 對一個將要執行的應用程式(process)
        //  進行記憶體管理 CPU Time 配置 決定優先執行順序 輸出入裝置控制 網路連線 檔案系統管理 基本工作
        //  Process 彼此獨立   MulitTasking 可兩以上程式同時執行 將CPU分割Time Slice
        //  快速切換輪流執行
        //  Intel Core i7 Processor Extreme Edition 六核心處理器 CPU 速率高達 4GHZ
        //  有超執行緒 可虛擬成 12 執行緒 更發揮 MultiTasking
        //
        //  多執行緒  Multi Threading  又稱  Light-Weighted Process   有多核心CPU支援
        //  可以平行處理增加效能  一個 process 可有多 thread  彼此間共享某塊記憶體
        //  降低彼此控制權轉移負擔 但沒有os保護措施 交由pg控制

        //  MultiTask-Process   MultiThread-Thread

        //  Java 的執行緒優先順序 由 JVM 決定  主執行緒 + 其他緒

        //  執行緒生命週期
        //         start()            v yield() ^
        //  New -------------------->  Runnable   <-----------
        //          -------------------^  | ^ Scheduler       |
        //  getLock |                     V |                 |
        //  Lock Pool<--Synchronized-- Running --sleep() -> Blocked
        //   ^  notify()               |    |
        //   |  notifyAll()      wait()|    v
        //  Wait Pool   <---------------   Dead

        //  new 完 Thread 進 Runnable  start() 啟動後 呼叫Thread 的 run() 進 Running
        //  程式若執行 yield() 會將執行權讓出 進 Runnable
        //  Running 的執行時間 由 scheduler 決定  時間到回 Runnable
        //  如果呼叫 sleep() 進 Blocked 暫停 進入 sleeping 狀態  休眠時間到 回 Runnable
        //  Running 如果呼叫 wait() 讓出使用權 進 Wait Pool    wait() 繼承自 Object
        //  notify/All() 喚醒 WaitPool 轉到 LockPool  執行緒進入同步區塊 也會進 LockPool
        //  競爭 lock 拿到進 Runnable      執行完進 Dead

        //  兩方式建立 Thread  直接用 Thread 或 繼承 Thread 類直接產生  自訂類實作 Runnable 介面間接產生 較有彈性

        //  10-5 p335
        //  1 直接用 Thread 或 繼承 Thread 類直接產生  override run()   呼叫 start() 會 run()
        Thread t = new Thread("thName"/*可選參數*/){
            public void run(){
                for (int i = 0;i <= 20; i++){
                    System.out.println("車子共開" + i +"公里");
                }
            }
        };
        //  Java8 Lambda
        Thread t2 = new Thread( ()->{
            for (int i = 0;i <= 20; i++){
                if((int)(Math.random() * 10 + 1) % 2 == 0){
                    i -= 4;
                } else{
                    System.out.println("腳踏車共騎" + i +"公里");
                }

            }
        });
        t.start(); //t2.start();
        class MyThread extends Thread {
            int idx = 0;
            String threadName;
            public MyThread(int idx, String name){
                this.idx = idx; threadName = name;
                //start();  //  如果有加 new 完直接開始執行 不用再 start()
            }
            public void run(){
                try {
                    System.out.println("MyThread");
                    sleep(500);//ms
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }
            }
        }
        // Java 10 var
        var myt = new MyThread(1, "test");
        myt.start();

        //  2 自訂類實作 Runnable 介面間接產生 較有彈性   只是準執行緒 執行時要傳入 new Thread
        class MyIThread implements Runnable{
            public void run(){
                System.out.println("MyIThread");
            }
        }

        var ithreadObj =new MyIThread();
        Thread thread = new Thread(ithreadObj, "ThName"/*可選參數*/);
        thread.setName("thread 2 Name");
        thread.getName();
        thread.start();
        Thread.currentThread().getName();
        if(thread.isAlive())
            System.out.println(thread.getName());
        thread.setPriority(Thread.MIN_PRIORITY);   thread.getPriority();
        // Thread.MAX_PRIORITY   Thread.NORM_PRIORITY
        t2.start(); // start() 會呼叫 run()
        System.out.println("execute");//這邊如果在 join() 前有加動作  會比 t2 先執行  下面才換 t2 切換近來同步執行 10-32
        t2.join(); // start + join 變依序同步執行

        //  執行緒同步 避免同一個時間點 有多個執行緒存取修改同個物件  JVM 提供 synchronized 關毽字
        //  相當於 C# 的 lock (obj)  一次只允許一個 Thread 進入  其他 Thread 會先進入 interrupt 狀態等待
        //  synchronized 可以宣告在 Thread 的 run 調用的方法   或是 local
        //  Thread 見下方 GoldClass
        //  local  https://stackoverflow.com/questions/43134998/is-it-reasonable-to-synchronize-on-a-local-variable
        class Customer {}
        Customer customer = new Customer();// getCustomer() 通常應該宣告放在方法外的變數
        synchronized(customer) {
            //only one thread at a time can access customer object
            //which ever holds the lock
        }
        //In the above code, customer is a local reference variable, but you are still using a synchronized block to restrict access to the object customer is pointing to (by a single thread at a time).
        //
        //In Java memory model, objects live in heap (even though references are local to a Thread which live in a stack) and synchronization is all about restricting access to an object on the heap by exactly one thread at a time.

        // C# https://stackoverflow.com/questions/5053172/why-does-the-lock-object-have-to-be-static
        //The main time you see a static lock is for a global cache, or for deferred loading of global data / singletons. And in the latter, there are better ways of doing it anyway.
        //
        //So it really depends: how is Locker used in your scenario? Is it protecting something that is itself static? If so, the lock should be static. If it is protecting something that is instance based, then IMO the lock should also be instance based.

        //  10-25 p355
        //  Transaction ATM 確保一個帳戶多人存提款 synchronized

        //  Thread 等待 喚醒  Object 提供三種方法
        //  wait() 讓 Thread 進入 Wait Pool 等待狀態 每個物件都有自己的 Wait Pool
        //  wait() 要寫在 synchronized 區段 配合 try catch Synchronized Ex
        //  避免其他 Thread notify/all 喚醒不能喚醒的 Thread 要寫在 while 中搭配條件
        //  notify() 喚醒一個 wait pool 中的 Thread  JVM 決定喚醒哪個
        //  notifyAll() 喚醒 all wait pool 中的 Thread  JVM 決定執行順序
        //  主人丟飛盤 小狗接 兩個不同 Thread   wait notify 輪流切換等待通知執行動作

    }
}






//  ch8
//  Exception Hierachy
//
//Throwable
//    Error
//        AssertionError
//                LinkageError
//        BootstrapMethodError
//                ClassCircularityError
//        ClassFormatError
//                UnsupportedClassVersionError
//        ExceptionInInitializerError
//                IncompatibleClassChangeError
//        AbstractMethodError
//                IllegalAccessError
//        InstantiationError
//                NoSuchFieldError
//        NoSuchMethodError
//                NoClassDefFoundError
//        UnsatisfiedLinkError
//                VerifyError
//        ThreadDeath
//                VirtualMachineError
//        InternalError
//                OutOfMemoryError
//        StackOverflowError
//                UnknownError
//    Exception
//        CloneNotSupportedException
//        InterruptedException
//                IOException
//        FileNotFoundException
//                SocketException
//        ConnectException
//                UnknownHostException
//        ReflectiveOperationException
//                ClassNotFoundException
//        IllegalAccessException
//                InstantiationException
//        InvocationTargetException
//                NoSuchFieldException
//        NoSuchMethodException
//                RuntimeException
//        ArithmeticException
//                ArrayStoreException
//        ClassCastException
//                ConcurrentModificationException
//        EnumConstantNotPresentException
//                IllegalArgumentException
//        IllegalThreadStateException
//                NumberFormatException
//        IllegalMonitorStateException
//                IllegalStateException
//        IndexOutOfBoundsException
//                ArrayIndexOutOfBoundsException
//        StringIndexOutOfBoundsException
//                NegativeArraySizeException
//        NullPointerException
//                SecurityException
//        TypeNotPresentException
//                UnsupportedOperationException

//  ch8
class ThrowsDemo {
    public static void main(String[] args) {
        try {
            showSalary("王小明", 35000);
            showSalary("李小華", 50000);
        }
        catch(IllegalArgumentException e) {  //捕捉自行抛出的例外
            System.out.println("例外內容：" + e.getMessage());
        }
    }

    static void showSalary(String name, int money) throws IllegalArgumentException, ArithmeticException {
        if(money>=20000 && money<=40000)
            System.out.println("員工：" + name + "\t底薪：" + money +
                    "\t獎金：" + (int)money * 0.08 + "\n");
        else if (money < 0)
            throw new ArithmeticException("money should not less than 0");
        //自行抛出例外物件
        else
            throw new IllegalArgumentException("呼叫方法引數錯誤");    //自行抛出例外物件
    }
}
//ch8
class BankException extends Exception { //BankException繼承Exception
    public String toString() {   //覆寫Throwable類別的toString()方法
        return "發生BankException類別的例外!";
    }
    public String getMessage() {  //覆寫Throwable類別的getMessage()方法
        return "帳戶餘額不可以是負數!";
    }
    public void showMessage() {  //showMessage()方法是自定的方法
        System.out.println("設定帳號請小心，發生例外了!");
    }
}
class Bank {
    String accno;
    String name;
    long account;
    void setAcc(String cno,String cname,long m) throws BankException {
        System.out.println("設定 " + cname + " 的帳戶!");
        if (m < 0) {
            throw new BankException();  //拋出BankException自定例外類別的物件實體
        }
        else {
            accno = cno;
            name = cname;
            account = m;
        }
    }
    void showData() {
        System.out.println("帳戶編號： " + accno);
        System.out.println("客戶姓名： " + name);
        System.out.println("帳戶餘額： " + account + "\n");
    }
}
class MyException {
    public static void main(String[] args) {
        try {
            Bank Jack=new Bank();
            Jack.setAcc("A0001","Jack",40000);
            Jack.showData();
            Bank Lung=new Bank();
            Lung.setAcc("B0001","Lung",-50000);
            Lung.showData();  //此行不會執行
        }
        catch (BankException e) { //補捉自行定義的BankException類別例外
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            e.showMessage();
        }
    }
}
// ch9
class HashSetDemo{
    public static void main(String[] args)
    {
        HashSet<Integer> hset = new HashSet<>();
        int order = 1, num;
        Scanner keyin = new Scanner(System.in);
        System.out.println("請從1~49的整數中，輸入6個不重複的號碼....\n");

        while(order <= 6)
        {
            System.out.print("第 " + order + " 個號碼 ? ");
            try
            {
                num = Integer.parseInt(keyin.nextLine());
            }
            catch(NumberFormatException ex){
                System.out.println("請輸入數值！");
                continue;
            }
            if(num >= 1 && num <= 49)
            {
                if(hset.add(num)) order++;
                else System.out.println("號碼重複輸入！");
            }
            else System.out.println("號碼範圍錯誤！");
        }
        System.out.println("\n6個號碼分別為：");
        System.out.println(hset);
    }
}
// ch9
class TreeSetDemo{
    public static void main(String[] args)
    {
        TreeSet<Integer> tset = new TreeSet<>();
        System.out.println("電腦從1~100的整數中，亂數取出10個不重複的號碼....\n");
        for(int i=1; i<=10; i++)
        {
            while(true)
            {
                int num = (int)(Math.random() * 100) + 1;
                if(tset.add(num))
                {
                    System.out.println("第 " + i + " 個號碼：" + num);
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("物件內元素個數為：" + tset.size());
        System.out.println("物件內元素的內容：" + tset);
        System.out.println("第一個元素內容為：" + tset.first());
        System.out.println("最後一個元素內容：" + tset.last());
        System.out.println("內容介於30～70者：" + tset.subSet(30, 71));
    }
}
//  ch9
class ArrayListDemo{
    public static void main(String[] args)
    {
        System.out.println("～東部旅遊夜宿規劃～");
        ArrayList<String> night = new ArrayList<>();
        String[] place = {"宜蘭", "花蓮", "天祥", "台東"};
        for(String p : place)
            night.add(p);
        System.out.println("初期規劃夜宿地點：" + night);
        System.out.println("初期規劃夜宿天數：" + night.size());
        night.add("知本");
        night.add(3,"花蓮");
        System.out.println("修訂後夜宿地點：" + night);
        System.out.println("修訂後規劃夜宿天數：" + night.size());
        System.out.println("夜宿天祥規劃在第幾天：" + (night.indexOf("天祥")+1));
        System.out.println("刪除花蓮第一夜...");
        night.remove(night.indexOf("花蓮"));

        System.out.println("\n～確定夜宿表列～");
        for(int i=0; i<night.size(); i++)
            System.out.println("第 " + (i+1) + " 天夜宿地點：" + night.get(i));
    }
}
//  ch9
class LinkedListDemo{
    public static void main(String[] args)
    {
        String[] place = {"宜蘭", "天祥", "花蓮", "台東", "知本"};
        ArrayList<String> night = new ArrayList<>();
        for(String p : place)
            night.add(p);
        System.out.println("串列元素前後順序");
        for(int i=0; i<night.size(); i++)
            System.out.println("第 " + (i+1) + " 個：" + night.get(i));

        LinkedList<String> queue = new LinkedList<>(night);
        System.out.println("\n取出方式(佇列)：先進先出");
        for(int j=queue.size()-1; j>=0; j--)
        {
            System.out.print(queue.getFirst() + "  ");
            queue.removeFirst();
        }
        System.out.println();

        LinkedList<String> stack = new LinkedList<>(night);
        System.out.println("\n取出方式(堆疊)：後進先出");
        while(true)
        {
            System.out.print(stack.removeLast() + "  ");
            if(stack.isEmpty()) break;
        }
        System.out.println("");
    }
}
//  ch9
class HashMapDemo{
    public static void main(String[] args)
    {
        HashMap<String, String> hmap = new HashMap<>();
        hmap.put("何九山", "教師");
        hmap.put("張三谷", "牧師");
        hmap.put("李四斐", "警察");
        hmap.put("周六圖", "教師");
        System.out.println("集合內容：" + hmap);
        System.out.println("hmap集合的元素個數：" + hmap.size());
        System.out.println();

        System.out.println("\"何九山\" 重複加入....");
        if (hmap.containsKey("何九山"))
            System.out.println("\"何九山\" 已存在，重複加入時職業欄資料會被覆蓋");
        hmap.put("何九山", "軍人");
        System.out.println("\"何九山\" 的職業更改為：" + hmap.get("何九山"));

        System.out.println("\n加入\"曹五操\" ....");
        String name = "曹五操";
        if (hmap.containsKey(name))
            System.out.println("\"" + name +"\" 已存在，不接受更改");
        else
            hmap.put(name, "律師");

        System.out.println("移除\"周六圖\" ....");
        hmap.remove("周六圖");

        System.out.println("\n集合內容：" + hmap);
    }
}
//  ch9
class TreeMapDemo{
    public static void main(String[] args)
    {
        TreeMap<Integer, String> tmap = new TreeMap<>();
        tmap.put(260, "宜蘭");
        tmap.put(970, "花蓮");
        tmap.put(500, "彰化");
        tmap.put(900, "屏東");
        tmap.put(600, "嘉義");
        System.out.println("集合內容：" + tmap);
        System.out.println("集合的元素個數：" + tmap.size());
        int key = tmap.firstKey();
        System.out.println("集合的第一個郵遞區號：" + key);
        System.out.println("集合的第一個地名：" + tmap.get(key));
        System.out.println("集合的最後一個郵遞區號：" + tmap.lastKey());
        System.out.println("集合的最後一個地名：" + tmap.get(tmap.lastKey()));
        System.out.println("郵遞區號大於等於" + 600 + "的元素集合：" +
                tmap.tailMap(600));
    }
}
//  ch9
class CollectionsDemo
{
    public static void main(String[] args)
    {
        ArrayList<String> alist = new ArrayList<>();
        String[] data = {"EEE", "CCC", "BBB", "DDD", "AAA"};
        for(String p : data)
            alist.add(p);
        System.out.println("顯示alist集合物件初始元素...");
        System.out.println(alist);

        Collections.sort(alist);
        System.out.println("\n排序後的元素...");
        System.out.println(alist);

        Collections.reverse(alist);
        System.out.println("\n反轉排列的元素...");
        System.out.println(alist);
    }
}
//ch9
class IteratorDemo{
    public static void main(String[] args)
    {
        //建立tset集合物件
        TreeSet<Integer> tset = new TreeSet<>();
        System.out.println("將1~40的整數存入tset集合物件中...");
        for(int i=1; i<=40; i++)
            tset.add(i);
        System.out.println("開始時，tset集合物件內元素個數為：" + tset.size());
        //建立走訪器物件itera
        Iterator<Integer> itera = tset.iterator();
        System.out.println("\n非質數移除中...");
        int n1 = itera.next();
        itera.remove();                 //1不是質數,先移除
        while(itera.hasNext())
        {
            int num = itera.next();
            for(int j=2; j<num; j++)
            {
                if(num % j == 0)
                {
                    itera.remove();           //因有其它因數,故非質數
                    break;
                }
            }
        }
        System.out.println("非質數移除完畢");
        System.out.println("最後，tset集合物件內元素個數為：" + tset.size());
        System.out.println("1~40的質數有：" + tset);
    }
}
//  ch9
class ListIteratorDemo{
    public static void main(String[] args)
    {
        System.out.println("建立alist集合物件...");
        ArrayList<String> alist = new ArrayList<>();
        String[] place = {"宜蘭", "花蓮", "天祥", "台東", "知本"};
        for(String p : place)
            alist.add(p);
        System.out.println("顯示alist集合物件初始元素...");
        System.out.println(alist);

        ListIterator<String> litera = alist.listIterator();
        System.out.println("\n修改alist集合物件元素...");
        while(litera.hasNext())
        {
            litera.next();
            if (litera.nextIndex()==3)
                litera.set("瑞穗");
        }

        System.out.println("\n反向走訪alist集合物件元素...");
        while(litera.hasPrevious())
            System.out.print(litera.previous() + "  ");
        System.out.println();

        System.out.println("\n新增alist集合物件元素...");
        litera = alist.listIterator(3);
        litera.add("池上");

        System.out.println("\n顯示alist集合物件最終元素");
        System.out.println(alist);
    }
}
//  ch10
class GoldClass implements Runnable { // 實作Runnable介面
    int grabed; // 已偷到的金塊數量
    static int totalGold = 20000000; // 金塊總數
    Thread t;
    GoldClass(String name) {
        grabed = 0;
        t = new Thread(this, name);
        t.start(); // 啟動執行緒
    }
    public void run() { // 實作Runnable介面的run()方法
        while (grabGold() == true) { // 判斷金塊是否還有剩
            grabed++; // 偷到一塊
        }
        System.out.println(t.getName() + " 總共偷得 " + grabed + " 個金塊.");
    }
    private synchronized static boolean grabGold() {
        if (totalGold > 0) { // 若金塊還有剩才能偷
            totalGold--; // 偷一塊金塊
            return true;
        } else {
            return false;
        }
    }
}
class SynchronizedDemo {
    public static void main(String[] args) {
        System.out.println("共有 " + GoldClass.totalGold + " 個金塊!");
        GoldClass tA = new GoldClass("張三");
        GoldClass tB = new GoldClass("李四");
        GoldClass tC = new GoldClass("王五");
    }
}
// ch10
class ATM extends Thread {
    Account account; // 宣告Account物件
    long money; // 宣告長整數money記錄存提款數額

    public ATM(Account ac, long n) { // 建構子
        this.account = ac; // 設定account屬性值
        this.money = n; // 設定money屬性值
    }

    public void run() {
        account.deposit(money); // 呼叫Account類別的deposit方法
    }
}
class Account {
    long balance; // balance屬性記錄帳戶餘額

    public Account(long balance) { // 建構子
        this.balance = balance; // 設定balance屬性值
    }

    public synchronized void deposit(long amount) {
        long d_balance;
        d_balance = this.balance;
        System.out.println("帳戶內餘額 = " + d_balance); // 顯示餘額
        if (amount >= 0) {
            System.out.println("存款增加數 = " + amount); // 存款
        } else {
            System.out.println("存款減少數 = " + amount); // 提款
        }
        System.out.println("交易中 .....");
        try {// 模擬取得帳號餘額所需的時間
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        d_balance += amount; // 計算出餘額
        if (d_balance >= 0) { // 若帳戶餘額>=0
            System.out.println("目前帳戶餘額 = " + d_balance + "\n");
            this.balance = d_balance; // 設定balance屬性值(帳戶餘額)
        } else {
            System.out.println("帳戶餘額不足！ \n");
        }
    }
}
class Transaction {
    public static void main(String[] args) {
        Account account = new Account(5000); // 建立account物件並設帳戶餘額為5000
        ATM A1 = new ATM(account, -1000); // A1執行緒提款1000元
        ATM A2 = new ATM(account, 2000); // A2執行緒存款2000元
        ATM A3 = new ATM(account, -9000); // A3執行緒提款9000元
        A1.start(); // A1執行緒啟動
        A2.start(); // A2執行緒啟動
        A3.start(); // A3執行緒啟動
        try {
            A1.join(); // 等待A1執行緒執行完成
            A2.join(); // 等待A2執行緒執行完成
            A3.join(); // 等待A3執行緒執行完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最後帳戶餘額: " + account.balance);
    }
}
//  ch10
class Frisbee { // 在Frisbee類別中設定飛盤物件的屬性和方法
    private boolean isThrow = false; // 記錄飛盤是否丟出，false=未丟出

    public synchronized void throwF(int tNo) { // 丟飛盤的方法
        while (isThrow) { // 當isThrow為true就不斷執行
            try {
                wait(); // 主人進入等待狀態
            } catch (InterruptedException e) {
            }
        }
        System.out.println("丟出第 " + tNo + " 個飛盤");
        isThrow = true; // 設飛盤為丟出
        notify(); // 呼叫小狗來接飛盤
    }

    public synchronized void accessF(int aNo) { // 接飛盤的方法
        while (!isThrow) { // 當isThrow為false就不斷執行
            try {
                wait(); // 小狗進入等待狀態
            } catch (InterruptedException e) {
            }
        }
        System.out.println("接到第 " + aNo + " 個飛盤");
        isThrow = false; // 設飛盤為未丟出
        notify(); // 呼叫主人丟飛盤
    }
}
class ThrowFrisbee implements Runnable { // ThrowFrisbee類別實作Runnable介面
    Frisbee frisbee; // 建立Frisbee類別物件frisbee

    ThrowFrisbee(Frisbee frisbee) { // 建構子
        this.frisbee = frisbee;
    }

    public void run() { // 在run()方法中執行丟飛盤5次
        for (int i = 1; i <= 5; i++) {
            frisbee.throwF(i);
        }
    }
}
class AccessFrisbee implements Runnable { // AccessFrisbee類別實作Runnable介面
    Frisbee frisbee; // 建立Frisbee類別物件frisbee

    AccessFrisbee(Frisbee frisbee) { // 建構子
        this.frisbee = frisbee;
    }

    public void run() { // 在run()方法中執行接飛盤5次
        for (int i = 1; i <= 5; i++) {
            frisbee.accessF(i);
        }
    }
}
class WaitNotify {
    public static void main(String[] args) {
        Frisbee frisbee = new Frisbee(); // 建立Frisbee類別物件frisbee
        Thread master = new Thread(new ThrowFrisbee(frisbee));
        Thread dog = new Thread(new AccessFrisbee(frisbee));
        master.start(); // 啟動master執行緒執行丟飛盤
        dog.start(); // 啟動dog執行緒執行接飛盤
    }
}


