package Java8_ch567;

//  import other package
import Java8_ch1234.*;

public class ch567 {
    public static void content() {
        //ch5 ch5_ = new ch5();
        //ch5_.content();
        //ch6.content();
        new F2(3);
        ch7.content();

        Java8_ch1234.ch1234 otherPackageClass = new ch1234();

    }
}

interface ABC {

}

abstract class BB implements  ABC{

}

class ch5 {


    public void content() {
        //  java C#  method   c c++ function
        //  [修柿子] [static] <傳回值型別> <method 名稱> ([引述串列]) [throws <例外名聲>]
        //  {
        //      [程式區段;]
        //      [return 運算式;]
        //  }

        //  public protected private default
        ch5.add(1,2);// static 靜態方法
        content();

        //  編譯後每個 class 都會編成一個 .class 檔  執行時要在相同路徑  才能互相調用
        //  5-10  p160
        InnerCs c = new InnerCs();
        int val = c.add(5,6);

        //  傳值呼叫 Call By Value 八種基本型別參數
        //  傳參考呼叫 Call By Reference 陣列  物件 ...
        int[] a = new int[]{1,2,3};
        array(a);

        lengthChange("test", 1,2,3,4,5);
        //  取得命令列引數
        //  public class SendArray2 {
        //    public static void main(String[] args) {
        //  指令 java SendArray2 arg1 arg2 arg3
        //  也可以  Run > Edit Configurations > Program arguments 設定引數

        //  多載  overload
        //  遞迴  Recursive
    }

    static void add(int x, int y){
        System.out.println(x + y);
    }
    // Overload  多載
    static void add(int x, String y){
        System.out.println(x + y);
    }

    static void array(int[] x){
    }

    //  可變長度參數
    static void lengthChange(String s, int... x){
        for (int i : x)
            System.out.println(i);
    }

    class InnerCs {
        int add(int x, int y){
            System.out.println(x + y);
            return x + y;
        }
    }
}

class ch6 {
    public void content() {
        //  傳統 Procedure-oriented programming
        //  現代 Object Oriented Programming
        //  物件 class Object 屬性 Attributes (property) 行為 Behaviors (method)

        //  private protected public default
        //  類別名稱  大寫英文字母開頭  upper camel case
        Ccar car1, car2;
        car1 = new Ccar();
        car1.gas = 40.7;
        car1.tbo = 13.6;
        car1.MaxDist();
        car1.Dist(10);

        //  同 package 內 class 名不可重複  同 class 名可放到不同 package
        //  class method overload
        //  class constructor
        //  static method 可以 class名.method  或  物件.method
        //  class 內 this 表自身
    }
}

class ch7 {
    public static void content() {

        //  繼承  Inheritance  SuperClass  SubClass
        //  class 子 extends 父
        //  子只能繼承一個父  父可有多子
        //  屬性方法  public  繼承  同 不同套件都可用   protected 不同套件不可用  private 不會繼承
        //  多代繼承
        //  override  直接同名
        //  建構子  執行順序  父先後子
        //  super 1. 呼叫父建構式 2. 呼叫父屬性方法
        //  final  讓資料成員以常數表示 C# readonly   讓方法不能被子類 override 或類不能被繼承 C# sealed
        //  static 方法 不能被子 override  子可覆蓋static屬性
        //  abstract 抽象類別  開介面  實作交給子類
        //  可以有一般方法成員  和抽象 abstract 方法  沒有實體 只有宣告 不能 private 因為要給子實作
        //  public abstract void test();

        //  介面 Interface 達到類似多重繼承  類 implements 介面1, 介面2
        //  Animal 繼承 Dog Bird
        //  Transoirt 繼承 Bus Airplane    Bird Airplane 都有 CanFly  但不在 Dog Bird  就可以開介面  IFly
        //  套用在 Bird Airplane
        //  宣告方法  編譯時轉 public abstract  所以類別實作介面方法時  要宣告public
        //  宣告變數  編譯時轉 public final 為常數型態  要賦值
        //  介面是執行時期的動態查詢  效率相對慢  和類別不同  大量使用時  要觀察效率有沒有影響
        //  介面 extends 介面  也是繼承
        //  interface 可以 new
        //  https://stackoverflow.com/questions/9157784/java-interface-with-new-keyword-how-is-that-possible
        //  In the code, you're not creating an instance of the interface. Rather, the code defines an anonymous class that implements the interface, and instantiates that class.

        //  多型
        //  用抽象類別實作多型  同方法子類實作不同  表現不同
        //  Animal a1 = new Dog(); Animal a2 = new Cat();
        //  a1.jump();  a2.jump();  都是 animal 表現不同  多型
        //  用介面實作多型  大同小異

        //  套件 package
        //  類似 C# 的 namespace 如果有多層架構 可以用點分開
        //  Database.Repository.Base
        //  import

        //  不宣告  public protected private 就是預設
        //  預設 可繼承 可存取 不同套件不可用
        //

    }


}






//  ch5
class SendArray2 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++)
            System.out.println(" 第 " + (i + 1) + " 位學生：" + args[i]);
    }

}
//  ch5
class SendArray1 {
    public static void main(String[] args) {
        int[] myArray = new int[] { 31, 12, 16, 10, 78 };
        System.out.print(" 排序前->");
        for (int i = 0; i < myArray.length; i++)
            System.out.print("  " + myArray[i]);
        bubbleSort(myArray);	//將myArray陣列傳入bubbleSort方法進行排序
        System.out.println();
        System.out.print(" 排序後->");
        for (int i = 0; i < myArray.length; i++)
            System.out.print("  " + myArray[i]);
    }

    static void bubbleSort(int[] vArray) {
        int tmp = 0;
        for (int i = vArray.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (vArray[j] > vArray[j + 1]) {
                    tmp = vArray[j];
                    vArray[j] = vArray[j + 1];
                    vArray[j + 1] = tmp;
                }
            }
        }
    }
}
//  ch5
class Recursive {
    static int fib(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }
    public static void main(String[] args) {
        System.out.println("費氏f(6)第六項為" + fib(6));
        System.out.println("費氏f(10)第十項為" + fib(10));
    }

}
//  ch5
class BigLotto {
    // getRnd靜態方法可用來取得n~m之間的亂數，並傳給所設定的陣列
    static void getRnd(int[] vArray, int min, int max, int num) {
        int max_dim, rem_num, choice;
        max_dim = max - min + 1;
        int[] t = new int[max_dim];
        for (int i = 0; i <= max_dim - 1; i++) {
            t[i] = min + i;
        }
        rem_num = max_dim;
        for (int i = 0; i <= num - 1; i++) {
            // Math.random Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
            choice = (int) (Math.random() * rem_num);
            vArray[i] = t[choice];
            for (int j = choice; j < rem_num - 1; j++) {
                t[j] = t[j + 1];
            }
            rem_num--;
        }

    }

    public static void main(String[] args) {
        int[] lot = new int[7];
        getRnd(lot, 1, 49, 7);
        System.out.println("本期大樂透開獎號碼如下：");
        for (int i = 0; i < 6; i++)
            System.out.print("  " + lot[i]);
        System.out.print("\n  特別號：" + lot[6]);
    }
}

// ch6
class Ccar {                    //汽車類別
    public double gas, tbo;            //宣告最多載油量, 平均耗油量
    public double max_dist = 0;        //加滿油可行駛最長距離

    public void MaxDist() {             //計算可行駛最長距離
        max_dist = gas * tbo;
    }

    public double Dist(double oil) {   //一般加油可行駛距離
        return oil * tbo;
    }
}
//  ch6
class Ccar2 {                      //汽車類別
    private double gas, tbo;       //宣告最多載油量, 平均耗油量
    private double max_dist = 0;   //加滿油可行駛最長距離

    private void MaxDist() {       //計算可行駛最長距離
        max_dist = gas * tbo;
    }

    public void SetValue(double g, double t) { //傳入資料
        gas = g;
        tbo = t;
        MaxDist();
    }

    public double GetDist() {      //傳出資料
        return max_dist;
    }
}
class Encapsulate {       //主類別
    public static void main(String[] args) {   //主程式
        Ccar2 car1;                              //宣告car1物件
        car1 = new Ccar2();                      //建立car1物件
        double g1 = 40.7, t1 = 13.6;
        car1.SetValue(g1, t1);                  //設定car1物件的屬性值
        double distance1 = car1.GetDist();      //取得car1物件的方法傳回值
        Ccar2 car2 = new Ccar2();                 //宣告並建立car2物件
        car2.SetValue(60, 9.5);                 //設定car1物件的屬性值
        System.out.println("car1加滿油可行駛 " + distance1 + " km");
        System.out.println("car2加滿油可行駛 " + car2.GetDist() + " km");
    }
}
//  ch6
class Cmath {
    public int getMax(int a, int b) {
        if (a > b) return a ;
        else       return b ;
    }

    public int getMax(int[] vArray) {
        int n = vArray[0];
        for(int i=1; i<vArray.length; i++) {
            if (vArray[i] > n) n = vArray[i];
        }
        return n;
    }
}
class Overload {                      //主類別
    public static void main(String[] args) {  //主程式
        Cmath max1 = new Cmath();
        System.out.println("10 和 20 最大數為：" + max1.getMax(10, 20));
        int[] ary = new int[]{52,66,78,99,11};
        System.out.println("{52,66,78,99,11} 陣列中最大數為：" + max1.getMax(ary));
    }
}
//  ch6
class Cstudent {
    private int height = 150;      //初始化height資料成員的值為150
    private int weight = 40;       //初始化weight資料成員的值為40
    private void setWeight(int w) {
        if (w>=40 && w<=150) weight = w;
    }
    private void setHeight(int h) {
        if (h>=50 && h<=250) height = h ;
    }
    public Cstudent() { }           //Cstudent類別的建構式，沒有傳入引數
    public Cstudent(int w) {        //Cstudent類別的建構式，傳入一個引數
        setWeight(w);                //呼叫setWeight方法初始化weight資料成員
    }
    public Cstudent(int h, int w) { //Cstudent類別的建構式，傳入兩個引數
        setHeight(h);                //呼叫setHeight方法初始化height資料成員
        setWeight(w);                //呼叫setWeight方法初始化weight資料成員
    }
    public void getShow() {
        System.out.println("  身高是: " + height);
        System.out.println("  體重是: " + weight + "\n");
    }
}
class Constructor {                    //主類別
    public static void main(String[] args) {  //主程式
        Cstudent Peter = new Cstudent();
        System.out.println("Peter的資料 --> 使用Cstudent()建構式");
        Peter.getShow();
        Cstudent David = new Cstudent(300);
        System.out.println("David的資料 --> 使用Cstudent(300)建構式");
        David.getShow();
        Cstudent Mary = new Cstudent(180,78);
        System.out.println("Mary的資料 --> 使用Cstudent(180, 78)建構式");
        Mary.getShow();
    }
}
//  ch6
class Cstudent2 {
    //num靜態成員用private宣告，表示只能在自身類別使用，
    private static int num;       //num用來計算使用Cstudent類別建立物件的個數
    public int weight, height;
    public Cstudent2() {
        num++;         //num靜態成員加1
    }
    public Cstudent2(int w, int h) {
        num++;         //num靜態成員加1
        weight = w;
        height = h;
    }
    public static void getObjectNum() {  //getObjectNum靜態成員
        System.out.println("目前使用Cstudent類別產生了 " + num + " 個物件實體\n") ;
    }
}
class StaticMember {                  //主類別
    public static void main(String[] args) {  //主程式
        Cstudent2 Peter = new Cstudent2();
        Peter.weight = 65;
        Peter.height = 165;
        System.out.println("Peter體重=" + Peter.weight + "\t身高=" + Peter.height);
        Cstudent2.getObjectNum();    //Cstudent類別呼叫getObjectNum靜態成員
        Cstudent2 David = new Cstudent2(58, 170);
        System.out.println("David體重=" + David.weight + "\t身高=" + David.height);
        David.getObjectNum();       //物件呼叫getObjectNum靜態成員
    }
}
//  ch6
class Cperson {
    private int age;
    public void ShowAge(int age) {
        this.age = age;  // this
        age = age + 2;
        System.out.println("傳入的 age = " + age);
        System.out.println("this age = " + this.age);
    }
}
class ThisDemo {
    public static void main(String[] args) {
        Cperson Joe = new Cperson();
        Joe.ShowAge(20);
    }
}

//  ch7
class CMath {
    public void getMax(int a, int b) {
        int bigNum;
        if (a>b) bigNum = a;
        else bigNum = b;
        System.out.println(a + "與" + b + "的最大數為" + bigNum);
    }
}
class SonCMath extends CMath {  // SonCMath繼承CMath類別
    public void getFabonacci(int a) {
        int firstNum = 0, secondNum = 1;
        System.out.print("費式數列：") ;
        System.out.print(firstNum + ", " +secondNum);
        int ans;
        for(int i=2; i<=a; i++) {
            ans = firstNum + secondNum;
            System.out.print(", " +ans);
            firstNum = secondNum;
            secondNum = ans;
        }
    }
}
class ExtendDemo {
    public static void main(String[] args) {
        SonCMath math1 = new SonCMath();
        math1.getMax(10,20);        //使用子類別繼承父類別的方法
        System.out.println();
        math1.getFabonacci(10);     //使用子類別自己的方法
    }
}
//  ch7
class GrandSonCMath extends SonCMath { // GrandSonCMath繼承SonCMath類別
    public void getFactorial(int a) {
        int ans=1, i;
        if(a==0) ans=1;
        else
            for(i=1; i<=a; i++)
                ans*=i;
        System.out.println(a + "! = " + ans ) ;
    }
}
class MoreExtendDemo {
    public static void main(String[] args) {
        GrandSonCMath math2 = new GrandSonCMath();
        math2.getMax(10,20);        //使用繼承自祖父類別的方法
        math2.getFabonacci(10);     //使用繼承自父類別的方法
        System.out.println();
        math2.getFactorial(5);      //使用自已的方法
    }
}
//  ch7
class CMath3 {
    public void getMax(int a, int b) {
        int bigNum;
        if (a>b) bigNum = a;
        else bigNum = b;
        System.out.println(a + "籔" + b + "程计" + bigNum);
    }
}

class SonCMath3 extends CMath3 {
    public void getMax(int a, int b) {
        if(a>b)
            System.out.println(a + " ㎝ " + b + " 程计" + a);
        else if(a<b)
            System.out.println(a + " ㎝ " + b + " 程计" + b);
        else
            System.out.println(a + " ㎝ " + b + " 妓");
    }
}
class OverrideDemo {
    public static void main(String[] args) {
        CMath math3 = new CMath();
        math3.getMax(20, 20);         //㊣CMath摸getMax()よ猭
        SonCMath math4 = new SonCMath();
        math4.getMax(20, 20);         //㊣SonCMath摸SonCMath()よ猭
    }
}
//   ch7
class CStu {
    private int weight, height;
    CStu() {
        weight = 0; height = 0;
    }
    CStu(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
    public void showData() {
        System.out.print("身高：" + this.weight + "\t體重：" + this.height);
    }
}
class SonCStu extends CStu {
    private int score;
    SonCStu() {
        super();     //呼叫CStu父類別的CStu()建構式
        score = 0;
    }
    SonCStu(int weight, int height, int score) {
        //呼叫CStu父類別的CStu(int weight, int height)建構式
        super(weight, height);
        this.score = score;
    }
    public void showData() {
        super.showData();   //呼叫父類別的showData方法
        System.out.print("\t成績：" + this.score);
    }
}
class SuperDemo {
    public static void main(String[] args) {
        CStu Peter = new CStu(50, 170);
        Peter.showData();
        System.out.println("\n");
        SonCStu Tom = new SonCStu(65, 164, 99);
        Tom.showData();
    }
}
//  ch7
class Ccar5 {
    private final int speed = 140 ;
    public final void showBigSpeed(String s)  {
        System.out.println(s + " 最大速度是 " + speed + " 公里！");
    }
}
class PiliCcar5 extends Ccar5 {
    public void showBigSpeed(String s, int n) {
        System.out.println(s + " 加強後最大速度是 " + n + " 公里！");
    }
}
class FinalDemo_2 {
    public static void main(String[] args) {
        Ccar5 car1 = new Ccar5();
        car1.showBigSpeed("car1");        //呼叫Ccar父類別的showBigShow()
        PiliCcar5 car2 = new PiliCcar5();
        car2.showBigSpeed("car2");        //呼叫Ccar父類別的showBigShow()
        car2.showBigSpeed("car2", 180);   //呼叫PiliCcar子類別的showBigShow()
    }
}
//  ch7
class A {
    public static int a = 10;
    public static int b;
    public static void show() {
        b = 20;
        System.out.println("b 的值是: " + b);
    }
}
class B extends A {
    public static int a = 11;
	/* 父類別的show方法為static，所以子類別無法覆寫
  	public void show() {
    	System.out.println("這是子類別的方法");
  	}
	*/
}
class StaticDemo {
    public static void main(String[] args) {
        System.out.println("類別 A 中 a 的值是: " + A.a);
        System.out.println("現在要直接呼叫類別 A 中的方法成員show()");
        A.show();
    }
}
//  ch7
abstract class Ccar7 {    //抽象類別
    int speed;
    public abstract void addSpeed(int s);  //抽象方法沒有實作內容
    public static void showData() {        //靜態方法
        System.out.println("所有的車子都可以加速!!\n");
    }
}
class PiliCar extends Ccar7 {
    //繼承Ccar抽象類別，必須實作Ccar類別的addSpeed抽象方法
    public void addSpeed(int s) {
        System.out.println("霹靂車目前速度：" + speed);
        speed += s;
        System.out.println("霹靂車  加速後：" + speed);
    }
}
class BMWCar extends Ccar7 {
    //繼承Ccar抽象類別，必須實作Ccar類別的addSpeed抽象方法
    public void addSpeed(int s) {  //實作addSpeed抽象方法
        System.out.println("BMW目前速度：" + speed);
        speed += s ;
        if(speed <= 200) {
            System.out.println("BMW  加速後：" + speed);
        }
        else {
            System.out.println("BMW最大速度 200 無法再加速了");
        }
    }
}
class AbstractDemo {
    public static void main(String[] args) {
        Ccar7.showData();   //呼叫Ccar抽象類別的showData()靜態方法
        PiliCar car1 = new PiliCar();
        car1.addSpeed(150);
        car1.addSpeed(120);
        System.out.println();
        BMWCar car2 = new BMWCar();
        car2.addSpeed(150);
        car2.addSpeed(120);
        //Ccar car3 = new Ccar();  //錯誤，抽象類別無法產生實體
    }
}
//  ch7
interface IMove {                   //IMove介面
    public int ENGINE_NUM = 1;      //介面常數
    public void addSpeed(int s);    //只宣告介面的方法，無程式碼
}
class PiliCar6 implements IMove {    //PiliCar類別實作IMove介面
    private int speed;
    public void addSpeed(int s) {   //實作IMove介面的addSpeed方法內程式碼
        System.out.println("霹靂車目前速度：" + speed);
        speed += s ;
        System.out.println("霹靂車  加速後：" + speed);
    }
}

class BMWCar6 implements IMove {     //BMWCar類別實作IMove介面
    private int speed;
    public void addSpeed(int s) {  //實作IMove介面的addSpeed方法內程式碼
        System.out.println("BMW目前速度：" + speed);
        speed += s ;
        if(speed <= 200)
            System.out.println("BMW  加速後：" + speed);
        else
            System.out.println("BMW最大速度 200 無法再加速了");
    }
}
class InterfaceDemo_1 {
    public static void main(String[] args) {
        System.out.println("所有車子有 " + IMove.ENGINE_NUM + " 個引擎！\n");
        PiliCar6 car1 = new PiliCar6();
        car1.addSpeed(150);
        car1.addSpeed(120);
        System.out.println("霹靂車有 " + IMove.ENGINE_NUM + " 個引擎！\n");
        BMWCar6 car2 = new BMWCar6();
        car2.addSpeed(150);
        car2.addSpeed(120);
        System.out.println("BMW有 " + IMove.ENGINE_NUM + " 個引擎！\n");
    }
}
//  ch7
interface IMove2 {
    public void showSpeed();
}

interface IFly {
    public void showFly();
}
interface IAnimal extends IMove2, IFly {    //IAnimal介面繼承IMove和IFly介面
    public void showAttack() ;
}
class CAirPlane9 implements IMove2, IFly {   //實作IMove和IFly介面
    public void showSpeed() {
        System.out.println("飛機每一次加速，會增加 20公里！");
    }
    public void showFly() {
        System.out.println("飛機的最快移動方式，就是飛行！");
    }
}
class CSiteYaMan9 implements IAnimal {     //實作IAnimal介面
    public void showSpeed() {
        System.out.println("賽亞人每一次加速，會增加 30公里！");
    }
    public void showFly() {
        System.out.println("賽亞人飛的速度比光速還快！");
    }
    public void showAttack() {
        System.out.println("賽亞人攻擊會使用龜派氣功！");
    }
}
class InterfaceDemo_2 {
    public static void main(String[] args) {
        CAirPlane9 air1 = new CAirPlane9();  //建立CAirPlane類別的air1物件
        air1.showSpeed();                  //呼叫CAirPlane類別的showSpeed()方法
        air1.showFly();                    //呼叫CAirPlane類別的showFly()方法
        System.out.println();
        CSiteYaMan9 man1 = new CSiteYaMan9();//建立CSiteYaMan類別的man1物件
        man1.showSpeed();                  //呼叫CSiteYaMan類別的showSpeed()方法
        man1.showFly();                    //呼叫CSiteYaMan類別的showFly()方法
        man1.showAttack();                 //呼叫CSiteYaMan類別的showAttack()方法
    }
}
//  ch7
abstract class CPerson {          //抽象類別
    abstract void showAttack();   //抽象方法
}
class CSpider extends CPerson {   //Spider類別繼承Person抽象類別
    public void showAttack() {
        System.out.println("蜘蛛人的攻擊力：60");
        System.out.println("攻擊方式會發射蜘蛛網！\n");
    }
}
class CSuperMan extends CPerson {  //SuperMain類別繼承Person抽象類別
    public void showAttack() {
        System.out.println("超人的攻擊力：100");
        System.out.println("攻擊方式使用拳頭！\n");
    }
}
class PolymorphismDemo_1 {
    public static void main(String[] args) {
        CPerson pflag;                      //宣告CPerson類別的參考變數pflag
        CSpider Bill = new CSpider();       //產生CSpider類別的物件Bill
        CSuperMan clark = new CSuperMan();  //產生CSuperMan類別的clark
        pflag = Bill;                       //pflag參考變數指到Bill物件
        pflag.showAttack();                 //執行CSpider類別的showAttack()方法
        pflag = clark;                      //pflag參考變數指到clark物件
        pflag.showAttack();                 //執行CSuperMan類別的showAttack()方法
    }
}
//  ch7
interface IAttack {        //定義IAttack介面
    void showAttack();     //宣告IAttack介面的showAttack()方法
}
class CSpider2 implements IAttack {  //CSpider類別實作IAttack介面
    public void showAttack() {
        System.out.println("蜘蛛人的攻擊力：60");
        System.out.println("攻擊方式會發射蜘蛛網！\n");
    }
}
class CSuperMan2 implements IAttack { //CSuperMan類別實作IAttack介面
    public void showAttack() {
        System.out.println("超人的攻擊力：100");
        System.out.println("攻擊方式使用拳頭！\n");
    }
}
class PolymorphismDemo_2 {
    public static void main(String[] args) {
        IAttack flag;
        CSpider2 Bill = new CSpider2();
        CSuperMan2 clark = new CSuperMan2();
        flag = Bill;
        flag.showAttack();
        flag = clark;
        flag.showAttack();
    }
}
//  ch7
class F1{
    F1(){
        System.out.println(1);
    }
    F1(int i){
        System.out.println(2);
    }

}
class F2 extends F1{
    F2(){
        System.out.println(3);
    }
    F2(int i){
        super(3);//  如果沒寫這行  會自動呼叫 F1 預設建構式
        System.out.println(4);
    }
}



