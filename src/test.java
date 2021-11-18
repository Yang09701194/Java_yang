import Java8_ch567.ch567;
import Java8_ch8910.ch8910;
import Java8_ch11_13.*;
import Java8_ch14_17.*;
import test123.*;
import DS.*;
import Java8_ch1234.*;
import java.time.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

interface T{

}
class TT implements  T{
    TT(){
        this(1);
    }
    TT(int i){
    }

    public void k() throws IOException{

        try {
            throw  new RuntimeException();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private int i;
    private void set(){
    }
}
class TTT extends  TT{
    TTT(){
        this(1);
    }
    TTT(int i){

    }

 private void t(){
     set();
 }
    protected void set(){
    }
}




public class test {

    public static void main(String[] args) throws IOException {

        var d = LocalDate.parse("2016-05-05");
        var v = d.format(DateTimeFormatter.ISO_DATE_TIME);


        ch14_17.content();
        //ch11_13.content();
        //ch8910.content();
        //ch567.content();
        //ch1234.content();

        //HashTest.HashTestFunc();
        //PriorityQueueExample.main(new String[]{});
        //System.out.println("");
        //System.out.println("hello world!");
//        IteratorTest t = new IteratorTest();
//        t.Test1();

        System.out.println("");

//        test2.main2();

    }
}
