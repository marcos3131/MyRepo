import java.util.*;

class Lists {

  long start;

  void setTimer() { start = System.currentTimeMillis(); }
  long elapsed() { return System.currentTimeMillis() - start; }

  public Lists(int n) {
    ArrayList aList = new ArrayList(n);
    for (int i=0; i < n; i++) aList.add("a");
    LinkedList lList = new LinkedList(aList);
    setTimer();
    randomAccess(aList);
    System.out.println("Swobodny dostêp do ArrayList: " + elapsed() + " ms");
    setTimer();
    randomAccess(lList);
    System.out.println("Swobodny dostêp do LinkedList: " + elapsed() + " ms");
    setTimer();
    insert(aList);
    System.out.println("Wpisywanie na ArrayList: " + elapsed() + " ms");
    setTimer();
    insert(lList);
    System.out.println("Wpisywanie na LinkedList: " + elapsed() + " ms");
  }

  void randomAccess(List l) {
    Random rand = new Random();
    for (int i=0; i<10000; i++) {
      int index = rand.nextInt(l.size());
      String s = (String) l.get(index);
      s = s + "a";
      l.set(index, s);
    }
  }

  void insert(List l) {
    ListIterator iter = l.listIterator();
    int i = 0;
    while (iter.hasNext()) {
      iter.next();
      if (i % 2 != 0) iter.add("b");
      i++;
    }
  }


  public static void main(String args[]) {
    new Lists(Integer.parseInt(args[0]));
  }
}
