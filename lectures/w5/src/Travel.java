import java.io.*;

public class Travel implements Serializable {

   private String dest; // destynacja podrózy
   private int price;   // cena

   public Travel(String s, int p) {
     dest = s;
     price = p;
   }

   public String getDest() { return dest; }
   public int getPrice() { return price; }
   public String toString() { return dest + ", cena: " + price; }

}
