/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package program;

import java.io.*;

/**
 *
 * @author Piotrek
 */
public class Loasdasdas {
    public static void main(String[] args){

    /*BufferedReader brIn = new BufferedReader(new InputStreamReader(System.in));

    FileWriter fileWriter = null;

    try{
        fileWriter = new FileWriter(file, true);
    }
    catch(IOException e){
        //nie moze otworzyc wskazanego pliku
        return;
    }

    String line = "sfersadsda asdfa sgerg";

    try{
        while(true){
            line = brIn.readLine();
            if("quit".equals(line) || line == null)
                break;
            line += "\n";
            fileWriter.write(line, 0, line.length());
        }
        fileWriter.close();
    }
    catch(IOException e){
        //blad wejscia/wyjscia
        return;
    }*/
    Loasdasdas logger = new Loasdasdas();
    logger.zapisz(1);
    logger.zapisz(2);
  }
  public void zapisz(int x){
    //File file = new File("log5.txt");
    /*FileOutputStream out;
    try{
        out=new FileOutputStream(file);
        BufferedOutputStream bout=new BufferedOutputStream(out);
        StringBuffer sb = new StringBuffer();
        int i = x;
        if(i == 1){
            sb.append("Zalogowano się.");
            sb.append('\r');
            sb.append('\n');
        }else if(i == 2){
            sb.append("Dodano przedmiot.");
            sb.append('\r');
            sb.append('\n');
        }

        bout.write(sb.toString().getBytes());
        bout.flush();
    }catch(FileNotFoundException e){
    }catch(IOException e1){
    }
    */
    try {
      RandomAccessFile zap;
      int liczba = 5;
      zap = new RandomAccessFile("zapis.txt", "rw");
      zap.seek(0);
      zap.writeInt(liczba);
      zap.close();
    }
    catch (IOException e) {
      System.out.println("Blad przy zapisie danych");
    }

  }
}
