/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package program;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author Piotrek
 */
public class Logger { // techniak zapisywania po czesci wzieta z -> http://www.rgagnon.com/javadetails/java-0054.html
public void loggerBlad(int x){
  try {
    PrintStream out =
        new PrintStream(new AppendFileStream("logger.txt"));
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
    if(x == 1){
        out.print(sdf.format(cal.getTime()));
        out.print('\r');
        out.print('\n');
        out.print("Uruchomiono panel logowania");
        out.print('\r');
        out.print('\n');
        out.close();
    }else if(x == 2){
        out.print(sdf.format(cal.getTime()));
        out.print('\r');
        out.print('\n');
        out.print("Zalogowano poprawnie");
        out.print('\r');
        out.print('\n');
        out.close();
    }else if(x == 3){
        out.print(sdf.format(cal.getTime()));
        out.print('\r');
        out.print('\n');
        out.print("Błędne logowanie");
        out.print('\r');
        out.print('\n');
        out.close();
    }else if(x == 4){
        out.print(sdf.format(cal.getTime()));
        out.print('\r');
        out.print('\n');
        out.print("Dodano przedmiot");
        out.print('\r');
        out.print('\n');
        out.close();
    }else if(x == 5){
        out.print(sdf.format(cal.getTime()));
        out.print('\r');
        out.print('\n');
        out.print("Dodano pytanie");
        out.print('\r');
        out.print('\n');
        out.close();
    }else if(x == 6){
        out.print(sdf.format(cal.getTime()));
        out.print('\r');
        out.print('\n');
        out.print("Usunięto przedmiot");
        out.print('\r');
        out.print('\n');
        out.close();
    }else if(x == 7){
        out.print(sdf.format(cal.getTime()));
        out.print('\r');
        out.print('\n');
        out.print("Usunięto pytanie");
        out.print('\r');
        out.print('\n');
        out.close();
    }else if(x == 8){
        out.print(sdf.format(cal.getTime()));
        out.print('\r');
        out.print('\n');
        out.print("Wczytano plik");
        out.print('\r');
        out.print('\n');
        out.close();
    }else if(x == 9){
        out.print(sdf.format(cal.getTime()));
        out.print('\r');
        out.print('\n');
        out.print("Zapisano plik");
        out.print('\r');
        out.print('\n');
        out.close();
    }else if(x == 10){
        out.print(sdf.format(cal.getTime()));
        out.print('\r');
        out.print('\n');
        out.print("Edytowano przedmiot");
        out.print('\r');
        out.print('\n');
        out.close();
    }else if(x == 11){
        out.print(sdf.format(cal.getTime()));
        out.print('\r');
        out.print('\n');
        out.print("Edytowano pytanie");
        out.print('\r');
        out.print('\n');
        out.close();
    }
    }
   catch(Exception e) {
    System.out.println(e.toString());
    }
   }
}
class AppendFileStream extends OutputStream  {
   RandomAccessFile fd;
   public AppendFileStream(String file) throws IOException {
     fd = new RandomAccessFile(file,"rw");
     fd.seek(fd.length());
     }
   public void close() throws IOException {
     fd.close();
     }
   public void write(byte[] b) throws IOException {
     fd.write(b);
     }
   public void write(byte[] b,int off,int len) throws IOException {
     fd.write(b,off,len);
     }
   public void write(int b) throws IOException {
     fd.write(b);
     }

}
