package Java8_ch14_17;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.nio.Buffer;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ch14_17 {

    public static void content() throws IOException {

        //ch14.content();
        //ch15.content();
        //ch16.content();
        ch17.content();
    }
}

class ch14 {
    public static void content() throws IOException {
        //  Java 輸入/輸出處理 Java I/O  使用 Data Stream 概念 水龍頭  磁碟/網路可用相同程式碼
        //  java.io.*
        //  位元組資料流 Byte 8 bit InputStream OutputStream
        //  字元資料流 char unicode 16bit Reader Writer

        String msg, fname, fpath;
        System.out.println("請輸入檔名:");
        Scanner scn = new Scanner(System.in);
        fpath = scn.next();
        File fin = new File(fpath);
        File fin2 = new File("test");
        fname = fin.getName();
        long len = fin.length();
        fin.canRead(); fin.canWrite(); fin.compareTo(fin2); fin.createNewFile(); fin.delete(); fin.exists();
        fin.isDirectory(); fin.isFile();  fin.list(); fin.renameTo(fin2); fin.setReadOnly(); fin.setReadable(true, false); fin.toString(); fin.toURI();

        //https://stackoverflow.com/questions/26860167/what-is-a-safe-way-to-create-a-temp-file-in-java
        File tempFile = File.createTempFile("prefix-", "-suffix");
        tempFile.deleteOnExit();
        //Will create a file in the temp dir, like:
        //prefix-6340763779352094442-suffix
        //System.exit(0)

        //Reader
        //  BufferedReader     LineNumberReader
        //  CharArrayReader
        //  InputStreamReader  FileReader
        //  FilterReader       PushbackReader
        //  PipedReader
        //  StringReader

        //  14-7 461
        FileReader reader = new FileReader(fin2);
        reader = new FileReader("fpth");
        reader.mark(5);/*在資料流中標示目前位置*/ reader.read();
        reader.read(new char[]{});/*資料讀進 []*/ reader.ready(); reader.reset(); reader.skip(50);
        reader.close();

        File f = new File(fpath);
        FileReader finr = new FileReader(f);
        int size = (int)f.length();
        String name = f.getName();
        char buffer[] = new char[size];
        System.out.println("檔案名稱：" + name);
        System.out.println("檔案總長度：" + size);
        finr.read(buffer);
        System.out.println(buffer);
        finr.close();
        //catch (IOException e)

        String data;
        FileReader fr = new FileReader(fpath);
        BufferedReader bfin = new BufferedReader(fr);
        do
        {
            data = bfin.readLine();
            if(data==null)
            {
                break;
            }
            System.out.println(data);
        } while (true);
        bfin.close();

        //  CharArrayReader   前面讀檔  也可讀 []
        CharArrayReader creader = new CharArrayReader(new char[]{}, 0, 86);

        //https://docs.oracle.com/javase/7/docs/api/java/io/package-tree.html
        //java.io.Writer (implements java.lang.Appendable, java.io.Closeable, java.io.Flushable)
        //    java.io.BufferedWriter
        //    java.io.CharArrayWriter
        //    java.io.FilterWriter
        //    java.io.OutputStreamWriter
        //        java.io.FileWriter
        //    java.io.PipedWriter
        //    java.io.PrintWriter
        //    java.io.StringWriter`
        String fpth = "D:\\test.txt";
        Writer writer = new FileWriter(fpth);
        writer = new FileWriter(fin, false);// 預設 false 覆蓋  true append
        writer.flush();/*將緩衝區資料寫到指定檔案*/ writer.write(97);/*char ascii*/
        writer.write(new char[]{'a', 'b'}); writer.write("ab");

        BufferedWriter bwriter = new BufferedWriter(writer, 1000/*可選 不給用預設緩衝區大小*/);
        bwriter.write("java book");
        bwriter.newLine();
        bwriter.write("test");
        bwriter.newLine();
        bwriter.close();
        System.out.println(fpath+"寫檔完成");

        CharArrayWriter cw = new CharArrayWriter(1000/*不給用預設大小緩衝區*/);

        //  位元組資料(二進位檔) 讀取
        //java.io.InputStream (implements java.io.Closeable)
        //    java.io.ByteArrayInputStream
        //    java.io.FileInputStream
        //        java.io.FilterInputStream
        //        java.io.BufferedInputStream
        //        java.io.DataInputStream (implements java.io.DataInput)
        //        java.io.LineNumberInputStream
        //    java.io.PushbackInputStream
        //    java.io.ObjectInputStream (implements java.io.ObjectInput, java.io.ObjectStreamConstants)
        //    java.io.PipedInputStream
        //    java.io.SequenceInputStream
        //    java.io.StringBufferInputStream
        //java.io.ObjectInputStream.GetField

        InputStream inputstm = new FileInputStream(fpth);//File
        inputstm.available();/*可讀到的byte數*/ byte[] buff = new byte[600];
        inputstm.read(buff);/*讀取資料放buff */
        inputstm.mark(500); inputstm.reset();
        inputstm.close();

        FileInputStream fis=new FileInputStream("D:/mytxt.txt");
        size=fis.available();
        byte b[]=new byte[size];
        fis.read(b);
        System.out.println("D:/mytxt.txt可讀位元組的數量：" + size);
        for (int i=0; i<size; i++)
        {
            System.out.print((char)b[i]);
        }
        fis.close();

        BufferedInputStream bf = new BufferedInputStream
                (new FileInputStream("D:/mytxt.txt"), 500);
        size = bf.available();
        b = new byte[size];
        bf.read(b);
        System.out.println("D:/mytxt.txt可讀位元組的數量： " + size);
        for(int i=0;i<size;i++)
        {
            System.out.print((char)b[i]);
        }
        bf.close();

        String str = "Hello World!!!";
        b = str.getBytes();
        ByteArrayInputStream bs = new ByteArrayInputStream(b,0,500);
        size = bs.available();
        for(int i=0;i<size;i++)
        {
            int ch = bs.read();
            System.out.print((char)ch);
        }

        //  位元組資料(二進位檔) 寫入
        //java.io.OutputStream (implements java.io.Closeable, java.io.Flushable)
        //    java.io.ByteArrayOutputStream
        //    java.io.FileOutputStream
        //    java.io.FilterOutputStream
        //        java.io.BufferedOutputStream
        //        java.io.DataOutputStream (implements java.io.DataOutput)
        //        java.io.PrintStream (implements java.lang.Appendable, java.io.Closeable)
        //    java.io.ObjectOutputStream (implements java.io.ObjectOutput, java.io.ObjectStreamConstants)
        //    java.io.PipedOutputStream

        OutputStream fostream = new FileOutputStream(fpath, false);//File  append
        fostream.flush();/*緩衝區資料寫入檔案*/ fostream.write(97);//ascii
        fostream.write(new byte[]{97,98});//ascii

        FileOutputStream f1 = new FileOutputStream("D:/test1.txt");
        FileOutputStream f2 = new FileOutputStream("D:/test2.txt", true);
        String str1 = "Hello World!!!\n", str2="Java SE 8";
        byte b1[] = str1.getBytes(), b2[] = str2.getBytes();
        for(int i=0;i<b1.length;i++)
        {
            f1.write(b1[i]);
        }
        for(int i=0;i<b2.length;i++)
        {
            f2.write(b2[i]);
        }
        //f1.close();
        f2.close();

        OutputStream bfstream = new BufferedOutputStream(f1, 5000/*buff size 不給用預設*/);
        BufferedOutputStream fout=new BufferedOutputStream
                (new FileOutputStream("D:/Sample.txt"));
        str = "Java SE 8";
        b = str.getBytes();
        for(int i=0;i<b.length;i++)
        {
            fout.write(b[i]);
        }
        fout.close();

        str = "Hello World!!!";
        byte a[] = str.getBytes();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(a);
        b = out.toByteArray();
        size = b.length;
        for(int i=0;i<size;i++)
        {
            System.out.print((char)b[i]);
        }




    }
}


class ch15 {
    public static void content() {

        //  15-2 p486
        //  JDBC Java Database Connectivity
        //  import java.sql.*;
        //  下載 mssql-jdbc-9.4.0.jre8.jar
        //  add jar  File > Project Structure > Module > Dependencies > + > jar
        //  https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to
        // -an-intellij-idea-project
        //  加完有更新在 iml
        //
        //  https://en.wikipedia.org/wiki/JAR_(file_format)
        //  A JAR (Java ARchive) is a package file format typically used to aggregate many Java class files and associated metadata and resources (text, images, etc.) into one file for distribution.[3]
        //
        //  JAR files are archive files that include a Java-specific manifest file. They are built
        // on the ZIP format and typically have a .jar file extension.[4]
        //
        //  A JAR file allows Java runtimes to efficiently deploy an entire application, including its classes and their associated resources, in a single request. JAR file elements may be compressed, shortening download times.
        //
        //  A JAR file may contain a manifest file, that is located at META-INF/MANIFEST.MF. The
        // entries in the manifest file describe how to use the JAR file. For instance, a Classpath entry can be used to specify other JAR files to load with the JAR.
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("load jdbc sucesss");
        }
        catch(ClassNotFoundException ce){
            System.out.println("JDBC 沒有驅動程式" + ce.getMessage());
        }
        try {
            Connection cn = DriverManager.getConnection("jdbc:sqlserver://SERVER;user=USR;" +
                    "password=PWD;database=DB");
            System.out.println("get connection sucesss");

            //  ResultSet 介面  Read
            //  ResultSetMetaData 取資料表殼是
            //  Statement Create Update Delete
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from GuidString");
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i=1; i<=metaData.getColumnCount(); i++)
            {
                System.out.print(metaData.getColumnName(i) + "\t");
                System.out.print(metaData.getColumnTypeName(i) + "\t");
            }
            System.out.println("\n-----------------------------");
            while (resultSet.next())
            {
                for (int i=1; i<=metaData.getColumnCount(); i++)
                {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.print("\n");
                //String data = resultSet.getString(1);//index start 1
                //data = resultSet.getString("GUID");//columnName
                //Object obj = resultSet.getObject(1);//index
                ////  getFloat Int Object
            }
            resultSet.close();

            int cou = statement.executeUpdate("UPDATE GuidString SET TXT = 'TEST' WHERE GUID = 'EA4BB1F7-2DD7-E811-9CFC-9EB6D01FF8B7'");//  Insert Update Delete
            cou = statement.getUpdateCount();
            statement.getResultSet();

            statement.close();

            cn.close();
            System.out.println("connection close");

        } catch (SQLException throwables) {
            System.out.println("資料庫連接失敗:\n" + throwables.getMessage());
        }

    }
}

class ch16 {
    public static void content() {

        //  16-2 p504 Lambda
        MyThread obj = new MyThread();
        Thread t = new Thread();
        t.start();
        Thread tAnonymous = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " 印第 " + i + "次");
                }
            }
        });
        tAnonymous.start();
        Thread tLambda = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " 印第 " + i + "次");
            }
        });
        tLambda.start();

        JButton btn = new JButton("Test");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "event processing");
            }
        });
        btn.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "event processing");
        });

        //建立stu[0]~stu[3]的Student物件陣列
        Student[] stu = new Student[]{
                new Student("王小明", 54, 77, 92),
                new Student("李小華", 88, 27, 88),
                new Student("張大立", 83, 77, 99),
                new Student("蔡小強", 66, 44, 72)
        };
        Arrays.sort(stu, new StudentComparator());
        Arrays.sort(stu, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                int a, b, r;
                a = o1.getTotal();
                b = o2.getTotal();
                return a > b ? 1 : a == b ? 0 : a < b ? -1 : -1;
            }
        });
        Arrays.sort(stu, (o1, o2) -> {
            int a, b, r;
            a = o1.getTotal();
            b = o2.getTotal();
            return a > b ? 1 : a == b ? 0 : a < b ? -1 : -1;
        });
        //  Lambda 不用編譯 .class 不用 new 物件 將 Lambda 放入主記憶體 直接 call func 效能好

        String[] arr = new String[]{"t1", "t2"};
        Arrays.sort(arr, (s1, s2) -> s1.compareTo(s2));
        //可以直接調用 api 方便 method reference
        Arrays.sort(arr, String::compareTo);

        //https://www.geeksforgeeks.org/double-colon-operator-in-java/
        //The double colon (::) operator, also known as method reference operator in Java, is used to call a method by referring to it with the help of its class directly. They behave exactly as the lambda expressions. The only difference it has from lambda expressions is that this uses direct reference to the method by name instead of providing a delegate to the method.
        //Syntax:
        //<Class name>::<method name>

        //  Lambda 也可以用在 Collections 走訪 排序 過濾

        MyFuncInterface funcInterface = (i) -> 100;
        ArrayList<String> ls = new ArrayList<>(){};
        ls.add("a");
        ls.add("b");
        ls.add("c");
        filter(ls, new CPredicate());
        filter(ls, s -> s != null && s.length() > 3);



    }


    public static void filter(ArrayList<String> ls, Predicate<String> predicate){
        for (int i = 0; i<ls.size(); i++){
            if(predicate.test(ls.get(i))){
                ls.remove(i);
                i--;
            }
        }
    }
}

@FunctionalInterface
interface MyFuncInterface{
    int getInt(int x);
}

class CPredicate implements Predicate<String>
{
    @Override
    public boolean test(String o) {
        return o != null && o.length() > 3;
    }
}
class CConsumer implements Consumer<String>
{
    @Override
    public void accept(String o) {
        System.out.println(o);
    }
}
class CFunction implements Function<String, String>
{
    @Override
    public String apply(String o) {
        return o != null && o.length() > 4 ? o.substring(1) : null;
    }
}
class CSupplier implements Supplier<String>
{
    @Override
    public String get() {
        return LocalDateTime.now().toString();
    }
}


class ch17 {
    public static void content() {

        //  17-2 p526

        //MyBar bar = new MyBar();

        MyMemoryCard mem = new MyMemoryCard();
    }
}

//  ch16
class MyThread implements Runnable
{
    public void run(){
        for(int i =1; i<= 10; i++){
            System.out.println(Thread.currentThread().getName() + " 印第 " + i + "次");
        }
    }
}
//  ch15
class EditDb
{
    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("JDBC沒有驅動程式" + ce.getMessage());
        }
        int op=0;
        String sqlstr="", id="", name="", position="", salary="";
        try
        {
            op = Integer.parseInt(JOptionPane.showInputDialog
                    ("請選擇選單\n1：新增   2:修改   3:刪除"));
            if (op == 1)
            {
                id = JOptionPane.showInputDialog
                        ("請輸入員工編號").replace("'", "''");
                name = JOptionPane.showInputDialog
                        ("請輸入姓名").replace("'", "''");
                position = JOptionPane.showInputDialog
                        ("請輸入職稱").replace("'", "''");
                salary = JOptionPane.showInputDialog("請輸入薪資(輸入數值)");
                sqlstr = "INSERT INTO 員工(員工編號,姓名,職稱,薪資)Values(" +
                        "'" + id + "','" + name + "','" + position +
                        "'," + salary + ")";
            }
            else if(op == 2)
            {
                id = JOptionPane.showInputDialog
                        ("請輸入欲修改的資料(以員工編號為依據)").replace("'", "''");
                name = JOptionPane.showInputDialog
                        ("請輸入姓名").replace("'", "''");
                position = JOptionPane.showInputDialog
                        ("請輸入職稱").replace("'", "''");
                salary = JOptionPane.showInputDialog("請輸入薪資(輸入數值)");
                sqlstr = "UPDATE 員工 SET 姓名='" + name +
                        "',職稱='" +  position + "',薪資=" + salary +
                        " WHERE 員工編號='" + id + "'" ;
            }
            else if(op == 3)
            {
                id = JOptionPane.showInputDialog
                        ("請輸入欲刪除的資料(以員工編號為依據").replace("'", "''");
                sqlstr = "DELETE FROM 員工 WHERE 員工編號='" + id + "'" ;
            }
        }
        catch(NumberFormatException ne)
        { }

        try
        {
            Connection cn=DriverManager.getConnection
                    ("jdbc:sqlserver://localhost;user=sa;password=ab8626043;database=mydb");
            Statement sm = cn.createStatement();
            if(op != 0)
            {
                sm.executeUpdate(sqlstr);
            }
            ResultSet rs = sm.executeQuery("SELECT * FROM 員工");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println();
            for (int i=1; i<=rsmd.getColumnCount(); i++)
            {
                System.out.print(rsmd.getColumnName(i) + "\t");
            }
            System.out.println("\n-----------------------------");
            while (rs.next())
            {
                System.out.print(rs.getString(1) + "\t" +
                        rs.getString(2) + "\t"+
                        rs.getString(3) + "\t" +
                        rs.getInt(4) + "\n");
            }
            sm.close();
            cn.close();
        }
        catch(SQLException e)
        {
            System.out.println("資料庫連接失敗\n" + e.getMessage());
        }
    }
}


//  ch16
//  學生類別
class Student{
    private String name;	//姓名
    private int chi;		//國文
    private int eng;		//英文
    private int math;		//數學
    public Student(String _name, int _chi, int _eng, int _math){
        name =_name; chi=_chi; eng=_eng; math=_math;
    }
    //getTotal()方法可取得國、英、數三科總分
    public int getTotal(){
        return (chi+eng+math);
    }
    //顯示學生物件姓名以及國、英、數和三科總分
    public void show(){
        System.out.print(name + "  " + chi+ "  " + eng+ "  " + math + "  " + getTotal() + "  ");
    }
}
//StudentComparator類別實作Comparator介面的compare方法
//用來比較Student物件國、英、數三科總分
class StudentComparator implements Comparator<Student> {
    public int compare(Student o1,Student o2) {
        int a, b, r=1;
        a = o1.getTotal();
        b = o2.getTotal();
        if (a>b){
            r = 1;
        }else if (a==b){
            r = 0;
        }else if(a<b){
            r = -1;
        }
        return r;
    }
}

//  ch17
//使用swing元件請匯入javax.swing.*套件

// MyJFrame(拉霸遊戲視窗)繼承JFrame視窗元件
// MyJFrame實作ActionListener介面的actionPerformed方法用來處理按鈕的按一下事件
class MyBar extends JFrame implements ActionListener {
    // 宣告jlbl[0]~jlbl[2]用來當拉霸遊戲三個圖
    private JLabel[] jlbl = new JLabel[3];
    // 宣告 icon[0]~icon[3] 用來存放櫻桃, 星星, 西瓜, bar四個圖示
    // 四個圖示依序為 0.jpg, 1.jpg, 2.jpg, 3.jpg
    private ImageIcon[] icons = new ImageIcon[4];
    // 宣告 jlblSum標籤用來顯示 "總數量：" 訊息
    // 宣告jlblBetting標籤用來顯示 "投注量：" 訊息
    private JLabel jlblSum, jlblBetting;
    // 宣告 jtxtBetting文字方塊用來讓使用者輸入投注量
    private JTextField jtxtBetting;
    // 宣告 jbtnOk "下注" 按鈕
    private JButton jbtnOk;
    private int sum = 50;
    //建構式
    MyBar()
    {
        // 不使用版面配置
        super.setLayout(null);
        // 視窗標題設為 "拉霸遊戲機"
        super.setTitle("拉霸遊戲機");
        // 設定icons[0]~icons[3]元件的圖示為barImg資料夾下的0.jpg~3.jpg


        for(int i=0; i<icons.length; i++){
//            icons[i] = new ImageIcon
//                    ("./barImg/"+ String.valueOf(i) + ".jpg");
            URL url = getClass().getResource("/barImg/" + i +".jpg");
            String p = url.getPath();
            icons[i] = new ImageIcon(p);

        }
        // 建立jlbl[0]~jlbl[2]，並指定三個標籤為櫻桃圖(0.jpg)，最後放入視窗內
        for (int i=0; i<jlbl.length; i++){
            jlbl[i] = new JLabel();
            jlbl[i].setBounds(i*100+10, 10, 86, 86);
            jlbl[i].setIcon(icons[0]);
            add(jlbl[i]);
        }
        // 在視窗放入jlblSum標籤，該標籤顯示 "總數量："
        jlblSum = new JLabel("總數量：" + String.valueOf(sum));
        // 設定jlblSum標籤x座標10, y座標120, 寬160, 高20
        jlblSum.setBounds(10, 120, 160, 20);
        jlblSum.setFont(new Font("微軟中黑體",Font.PLAIN, 18));
        add(jlblSum);
        // 在視窗放入jlblBetting標籤，該標籤顯示 "投注量："
        jlblBetting = new JLabel("投注量：");
        jlblBetting.setBounds(160, 120, 80, 20);
        jlblBetting.setFont(new Font("微軟中黑體",Font.PLAIN, 18));
        add(jlblBetting);
        // 在視窗放入jtxtBetting文字方塊，讓使用輸入投注量
        jtxtBetting = new JTextField();
        jtxtBetting.setBounds(240, 120, 50, 25);
        jtxtBetting.setFont(new Font("微軟中黑體",Font.PLAIN, 18));
        add(jtxtBetting);
        // 在視窗放入jbtnOk下注鈕
        jbtnOk = new JButton("下注");
        jbtnOk.setBounds(10, 160, 80, 30);
        jbtnOk.setFont(new Font("微軟中黑體",Font.PLAIN, 18));
        add(jbtnOk);

        // 指定jbtnOk下注鈕的傾聽者為目前的物件
        // 因此按下注鈕時會執行目前類別的 actionPerformed 方法
        jbtnOk.addActionListener(this);

        // 設定視窗大小為寬320, 高250
        setSize(320, 250);
        // 顯示視窗
        setVisible(true);
        // 設定按視窗的關閉鈕會結束程式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 實作ActionListener介面的actionPerformed方法
    public void actionPerformed(ActionEvent evt) {
        // 建立執行緒t物件，並傳入Runnable介面物件
        // 此執行緒用來啟動拉霸遊戲
        // 讓jlbl[0]~jlbl[2]以亂數方式顯示櫻桃, 星星, 西瓜, bar四個圖示
        // 並判斷是否中獎
        Thread t = new Thread (
                new Runnable(){
                    //實作Runnable介面的run方法
                    public void run(){
                        // k用來計算拉霸遊戲的換圖次數
                        // kind用來表示中獎倍數，kind等於-1表示沒中獎
                        int k=0, kind=-1;
                        //n[0]~n[2] 用來存放產生的亂數值
                        int[] n = new int[jlbl.length];
                        int betting=0;		// 用來存放投注量
                        try{
                            // 若sum總數量等於0，表示沒有可用的投注額即離開遊戲
                            if(sum==0){
                                JOptionPane.showMessageDialog
                                        (null, "您已經破產了!即將離開遊戲");
                                System.exit(0);
                            }
                            // 取得使用者的投注額，並指定給betting
                            betting = Integer.parseInt(jtxtBetting.getText());
                            // 當總數量小於投注額或投注額小於0，表示金額不足
                            if (sum<betting || betting<=0) {
                                JOptionPane.showMessageDialog
                                        (null, "金額不足或金額不對!");
                                return ;
                            }
                            sum-=betting;
                            jlblSum.setText
                                    ("總數量：" + String.valueOf(sum));
                            // 按下注鈕啟動拉霸遊戲機後馬上即停用下注鈕
                            // 防止使用者重複按下
                            jbtnOk.setEnabled(false);
                        }catch(Exception ex){
                            JOptionPane.showMessageDialog
                                    (null, "請輸入數字");
                            return ;
                        }
                        try{
                            do{
                                // 產生0~3之間的亂數並指定給n[0]~n[2]
                                // 並在jlbl[0]~jlbl[2]隨機顯示櫻桃,星星,西瓜,bar圖示
                                for (int i=0; i<jlbl.length; i++){
                                    n[i]=(int)Math.round(Math.random()*3);
                                    jlbl[i].setIcon(icons[n[i]]);
                                }
                                k++;
                                //目前執行緒暫停0.1秒
                                Thread.currentThread().sleep(100);
                            }while(k<10);	// 若k大於0，則停止拉霸遊戲
                        }catch(InterruptedException ex){ }
                        // 判斷中那個獎
                        if (n[0]==0 && n[1]==0 && n[2]==0){
                            kind = 3;	//三個圖為櫻桃, 得3倍
                        }else if(n[0]==1 && n[1]==1 && n[2]==1){
                            kind = 10;	//三個圖為星星, 得10倍
                        }else if(n[0]==2 && n[1]==2 && n[2]==2){
                            kind = 20;	//三個圖為西瓜, 得20倍
                        }else if(n[0]==3 && n[1]==3 && n[2]==3){
                            kind = 50;	//三個圖為bar, 得50倍
                        }
                        // 判斷是否中將，若kind不等於-1表示中獎
                        if (kind!=-1){
                            JOptionPane.showMessageDialog(null,
                                    "中獎得" + String.valueOf(kind) + "倍");
                            // 目前總數量(總投注額)累加中獎數量
                            sum += kind*betting;
                            jlblSum.setText
                                    ("總數量：" + String.valueOf(sum));
                        }
                        jbtnOk.setEnabled(true); // 下注鈕啟用
                    }
                });
        t.start();//啟動執行緒，使拉霸機啟動，此時jlbl[0]~jlbl[2]即以亂數秀圖
    }
}


class MyMemoryCard extends JFrame  {
    // 宣告 icons[0]~icons[4] 用來存放
    // 0.jpg(? 問號圖), 1.jpg, 2.jpg, 3.jpg, 4.jpg五個圖示
    private ImageIcon[] icons = new ImageIcon[5];
    // 宣告jbtn[0]~jbtn[7] 八個按鈕
    private JButton[] jbtn = new JButton[8];
    // 宣告jbtnOk確定鈕, jbtnf 表示第一次按下的按鈕, jbtns 表示第二次按下的按鈕
    private JButton jbtnOk, jbtnf, jbtns;
    // 宣告f表示第一次按下按鈕取得的字串，s表示第二次按下按鈕取得的字串
    String f="", s="";
    // 宣告num表示按下按鈕的次數；win 表示共猜對幾組圖示
    int num=0, win=0;
    // 建立rnd[0]~rnd[7]用來存放記憶大考驗每張圖所代表的編號
    int[] rnd = new int[8];
    // MyJFrame建構式
    MyMemoryCard()
    {
        // 不使用版面配置
        super.setLayout(null);
        // 視窗標題設為 "記憶大考驗"
        super.setTitle("記憶大考驗");
        // 設定icons[0]~icons[4]元件的圖示為memberImg資料夾下的0.jpg~4.jpg
        // 其中0.jpg為?問號圖
        for(int i=0; i<icons.length; i++){
            URL url = getClass().getResource("/memoryImg/" + i +".jpg");
            String p = url.getPath();
            icons[i] = new ImageIcon(p);
//            icons[i] = new ImageIcon
//                    (".\\memoryImg\\" + String.valueOf(i) + ".jpg");
        }

        // 在視窗放入jbtnOk確定鈕
        jbtnOk = new JButton("確定");
        jbtnOk.setBounds(20, 260, 80, 30);
        jbtnOk.setFont(new Font("微軟中黑體",Font.PLAIN, 18));
        add(jbtnOk);
        // 指定jbtnOk確定鈕的傾聽者為ActionListener匿名物件
        // 按下確定鈕時會執行該物件的 actionPerformed 方法
        jbtnOk.addActionListener(new ActionListener(){  //按下確定鈕執行此處
            public void actionPerformed(ActionEvent evt) {
                // 建立ary[0]~ary[7] 用來存放圖示的編號，編號相同的為同一組
                int[] ary = new int[]{1,1,2,2,3,3,4,4};
                int n=0;	// 用來存放產生的亂數
                int max = ary.length-1;
                // 使用迴圈jbtn[0]~jbtn[7]進行亂數存放1.jpg~4.jpg
                // 編號相同為同一組
                for (int i=0; i<ary.length; i++){
                    n = (int)Math.round((Math.random()*max));
                    rnd[i] = ary[n];
                    ary[n] = ary[max];
                    max--;
                    jbtn[i].setActionCommand
                            (String.valueOf(rnd[i]));
                    jbtn[i].setToolTipText(String.valueOf(i));
                    jbtn[i].setIcon(icons[0]);
                    jbtn[i].setEnabled(true);
                }
            }
        });

        // 建立jbtn[0]~jbtn[7] 八個按鈕，排成兩行，一行有四個按鈕
        int x=0, y=0;
        for (int i=0; i<jbtn.length; i++){
            jbtn[i] = new JButton();
            jbtn[i].setBounds(x*100+20, y*120+20, 80, 100);
            jbtn[i].setIcon(icons[0]);		// 按鈕預設顯示 ? 問號圖
            jbtn[i].setEnabled(false);
            x++;
            if (i % 4 == 3){
                y++;
                x = 0;
            }
            // 在視窗放入jbtn[0]~jbtn[7] 八個按鈕
            add(jbtn[i]);
            // 指定jbtn[0]~jbtn[7] 八個按鈕的傾聽者為ActionListener匿名物件
            // 當按下jbtn[0]~jbtn[7] 時會執行該物件的 actionPerformed 方法
            jbtn[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt) {
                    num++;		// 按下按鈕次數加1
                    if (num==1){	// 第一次按下
                        // 取得第一次按下按鈕代表的字串
                        f = evt.getActionCommand();
                        // 取得第一次按下按鈕
                        jbtnf = (JButton)evt.getSource();
                        jbtn[Integer.parseInt(jbtnf.getToolTipText())]
                                .setIcon(icons[Integer.parseInt(f)]);
                    }else if (num==2){	// 第二次按下
                        // 取得第二次按下按鈕代表的字串
                        s = evt.getActionCommand();
                        // 取得第二次按下按鈕
                        jbtns= (JButton)evt.getSource();
                        jbtn[Integer.parseInt(jbtns.getToolTipText())]
                                .setIcon(icons[Integer.parseInt(s)]);
                        //若第一次按下按鈕的f字串與第二次按下按鈕的s字串相等
                        //且第一次按下按鈕與第二次按下按鈕不是同一個，則表示猜對一組圖示
                        if (f.equals(s) && jbtns!=jbtnf){
                            JOptionPane.showMessageDialog
                                    (null, "猜對了!");
                            jbtnf.setEnabled(false);//第一次按鈕的按鈕停用
                            jbtns.setEnabled(false);// 第二次按鈕的按鈕停用
                            win++;				// 猜對組數加一
                            if (win==4){			// 若猜對四組
                                JOptionPane.showMessageDialog
                                        (null, "全對了...ya!");
                            }
                        }else{//若沒有猜對任一組圖示，則之前按下的按鈕皆還原成?問號圖示
                            JOptionPane.showMessageDialog
                                    (null, "不對哦!");
                            jbtnf.setIcon(icons[0]);
                            jbtns.setIcon(icons[0]);
                        }
                        f="";
                        s="";
                        num=0;
                    }
                }
            });
        }

        // 設定視窗大小為寬430, 高360
        setSize(430, 360);
        // 顯示視窗
        setVisible(true);
        // 設定按視窗的關閉鈕會結束程式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
