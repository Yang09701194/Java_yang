package Java8_ch1234;

import java.util.Scanner;
import java.util.Arrays;

//  https://docs.oracle.com/javase/8/docs/
//  https://docs.oracle.com/javase/8/docs/api/index.html
public class ch1234 {
    public static void content() {
        //ch1.content();
        //ch2.content();
        //ch3.content();
        ch4.content();
    }
}

/**
 * 測試文件註解  一組 ** *
 */
class ch1 {
    public static void content() {

        String a = "a";
        String a2 = "a";
        System.out.println(a == "a");

        Scanner scn = new Scanner(System.in);
        System.out.println("請輸入姓名:");
        String str = scn.next();
        System.out.println("Hi! " + str + ", 歡迎來到 Java 世界!");
        scn.close();
    }

    //單行註解
    /*
     * 多行註解
     * */

}

//  執行編譯
//  E:\Data>javac Hello.java
//  編譯完的確出現了  .class   位元組檔 Byte Code  之後交給解譯程式  JVM   JVM 採用了 JIT 技術 Just In Time Compilaion   只要額外運用少量的記憶體空間  就可以大幅提升解譯的效能
//  接著
//  E:\Data>java Hello
//  用  "java"  解譯程式  執行  Hello.class

// 產生文件  javadoc -encoding utf-8 -d doc -private  ch1_2.java
// -d 目標路徑  -private  指定所有類別成員
// javadoc -help

// 反組譯  -c 反組譯 class 檔  -p 顯示所有類別成員  ch1_2  類別名稱
//\Yang_Java\out\production\Java\ch1_2>javap -c -p  ch1_2 > decom.txt
//javap -help


//  Java Language Specification
//  https://docs.oracle.com/javase/specs/jls/se8/html/jls-7.html#jls-7.6


class ch2 {

    public static void content() {
        //  識別字  可以 $ 開頭
        int $test = 3;

        //  package 方法名稱建議 lower camel case
        //  class upper camel case
        //  static final 全大寫

        //  transient
        //  https://dotblogs.com.tw/grayyin/2016/07/05/145920
        //  java 的transient關鍵字為我們提供了便利，我們只需要實作Serilizable介面，將不需要序列化的屬性前加上修飾字　transient
        //  ，序列化物件的時候，這個屬性就不會序列化到指定的目的地中。
        //  obj.i 因為有加上修飾字  transient ，所以序列化寫入檔案　TestFile.txt 並沒有存入值.
        //  obj.k 因為未加上修飾字  transient ，所以序列化後，給的值會存入檔案　TestFile.txt 中 .
        //  而obj.j 因為修飾字  transient 對static變數是無效的，所以值依然可以帶入檔案　TestFile.txt 中 .

        //  synchronized volatile volatile vs synchronized
        //  https://www.tpisoftware.com/tpu/articleDetails/1753
        //撰寫多執行緒應用程式時，確保資料一致性的兩大原則：
        //  Mutual Exclusion - critical section裡的程式碼一次只能被一個執行緒執行
        //  Visibility – 共享資料的值被某執行緒更改時，其他執行緒可及時看見
        //使用volatile可確保Visibility，但不具Mutual Exclusion。
        //使用synchronized，則可保證以上兩項特性，代價則是更差的效能。
        //用volatile可以幫助我們寫出更簡潔的code。相較用synchronized鎖住某個區塊，因為用volatile像是將同步責任交給JVM，會比我們自己處理更不容易出錯。但如果宣告為volatile的變數經常被使用的話，可能導致程式的效能不如鎖住整個區塊。
        //volatile in Java vs C/C++
        //  在Java裡volatile是告訴編譯器變數的值不快取到working memory，讀寫永遠透過main memory。
        //  在C/C++裡volatile則是告訴編譯器不要優化我們所撰寫的code，和我們文章上方所討論的同步問題無關係。

        //  strictfp
        //  https://www.baeldung.com/java-strictfp
        //  https://en.wikipedia.org/wiki/Strictfp
        //  By default, the floating-point computations in Java are platform-dependent. And so, the floating-point outcome's precision depends on the hardware in-use.
        //  When we declare an interface or a class with strictfp, all of its member methods and other nested types inherit its behavior.
        //  However, please note that we're not allowed to use strictfp keyword on variables, constructors or abstract methods.

        //  電腦能量化處理的資料  常值 literal  八種基本型別 primitive type  (相對 reference data type)
        //  boolean(true/false 不可等同 0 1) 1bit byte 1byte char(unicode) short 2byte int float 4byte
        //  long double 8byte

        //  字串  escape \n \\ \ddd 八進位字元碼 \101=65='A'  \u1234 十六進位

        //  數字進位  2 0b 8 0 16 0x
        System.out.println("10: " + 10);
        System.out.println("0b10: " + 0b10);
        System.out.println("010: " + 010);
        System.out.println("0x10: " + 0x10);

        //  浮點數  3.14   1.23e+4(IEEE 754 科學符號) > 1.23e4  指數可負不可小數
        //  123_456_789  1.234_567_89  0b1010_1010_0010
        int price = 54, qty;

        //  2-18 p53
        //  位元邏輯運算子  & | ^ ~ NOT 補數
        //  >> << <<= >>= 有號     >>> 無號

        int a = 2;
        double b = a /*自動轉換 double*/ * 1.5;  // 記憶體小的可自動轉換為大的 byte > int 可以 int > byte 不行
        //  強制轉換 縮小轉換
        double pi = 3.14;
        float p = (float)pi;

        //  2-28  p64
        //  java 物件變數 在記憶體  有三種儲存空間
        //  Global  : 宣告為 static
        //  Stack : 8 primitive type 變數 占用記憶體空間小 存取速度快
        //  Heap : reference type 變數  array class string
        int[] n = new int[]{1,2,3}; // n 在 stack  指向 heap 的 array 實體位址 開頭

        //  java 程式都會自動載入 java.lang 這個基本 package 套件 裡面定義 System 類
        //  in out err
        System.out.println(); // print   printf format  %d(int) %f(float) %s
        // (string) %c(char) %b(bool, null false 為 false  其他印 true) %n換行
        System.out.printf("%.2f", 1.2345);//  2位小數    4.1f  預留四字元寬度對齊  1位
        //  讀鍵盤輸入  Scanner
        Scanner scn = new Scanner(System.in);
        // nextLine 取得整行輸入  nextInt 整數 nextBoolean nextFloat
        boolean ans = scn.nextBoolean();
        System.out.print("your answer: " + ans);
        scn.close(); //70

        //  Double vs double in java
        //  https://stackoverflow.com/questions/13332012/double-vs-double-in-java
        //  Double parameter can be null when double can't.
        //   double is a primitive type whereas Double is an Object.
        //  - double is a primitive type, where as Double is a wrapper object.
        //- One of the most common use of Wrapper objects is with Collection .
        double d = 3;
        //  編譯有說 Double 被 Deprecate 了
        //  https://stackoverflow.com/questions/60024551/alternative-for-deprecated-new-doubledouble
        //  https://stackoverflow.com/questions/47095474/the-constructors-integerint-ledouble-longlong-and-so-on-are-deprecat
        Double d2 = new Double(5);
        d2 = Double.valueOf(5 - 1);// It is rarely appropriate to use this constructor. The
        // static factory valueOf(int) is generally a better choice, as it is likely to yield significantly better space and time performance. Constructs a newly allocated Integer object that represents the specified int value.
        d2 = 3.14;
        d2 = null;
    }
}


class ch3 {

    public static void content() {
        //  3-4  p78
        Scanner scn = new Scanner(System.in);
        String vip = "";
        double money;
        System.out.println("please enter purchase money");
        money = scn.nextDouble();
        System.out.println("are you VIP? (Y/N)");
        vip = scn.next();
        if(vip.equals("Y") | vip.equals("y")){
            money *= 0.85;
        }
        else if (vip.equalsIgnoreCase("n")) {
            if("test" == "test"){

            }
        }
        else {

        }
        money = vip.equals("y") ? money *= 0.85 : money;
        switch (vip){
            case "1":
                System.out.println("");
                break;
            case "2":
            case "3":
                System.out.println("");
                break;
            default:
                break;
        }
        System.out.println("need pay price: " + money);
        scn.close();

        //  equals  ==  diff
        //  https://www.geeksforgeeks.org/difference-equals-method-java/
//The main difference between the .equals() method and == operator is that one is a method and the other is the operator.
//We can use == operators for reference comparison (address comparison) and .equals() method for content comparison. In simple words, == checks if both objects point to the same memory location whereas .equals() evaluates to the comparison of values in the objects.
        String s1 = "HELLO";
        String s2 = "HELLO";
        String s3 =  new String("HELLO");
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true

        //  3-20  p93
        for (float j = 0, y = 0; j < 10; j += 0.25, y++){

        }
        int i = 0;
        while(i< 10){
            i++;
        }
        do {
            i++;
        } while (i < 20);

        String str = "A";
        int search = "ABCDE".indexOf(str);


        //  3-29  p103
        //  Java 不支援 goto  但 break continue 可待配標記  有類似效果
        boolean flag = false;
        Block1: {
            Block2:{
                Block3:
                for (int k = 0; k< 10; k++){
                    for (int j = 0; j < 10; j++){
                        if(flag){
                            break Block2;
                        }
                        else if(j == 12){
                            continue;
                        }
                        else if(j == 13){
                            break;
                        }
                        else{
                            continue Block3;
                        }
                    }
                }
                System.out.println("Block2");
            }
            System.out.println("jump out of Block2");
        }


    }
}

class ch4 {
    public static void content() {

        //  4-3  p119  Array
        //  三種宣告
        String[] name;
        byte []b;
        char hex[];

        //  同之前
        int[] n = new int[]{1,2,3}; // n 在 stack  指向 heap 的 array 實體位址 開頭
        int[] m = null; // m 在 stack   heap 還沒配置實體空間
        int[] k = new int[5]; // 初始化 0  heap 配置五個記憶體連續空間
        //  [索引 index]
        Arrays.fill(k, 35);
        for(int i = 0; i< k.length; i++){
            System.out.println(k[i]);
        }
        for(int ke : k){
            System.out.println(ke);
        }

        //  p124 >= 2 維的陣列  多維陣列
        int[][] p = new int[3][4];
        p[1][2] = 3;
        p = new int[][]{{1,2,3}, {4,5,6}}; // 記憶體 在 heap 先參照到一個一維陣列 兩個元素再指到兩個一維陣列 各有三元素
        //  https://www.geeksforgeeks.org/multidimensional-arrays-in-java/
        int[][][] arr = new int[10][20][30];
        arr[0][0][0] = 1;
        //  非對稱型  non-rectangular
        p = new int[3][];
        p[0] = new int[] {1};
        p[0] = new int[] {1, 2};  //  對稱大部分用不到時 可以節省記憶體
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
            }
        }

        String str = "測試";
        char c = str.charAt(0); //測

        //  4-27  p143
        int[] w = new int[] {1,9,6,2,8,4};
        Arrays.sort(w);
        for(int i : w)
            System.out.println(i);
        int searchPoint = Arrays.binarySearch(w, 3);
        //binarySearch return:
        //index of the search key, if it is contained in the array;
        // otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.

        int[]x[] = new int[][]{{1,2,3}, {4,5}};
        int[][] y = x;


    }
}




//ch4  n(n-1)/2 次比較
class BubbleSort {
    public static void main(String[] args) {
        int[] aNum = { 32, 24, 11, 48, 15 };
        System.out.print(" 排   序   前  ：");
        for (int a = 0; a < aNum.length; a++)
            System.out.print("  " + aNum[a]);
        System.out.println();
        int n = aNum.length;
        int t;
        for (int i = n - 2; i >= 0; i--) { // 進行氣泡排序法
            for (int j = 0; j <= i; j++) {
                if (aNum[j] > aNum[j + 1]) {
                    t = aNum[j];
                    aNum[j] = aNum[j + 1];
                    aNum[j + 1] = t;
                }
            }
            System.out.print(" 第" + (4 - i) + "次循環：");
            for (int a = 0; a < aNum.length; a++)
                System.out.print("  " + aNum[a]);
            System.out.println();
        }
        System.out.print(" 排   序   後  ：");
        for (int a = 0; a < aNum.length; a++)
            System.out.print("  " + aNum[a]);
    }
}


//ch4  循序搜尋法  平均 n/2 次比較  沒效率 少量資料 未排序資料 搜尋
class LinearSearch {
    public static void main(String[] args) {
        int[] Adata = new int[] { 5, 3, 1, 2, 10, 9, 4, 8, 7, 6 };
        for (int i = 0; i < Adata.length; i++) {
            System.out.print(" 第 " + (i + 1) + "個數=" + Adata[i]);
            if (i == 4 || i == 9)
                System.out.println();
        }
        Scanner scn = new Scanner(System.in);
        System.out.print(" 請輸入要搜尋數字: ");
        int searchNum = scn.nextInt();
        int num = -1; // num单-1ボ⊿Τт戈
        for (int j = 0; j < Adata.length; j++) {
            if (Adata[j] == searchNum) {
                num = j;
                break;
            }
        }
        System.out.println("================");
        if (num == -1)
            System.out.println(" 沒有找到--> " + searchNum);
        else
            System.out.println(" " + searchNum +
                    "是第" + (num + 1) + "個數");
        scn.close();
    }
}


//  二分搜尋法 先排序 再搜尋  (log2)N +1 次比較
class BinarySearch {
    public static void main(String[] args) {
        int[] aNum = { 23, 100, 58, 11, 67, 12, 44, 101, 75 };
        System.out.print(" 排序前：");
        for (int i = 0; i < aNum.length; i++)
            System.out.print("  " + aNum[i]);
        System.out.println();
        int n = aNum.length;
        int t;
        for (int i = n - 2; i >= 0; i--) { // 進行氣泡排序法
            for (int j = 0; j <= i; j++) {
                if (aNum[j] > aNum[j + 1]) {
                    t = aNum[j];
                    aNum[j] = aNum[j + 1];
                    aNum[j + 1] = t;
                }
            }
        }
        System.out.print(" 排序後：");
        for (int i = 0; i < aNum.length; i++)
            System.out.print("  " + aNum[i]);
        System.out.println();
        Scanner scn = new Scanner(System.in);
        System.out.print(" 請輸入要搜尋的數字： ");
        int sNum = scn.nextInt();
        int num = -1, low = 0, high = aNum.length - 1, midNum = 0;
        do {
            midNum = (low + high) / 2;
            if (aNum[midNum] == sNum) {	//若中間註標的陣列值和搜尋資料相同
                num = midNum;
                break;				//離開迴圈
            }
            if (aNum[midNum] > sNum) //若中間註標的陣列值>搜尋資料
                high = midNum - 1;	//重設上界值
            else
                low = midNum + 1; 	//重設下界值
        } while (low <= high);			//若下界值 <= 上界值就繼續執行
        if (num == -1)
            System.out.println(" 沒有 " + sNum + " 這個數字! ");
        else
            System.out.println("排序後找到"+sNum+"是第"+(num +1)+ "個數字!");
        scn.close();
    }
}

class BinarySearch2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = { 83, 25, 31, 5, 52, 17, 42, 63, 11, 9 };
        System.out.print("排序前: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + ", ");
        System.out.println();
        Arrays.sort(arr);
        System.out.print("排序後: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + ", ");
        System.out.println();
        System.out.print("請輸入搜尋值: ");
        int sNum = scn.nextInt();
        int find = -1;
        if ((find = Arrays.binarySearch(arr, sNum)) > -1) {
            System.out.println("找到 "+sNum +"位於註標 " + find + " 處");
        } else
            System.out.println("找不到"+sNum+ " 處" + find );
        scn.close();
    }
}



