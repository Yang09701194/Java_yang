package Java8_ch11_13;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

//  https://docs.oracle.com/javase/8/docs/
//  https://docs.oracle.com/javase/8/docs/api/index.html
public class ch11_13 {
    public static void content() {

        ch11.content();
        //ch12.content();
        //ch13.content();
    }
}

class ch11 {
    public static void content() {

        //  11-1  p369
        //  Swing 視窗應用程式  最成功的 GUI API 之一
        //  之前是 AWT Abstract Window Toolkit 沒彈性 沒效率 C寫的 不好加元件 不同平台支援不同 要另外寫
        //  Swing 建立在 AWT 上 jdk 1.2 1998
        //  用 Java 寫的 跨平台   佔 Java Foundation Class 大部分  另一部分 AWT
        //  可更換外觀 滑鼠拖放 延伸自訂 特定除厝慢動作執行
        //  新增許多新元件 internal frame progress bar
        //  import javax.swing.*
        //  最上層容器(Container) JFrame (有標題列視窗元件) JDialog JWindow JApplet

        //  將指定元件 > add() > 到中間層容器元件 JPanel > 加到 Container JFrame
        //  以下調用方法 範例都是 繼承 JFrame 後  在建構式執行  new 完視窗的樣式都設定好了
        //  這邊方便檢視才 new 完調用
        JFrame jframe = new JFrame("title"/*可選*/);
        jframe.getContentPane(); jframe.setContentPane(new JPanel());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉紐用預設行為 不用另寫事件
        Component comp = new Box(1);
        jframe.add(comp);
        jframe.remove(comp);
        //jframe.dispose();
        var v = jframe.getIconImage();//最小化圖示
        //jframe.setIconImage(img);//最小化圖示
        String s = jframe.getTitle();jframe.setTitle("title");
        jframe.pack();//自動設定合適大小
        jframe.setBounds(10,10, 500,500);// screen x y width height
        jframe.setVisible(true);// 顯示
        MyJFrameDemo f = new MyJFrameDemo();

        JPanel panel = new JPanel();
        panel.setLayout(null);  // Layout 給 JPanel 用的版面配置
        //  null 絕對座標 BorderLayout 邊緣座標   FlowLayout 流式 display: inline
        //  GridLayout 格線式

        //  null  所有內部元件都用 setBounds 設定 x y w h 元件多時設定過複雜

        //  BorderLayout
        panel.setLayout(new BorderLayout(10, 30));// hgap 元件間垂直間距 , vgap 水平間距
        var layout = BorderLayout.EAST;//SOUTH WEST MORTH CENTER
        var layout2 = FlowLayout.LEFT;//CENTER RIGHT
        var btn = new JButton("txt");
        panel.add(btn, BorderLayout.EAST);
         MyJFrameLayoutAbs absLayout = new MyJFrameLayoutAbs();

        //  FlowLayout
        FlowLayout flayout = new FlowLayout();//預設元件間距 5
        flayout = new FlowLayout(0);//   預設元件間距 5    建構式參數 0 align left 1 center 2 right
        flayout = new FlowLayout(30, 30 , 30);// 建構式參數 aligh hgap vgap
        panel.setLayout(flayout);
        MJFrameFlowLLayout flowLy = new MJFrameFlowLLayout();

        //  Grid Layout
        GridLayout glayout = new GridLayout(3,4, 5,6);//row col hgap vgap
        panel.setLayout(glayout);
        MyJFrameGridLayout gLayout = new MyJFrameGridLayout();

        //  事件來源 > 事件傾聽者 > 事件處理  GUI設計
        var button = new JButton("eventTest");
        button.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "event processing...");
            }
        });
        //button.removeActionListener(listener);
        MyJFrameEvent je = new MyJFrameEvent();

        //  JFrame 本身 如果 implement ActionListener 事件傾聽者介面
        //  也會可 override actionPerformed
        //  就可變成 addActionListener 的傾聽者參數 addActionListener(this)
        //  事件發生時 就會執行 JFrame 的方法
        MyJFrameEvent2 je2 = new MyJFrameEvent2();

        //  Mouse MouseEvent  Keyboard KeyEvent
        //  Button ActionEvent CheckBox/Choice ItemEvent
        //  List/MenuItem ActionEvent/ItemEvent
        //  ScrollBar AdjustEvent
        //  TextField/TextArea TextEvent TextEvent
        //  Window WindowEvent

        //  取得事件來源 e 的按鈕
        //  public void actionPerformed(ActionEvent e) {
        //    JButton hitBtn = (JButton)e.getSource();
        MyJFrameEvent3 ev3 = new MyJFrameEvent3();



    }
}

class ch12 {
    public static void content() {
        //  12-2 p396
        //  常用 Swing 元件 JLabel JTextField JButton ImageIcon JOptionPane

        //  JLabel 文字 圖片 不對鍵盤反應
        Icon icon = new ImageIcon();
        JLabel lbl = new JLabel(icon, JLabel.CENTER);//LEFT RIGHT LEADING TRAILING
        lbl = new JLabel("text", JLabel.LEADING);//LEFT RIGHT LEADING TRAILING
        lbl = new JLabel("text", icon, JLabel.LEADING);//LEFT RIGHT LEADING TRAILING
        lbl.getIcon();//set
        lbl.getText();//set

        ImageIcon icn = new ImageIcon("D:\\test.img");
        MyJFrameLblImg ji = new MyJFrameLblImg();

        JTextField textbox = new JTextField();
        textbox = new JTextField("default"/*可選*/, 3/*width 可選*/);
        var tbx = textbox; tbx.getText();//set
        tbx.getSelectedText(); tbx.setColumns(3);
        tbx.setEditable(true); //tbx.setFont(new Font(font));
        //tbx.addActionListener();   注意到是 synchronized
        MyJFrameTxtField jt = new MyJFrameTxtField();

        JButton btn = new JButton("text"/*可選*/, icon/*可選*/);
        btn.getIcon();/*set*/ btn.getDisabledIcon();/*set*/ btn.getPressedIcon();/*set*/
        btn.getRolloverIcon(); /*滑鼠經過的圖示*/
        btn.setVerticalAlignment(JButton.CENTER);//TOP BOTTOM
        btn.setHorizontalAlignment(JButton.CENTER);//TOP BOTTOM
        btn.getText();/*set*/ btn.setBorderPainted(true);//是否顯示邊框
        btn.setFocusPainted(true);//focus時是否邊框虛線
        //btn.addActionListener();
        JButtonDemo bd = new JButtonDemo();

        //OK Cancel 訊息提示框
        JOptionPane messageBox = new JOptionPane();//OK
        messageBox = new JOptionPane((Object) "message");//確定
        //  圖示 INFORMATION_MESSAGE WARNING_MESSAGE QUESTION_MESSAGE PLAIN_MEASSAGE
        messageBox = new JOptionPane((Object) "message", JOptionPane.ERROR_MESSAGE);
        //  DEFAULT_OPTION YES_NO_CANCEL_OPTION OK_CANCEL_OPTION
        messageBox = new JOptionPane((Object) "message", JOptionPane.ERROR_MESSAGE,
                JOptionPane.YES_NO_OPTION, icon, new Object[]{}/*物件取代按鈕*//*, 按下Enter 空白的預設值*/);
        JFrame jframe = new JFrame();
        JDialog dlg = messageBox.createDialog(jframe, "message");
        var mbox = messageBox;
        mbox.getIcon(); mbox.getInputValue();/*輸入值*/
        mbox.getWantsInput();//是否有輸入區  set boolean
        mbox.setInputValue("default");
        mbox.setSelectionValues(new String[]{"Option1", "2"});//List選單
        JOptionPane.showConfirmDialog(jframe, "msg", "title", JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE);//static create 比較方便 無輸入框
        JOptionPane.showInputDialog(jframe, "msg", "title",
                JOptionPane.ERROR_MESSAGE);//有輸入框
        JOptionPane.showMessageDialog(jframe, "msg", "title",
                JOptionPane.ERROR_MESSAGE);

    }
}

class ch13 {
    public static void content() {
        //  13-2 p424
        JPanel jpanel = new JPanel(/*LayoutManager*/);
        var pnl = jpanel;
        pnl.setBounds(1, 2, 3, 4); //放在母面板的位置  母面板 layout null 才有效
        pnl.setBackground(Color.BLACK);
        pnl.setBorder(BorderFactory.createLineBorder(Color.green, 10/*thick*/));
        pnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "框線帶標題"));
        pnl.setLayout(new FlowLayout(FlowLayout.CENTER));

        JCheckBox chb = new JCheckBox("title", true);
        chb.setSelected(true);//勾選與否
        chb.isSelected();//勾選與否

        ButtonGroup group = new ButtonGroup();
        JRadioButton[] rdb = new JRadioButton[2];
        rdb[0] = new JRadioButton("男", true);
        rdb[1] = new JRadioButton("女");
        for(int i = 0; i < rdb.length; i++) {
            group.add(rdb[i]);
            jpanel.add(rdb[i]);
        }
        rdb[0].addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "event processing...");
            }
        });

        //  \n 可設定自動換行 可搭配 JScrollPane
        JTextArea area = new JTextArea("default", 3,3/*row col長度*/);
        //  多方法同JTextField
        area.append(""); area.insert("",5);area.setRows(3);//可顯示列數
        area.setColumns(9); area.setLineWrap(true);

        // 可放入 Swing 容器  顯示捲籌
        JScrollPane scroll = new JScrollPane(area, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);//NEVER

        JList<String> list = new JList<>(new String[]{"item1", "2"});
        JList<Image> listImg = new JList<>(new Image[]{});
        list.setListData(new String[]{"item1", "2"});
        list.setVisibleRowCount(3); list.getSelectedIndex();
        list.getSelectedValue(); list.getSelectedIndices();
        list.getSelectedValuesList();
        list.addListSelectionListener(new ListSelectionListener() {
            //@Override
            public void valueChanged(ListSelectionEvent e) {
                JOptionPane.showMessageDialog(null, "event processing...");
            }
        });

        JComboBox cbx = new JComboBox(new String[]{"item1", "2"});
        cbx.addItem("3"); cbx.insertItemAt("3", 0);
        cbx.removeItem("3"); cbx.getItemAt(0); cbx.getSelectedItem();//Index
        cbx.setEditable(true);
        cbx.addItemListener(new ItemListener(){
            //@Override
            public void itemStateChanged(ItemEvent e) {
                JOptionPane.showMessageDialog(null, "event processing...");
            }
        });



    }
}




//  ch11
class MyJFrameDemo extends JFrame{
    MyJFrameDemo(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("JFrame視窗");
        setVisible(true);
    }
}
class JFrameDemo {
    public static void main(String[] args){
        MyJFrameDemo f = new MyJFrameDemo();
    }
}
//  ch11
class MyJFrameLayoutAbs extends JFrame{
    private JPanel contentPane;
    MyJFrameLayoutAbs(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btn1 = new JButton("按鈕元件1");
        btn1.setBounds(10, 10, 100, 23);
        contentPane.add(btn1);

        JButton btn2 = new JButton("按鈕元件2");
        btn2.setBounds(74, 76, 100, 23);
        contentPane.add(btn2);

        JButton btn3 = new JButton("按鈕元件3");
        btn3.setBounds(228, 29, 100, 23);
        contentPane.add(btn3);

        JButton btn4 = new JButton("按鈕元件4");
        btn4.setBounds(228, 94, 100, 23);
        contentPane.add(btn4);

        JButton btn5 = new JButton("按鈕元件5");
        btn5.setBounds(151, 144, 100, 23);
        contentPane.add(btn5);
        setVisible(true);
    }
}
class LayoutDemoAbs {
    public static void main(String[] args){
        MyJFrameLayoutAbs f = new MyJFrameLayoutAbs();
    }
}
//
//import java.awt.*;		//使用FlowLayout必須載入awt套件
//import javax.swing.*;
class MJFrameFlowLLayout extends JFrame{
    private JPanel contentPane;
    public MJFrameFlowLLayout(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btn1 = new JButton("按鈕元件1");
        contentPane.add(btn1);

        JButton btn2 = new JButton("按鈕元件2");
        contentPane.add(btn2);

        JButton btn3 = new JButton("按鈕元件3");
        contentPane.add(btn3);

        JButton btn4 = new JButton("按鈕元件4");
        contentPane.add(btn4);

        JButton btn5 = new JButton("按鈕元件5");
        contentPane.add(btn5);
        setVisible(true);
    }
}
class FlowLayoutDemo {
    public static void main(String[] args){
        MJFrameFlowLLayout f= new MJFrameFlowLLayout();
    }
}
//  ch11
//import java.awt.*;			//使用GridLayout必須載入awt套件
//import javax.swing.*;
class MyJFrameGridLayout extends JFrame{
    private JPanel contentPane;
    public MyJFrameGridLayout() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 469, 300);
        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(2, 3, 5, 10));

        JButton btn1 = new JButton("按鈕元件1");
        contentPane.add(btn1);

        JButton btn2 = new JButton("按鈕元件2");
        contentPane.add(btn2);

        JButton btn3 = new JButton("按鈕元件3");
        contentPane.add(btn3);

        JButton btn4 = new JButton("按鈕元件4");
        contentPane.add(btn4);

        JButton btn5 = new JButton("按鈕元件5");
        contentPane.add(btn5);
        setVisible(true);
    }
}
class GridLayoutDemo {
    public static void main(String[] args){
        MyJFrameGridLayout f= new MyJFrameGridLayout();
    }
}
//  ch11
//import java.awt.*;
//import java.awt.event.*;	//使用事件必須載入event套件
//import javax.swing.*;
class MyJFrameEvent extends JFrame{
    private JPanel contentPane;
    public MyJFrameEvent() {
        setTitle("事件處理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton button = new JButton("事件來源");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "處理事件");
            }
        });

        button.setBounds(100, 50, 90, 25);
        contentPane.add(button);
        setVisible(true);
    }
}
class Event{
    public static void main(String[] args){
        MyJFrameEvent f = new MyJFrameEvent();
    }
}
//  ch11
class MyJFrameEvent2 extends JFrame implements ActionListener{
    private JPanel contentPane;
    public MyJFrameEvent2() {
        setTitle("事件處理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton button = new JButton("事件來源");
        button.addActionListener(this);
        button.setBounds(100, 50, 90, 25);
        contentPane.add(button);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "處理事件");
    }
}
class Event2 {
    public static void main(String[] args){
        MyJFrameEvent2 f= new MyJFrameEvent2();
    }
}
//  ch11
class MyJFrameEvent3 extends JFrame implements ActionListener{
    private JPanel contentPane;
    JButton btn1, btn2;
    public MyJFrameEvent3() {
        setTitle("事件處理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btn1 = new JButton("按鈕1");
        btn1.addActionListener(this);
        btn1.setBounds(50, 50, 90, 25);
        contentPane.add(btn1);

        btn2 = new JButton("按鈕2");
        btn2.addActionListener(this);
        btn2.setBounds(150, 50, 90, 25);
        contentPane.add(btn2);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        JButton hitBtn = (JButton)e.getSource();
        JOptionPane.showMessageDialog(null, hitBtn.getText()+
                " - 處理事件");
    }
}
class Event3 {
    public static void main(String[] args){
        MyJFrameEvent3 f= new MyJFrameEvent3();
    }
}
//  ch12
class MyJFrameLblImg extends JFrame{
    private JPanel contentPane;
    String[] imgName = new String[]{"無尾熊", "水母", "企鵝"};
    JLabel[] lbl = new JLabel[imgName.length];
    JLabel[] lblImg = new JLabel[imgName.length];
    MyJFrameLblImg(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        for (int i=0; i<imgName.length; i++){
            lblImg[i] = new JLabel();
            lblImg[i].setIcon(new ImageIcon("..\\ch12\\" +
                    imgName[i] + ".jpg"));
            lblImg[i].setBounds(i*200 +20, 30, 180, 135);
            contentPane.add(lblImg[i]);
            lbl[i] = new JLabel(imgName[i]);
            lbl[i].setBounds(i*200 +100, 180, 50, 20);
            contentPane.add(lbl[i]);
        }
        setVisible(true);
    }
}
class JLabelDemo {
    public static void main(String[] args){
        MyJFrameLblImg f= new MyJFrameLblImg();
    }
}
//  ch12
class MyJFrameTxtField extends JFrame{
    private JPanel contentPane;
    private JTextField txtCity,  txtPhone;
    private JLabel lblCity,  lblPhone, lblTitle  ;
    MyJFrameTxtField(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtCity = new JTextField();
        txtCity.setColumns(10);
        txtCity.setText("台中市");
        txtCity.setBounds(180, 80, 100, 25);
        contentPane.add(txtCity);

        txtPhone = new JTextField();
        txtPhone.setToolTipText("請輸入手機電話");
        txtPhone.setColumns(10);
        txtPhone.setBounds(180, 125, 100, 25);
        contentPane.add(txtPhone);

        lblTitle = new JLabel("個人資訊");
        lblTitle.setBounds(100, 35, 100, 15);
        contentPane.add(lblTitle);

        lblCity = new JLabel("居住城市：");
        lblCity.setBounds(100, 85, 100, 15);
        contentPane.add(lblCity);

        lblPhone = new JLabel("手機電話：");
        lblPhone.setBounds(100, 130, 100, 15);
        contentPane.add(lblPhone);
        setVisible(true);
    }
}
class JTextFieldDemo {
    public static void main(String[] args){
        MyJFrameTxtField f= new MyJFrameTxtField();
    }
}
//  ch12
class MyJFrameBtn extends JFrame{
    private JPanel contentPane;
    private JButton btnGreen, btnYellow;
    public MyJFrameBtn() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnGreen = new JButton("綠色");
        btnGreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                contentPane.setBackground(Color.GREEN);;
            }
        });
        btnGreen.setBounds(100, 100, 100, 25);
        contentPane.add(btnGreen);

        btnYellow = new JButton("黃色");
        btnYellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setBackground(Color.YELLOW);
            }
        });
        btnYellow.setBounds(250, 100, 100, 25);
        contentPane.add(btnYellow);

        setVisible(true);
    }
}
class JButtonDemo {
    public static void main(String[] args){
        MyJFrameBtn f= new MyJFrameBtn();
    }
}
//  ch12
class MyJFrameJOptionPane extends JFrame{
    private JPanel contentPane;
    private JButton btn1, btn2, btn3, btn4, btn5;
    MyJFrameJOptionPane(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout
                (new FlowLayout(FlowLayout.CENTER, 50, 50));
        btn1 = new JButton("錯誤訊息");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "錯誤訊息",
                        "錯誤訊息標題",JOptionPane.ERROR_MESSAGE);
            }
        });
        contentPane.add(btn1);

        btn2 = new JButton("資訊訊息");
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "資訊訊息",
                        "資訊訊息標題",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        contentPane.add(btn2);

        btn3 = new JButton("警示訊息");
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "警示訊息",
                        "警示訊息標題",JOptionPane.WARNING_MESSAGE);
            }
        });
        contentPane.add(btn3);

        btn4 = new JButton("疑問訊息");
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "疑問訊息",
                        "疑問訊息標題",JOptionPane.QUESTION_MESSAGE);
            }
        });
        contentPane.add(btn4);

        btn5 = new JButton("沒有圖示");
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "沒有圖示",
                        "沒有圖示標題",JOptionPane.PLAIN_MESSAGE);
            }
        });
        contentPane.add(btn5);

        setVisible(true);
    }
}
class JOptionPaneDemo {
    public static void main(String[] args){
        MyJFrameBtn f= new MyJFrameBtn();
    }
}
//  ch12
class MyJFrameAnimal extends JFrame{
    private JPanel contentPane;
    String[] imgName = new String[]{"無尾熊", "水母", "企鵝"};
    JButton btnPrev, btnNext;
    JLabel lblName, lblImg, lblShow;
    int n=0;
    MyJFrameAnimal(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 310);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblImg = new  JLabel();
        lblImg.setIcon(new ImageIcon("..\\ex12\\" + imgName[n] + ".jpg"));
        lblImg.setBounds(30, 20, 180, 135);
        contentPane.add(lblImg);

        lblName = new JLabel(imgName[n]);
        lblName.setBounds(30, 170, 180, 25);
        contentPane.add(lblName);

        String show = "第" + (n+1) + "張,共" + imgName.length + "張";
        lblShow = new JLabel(show);
        lblShow.setBounds(30, 200, 180, 25);
        contentPane.add(lblShow);

        btnPrev = new JButton("上一張");
        btnPrev.setBounds(30, 230, 80, 25);
        contentPane.add(btnPrev);
        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                n--;
                if (n<0){
                    n=imgName.length-1;
                }
                lblImg.setIcon(new ImageIcon("..\\ex12\\" + imgName[n] + ".jpg"));
                lblName.setText(imgName[n]);
                lblShow.setText("第" + (n+1) + "張,共" + imgName.length + "張");
            }
        });

        btnNext = new JButton("下一張");
        btnNext.setBounds(120, 230, 80, 25);
        contentPane.add(btnNext);
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                n++;
                if (n>=imgName.length){
                    n=0;
                }
                lblImg.setIcon(new ImageIcon("..\\ex12\\" + imgName[n] + ".jpg"));
                lblName.setText(imgName[n]);
                lblShow.setText("第" + (n+1) + "張,共" + imgName.length + "張");
            }
        });

        setVisible(true);
    }
}
class AnimalDemo {
    public static void main(String[] args){
        MyJFrameAnimal f= new MyJFrameAnimal();
    }
}
//  ch13
class FlowLayoutP extends JFrame {
    FlowLayoutP() {                   // 預設建構式
        setTitle("JPanelDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 280, 200);
        setLayout(null);

        JPanel pan = new JPanel();
        add(pan);
        pan.setBounds(150, 20, 100, 120);
        pan.setBackground(Color.yellow);
        pan.setBorder(BorderFactory.createLineBorder(Color.black));
        pan.setLayout(new FlowLayout(FlowLayout.LEFT));

        String st[] = {"按鈕A", "按鈕B", "按鈕C"};
        JButton btn[] = new JButton[st.length];   // 建立按鈕陣列元件
        for(int i = 0; i < st.length; i++) {
            btn[i] = new JButton(st[i]);
            pan.add(btn[i]);        // 將按鈕元件依序加入 pan面板物件
        }

        setVisible(true);
    }
}
class JPanelDemo {
    public static void main(String[] args) {
        new FlowLayoutP();      // 執行此行會自動執行FlowLayoutP()預設建構式
    }
}
//  ch13
class BorderJPanel extends JFrame {
    BorderJPanel() {              // 預設建構式
        setTitle("BorderDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 280, 200);
        setLayout(null);

        JPanel pan = new JPanel();    // 產生屬於 JPanel類別的pan面板物件
        add(pan);          // 新增pan面板物件於視窗上
        pan.setBounds(150, 20, 100, 120);
        Border lineB = BorderFactory.createLineBorder(Color.black);
        pan.setBorder(BorderFactory.createTitledBorder(lineB, "框架"));

        setVisible(true);
    }
}
class BorderDemo {
    public static void main(String[] args) {
        new BorderJPanel();      // 執行此行會自動執行 BorderJPanel()預設建構式
    }
}
//  ch13
class InterFrameChbox extends JFrame {
    InterFrameChbox() {           // 預設建構式
        setTitle("JCheckBoxDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 270, 250);
        setLayout(null);

        JPanel panInter = new JPanel();
        add(panInter);
        panInter.setBounds(110, 60, 80, 120);
        Border lineB = BorderFactory.createLineBorder(Color.black);
        panInter.setBorder(BorderFactory.createTitledBorder(lineB, "興趣"));
        panInter.setLayout(new FlowLayout(FlowLayout.LEFT));
        JCheckBox[] chk = new JCheckBox[3];
        chk[0] = new JCheckBox("音樂", true);
        chk[1] = new JCheckBox("繪圖");
        chk[2] = new JCheckBox("表演", true);
        for(int j = 0; j < chk.length; j++)
            panInter.add(chk[j]);

        setVisible(true);
    }
}
class JCheckBoxDemo
{
    public static void main(String[] args)
    {
        new InterFrameChbox();  // 執行此行會自動執行InterFrame()預設建構式
    }
}
//  ch13
class InterFrameRdBtn extends JFrame {
    InterFrameRdBtn() {
        setTitle("JRadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 280, 250);
        setLayout(null);

        JPanel panSex = new JPanel();
        add(panSex);
        panSex.setBounds(20, 60, 80, 120);
        Border lineB = BorderFactory.createLineBorder(Color.black);
        panSex.setBorder(BorderFactory.createTitledBorder(lineB, "性別"));
        panSex.setLayout(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup group = new ButtonGroup();
        JRadioButton[] rdb = new JRadioButton[2];
        rdb[0] = new JRadioButton("男", true);
        rdb[1] = new JRadioButton("女");
        for(int i = 0; i < rdb.length; i++) {
            group.add(rdb[i]);
            panSex.add(rdb[i]);
        }

        setVisible(true);
    }
}
class JRadioButtonDemo {
    public static void main(String[] args) {
        new InterFrameRdBtn();
    }
}
//  ch13
class InterFrameChbRdbEvent extends JFrame implements ActionListener {
    private Border lineB = BorderFactory.createLineBorder(Color.black);
    private JRadioButton[] rdb = new JRadioButton[2];
    private JCheckBox[] chk = new JCheckBox[3];
    private JLabel lblShow = new JLabel("請輸入姓名、選擇興趣...");

    InterFrameChbRdbEvent() {                    // 預設建構式
        setTitle("興趣調查表");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 250, 240);
        setLayout(null);

        JPanel panSex = new JPanel();
        add(panSex);
        panSex.setBounds(30, 20, 80, 120);
        panSex.setBorder(BorderFactory.createTitledBorder(lineB, "性別"));
        panSex.setLayout(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup group = new ButtonGroup();
        rdb[0] = new JRadioButton("男", true);
        rdb[1] = new JRadioButton("女");
        for(int i = 0; i < rdb.length; i++) {
            group.add(rdb[i]);
            panSex.add(rdb[i]);
            rdb[i].addActionListener(this);
        }

        JPanel panInter = new JPanel();
        add(panInter);
        panInter.setBounds(130, 20, 80, 120);
        panInter.setBorder(BorderFactory.createTitledBorder(lineB, "興趣"));
        panInter.setLayout(new FlowLayout(FlowLayout.LEFT));
        chk[0] = new JCheckBox("音樂");
        chk[1] = new JCheckBox("繪圖");
        chk[2] = new JCheckBox("表演");
        for(int j = 0; j < chk.length; j++) {
            panInter.add(chk[j]);
            chk[j].addActionListener(this);
        }

        add(lblShow);
        lblShow.setBounds(20, 160, 200, 30);
        lblShow.setBorder(lineB);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String stShow = "";
        if (rdb[0].isSelected()) stShow += "先生，你";
        else stShow += "小姐，妳";

        if (!(chk[0].isSelected() || chk[1].isSelected() || chk[2].isSelected()))
            stShow += "是個無趣的人。";
        else {
            String inter = "";
            if (chk[0].isSelected()) inter += chk[0].getText() + " ";
            if (chk[1].isSelected()) inter += chk[1].getText() + " ";
            if (chk[2].isSelected()) inter += chk[2].getText();
            stShow += "的興趣是 " + inter;
        }
        lblShow.setText(stShow);
    }
}
class Interest {
    public static void main(String[] args) {
        new InterFrameChbRdbEvent();     // 執行此行會自動執行 InterFrame()預設建構式
    }
}
//  ch13
class TextAreaF extends JFrame {
    TextAreaF() {
        setTitle("多行文字方塊");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 325, 150);
        setLayout(null);

        String st1 = "擁有與浪費\n";
        String st2 = "擁有一個東西，你享受它，同時你也是受到它的支配、";
        String st3 = "它的擁有。如果它讓你付出時間、精神、金錢，";
        String st4 = "而沒有提供你相對的價值和利益。那麼擁有就是浪費，";
        String st5 = "浪費你的時間，浪費你的精神，浪費你的金錢。";
        JTextArea txtST = new JTextArea(st1);
        txtST.append(st2);
        txtST.append(st3);
        txtST.append(st4);
        txtST.append(st5);
        txtST.setLineWrap(true);
        add(txtST);
        txtST.setBounds(5, 5, 300, 100);
        txtST.setBorder(BorderFactory.createLineBorder(Color.blue));

        setVisible(true);
    }
}
class JTextAreaDemo {
    public static void main(String[] args) {
        new TextAreaFScroll();
    }
}
//  ch13
class TextAreaFScroll extends JFrame {
    TextAreaFScroll() {
        setTitle("捲軸面板");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 325, 150);
        setLayout(null);

        String st1 = "擁有與浪費\n";
        String st2 = "擁有一個東西，你享受它，同時你也是受到它的支配、";
        String st3 = "它的擁有。如果它讓你付出時間、精神、金錢，";
        String st4 = "而沒有提供你相對的價值和利益。那麼擁有就是浪費，";
        String st5 = "浪費你的時間，浪費你的精神，浪費你的金錢。";
        JTextArea txtST = new JTextArea(st1);
        txtST.append(st2);
        txtST.append(st3);
        txtST.append(st4);
        txtST.append(st5);
        txtST.setLineWrap(true);
        JScrollPane span = new JScrollPane(txtST,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        span.setBounds(5, 5, 200, 90);
        add(span);

        setVisible(true);
    }
}
class JScrollPaneDemo {
    public static void main(String[] args) {
        new TextAreaFScroll();
    }
}
//  ch13
class ListF extends JFrame implements ListSelectionListener {
    private JLabel lblName = new JLabel("書目：");
    private String[] book = {"航海王", "暮光之城", "昆蟲記", "山楂樹之戀", "完美小孩", "物理馬戲團"};
    private JList<String> lst = new JList<>(book);
    private JTextArea txtShow = new JTextArea("可選取書目...", 3, 14);

    public ListF() {
        setTitle("圖書管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 225, 245);
        setLayout(null);

        JPanel panBook = new JPanel();
        add(panBook);
        panBook.setBounds(10, 10, 90, 120);
        panBook.setLayout(new FlowLayout(FlowLayout.LEFT));
        panBook.add(lblName);
        JScrollPane scrList = new JScrollPane(lst);
        panBook.add(scrList);
        lst.setVisibleRowCount(4);
        lst.addListSelectionListener(this);

        JPanel panShow = new JPanel();
        add(panShow);
        panShow.setBounds(10, 130, 180, 100);
        panShow.setLayout(new FlowLayout(FlowLayout.LEFT));
        JScrollPane scrShow = new JScrollPane(txtShow,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panShow.add(scrShow);

        setVisible(true);
    }

    public void valueChanged(ListSelectionEvent e) {
        ArrayList<String> values = new ArrayList<>(lst.getSelectedValuesList());
        int[] indices = lst.getSelectedIndices();
        String show = "";
        int i = 0;
        for (String s : values) {
            show += s + ", index = " + indices[i] + "\n";
            i++;
        }
        txtShow.setText(show);
    }
}
class JListDemo {
    public static void main(String[] args) {
        new ListF();
    }
}
// ch13
class ComboF extends JFrame implements ItemListener, ActionListener {
    private JLabel lblName = new JLabel("書目：");
    private String[] book = {"航海王", "暮光之城", "山楂樹之戀", "物理馬戲團"};
    private JComboBox<String> cbo = new JComboBox<>(book);
    private JLabel lblShow = new JLabel("可選取、新增、刪除書目...");
    private JButton btnAdd = new JButton("新增");
    private JButton btnDel = new JButton("刪除");

    public ComboF() {
        setTitle("圖書管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 225, 240);
        setLayout(null);

        JPanel panBook = new JPanel();
        add(panBook);
        panBook.setBounds(10, 10, 100, 120);
        panBook.setLayout(new FlowLayout(FlowLayout.LEFT));
        panBook.add(lblName);
        panBook.add(cbo);
        cbo.addItemListener(this);

        JPanel panBtn = new JPanel();
        add(panBtn);
        panBtn.setBounds(120, 50, 80, 70);
        panBtn.setLayout(new FlowLayout(FlowLayout.LEFT));
        panBtn.add(btnAdd);
        panBtn.add(btnDel);
        btnAdd.addActionListener(this);
        btnDel.addActionListener(this);

        add(lblShow);
        lblShow.setBounds(10, 160, 180, 30);
        lblShow.setBorder(BorderFactory.createLineBorder(Color.red));

        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        Object show = cbo.getSelectedItem();
        int index = cbo.getSelectedIndex();
        lblShow.setText(show + "，index = " + index);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String bookName = JOptionPane.showInputDialog("請輸入書目名稱");
            cbo.addItem(bookName);
            lblShow.setText("加入 " + bookName + " 書目至最後一筆");
        }
        if (e.getSource() == btnDel) {
            Object select = cbo.getSelectedItem();
            cbo.removeItem(select);
            lblShow.setText("刪除 " + select + " 書目");
        }
    }
}
class JComboBoxDemo {
    public static void main(String[] args) {
        new ComboF();
    }
}

