import java.io.*;

public class TravelSearcher implements Serializable {

  private Travel[] travel;            // tablica podr�y
  private int lastIndex = -1;         // indeks ostatnio zapisanej
  private final int MAX_COUNT = 5;    // max rozmiar tablicy
  private boolean sorted = false;     // czy jest posortowana

  // Konstruktor: tworzy tablic�
  public TravelSearcher() {
    travel = new Travel[MAX_COUNT];
  }

  // Metoda add dodaje nowy element do tablicy
  // je�eli przekrozcono zakres
  // - zg�aszany jest wyj�tek w�asnej klasy NoSpaceForTravelException
  public void add(Travel t) throws NoSpaceForTravelException {
    try {
      lastIndex++;
      travel[lastIndex] = t;
    } catch (ArrayIndexOutOfBoundsException exc) {
        lastIndex--;
        throw new NoSpaceForTravelException("Brakuje miejsca dla dodania podr�y");
    }
    sorted = false;
  }

  // Jaki jest ostatni zapisany indeks
  public int getLastIndex() { return lastIndex; }


  // Wyszukiwanie podr�y na podstawie podanego celu (destynacji)
  public Travel search(String dest) {
    if (!sorted) sortByDest();
    // ... wyszukiwanie binarne
    return new Travel("asdf", 1);
  }

  // Sortowanie - aby mo�na by�o stosowa� wyszukiwanie binarne
  private void sortByDest() {
    // ... sortowanie
    sorted = true;
  }

  public String toString() {
    // zwraca spis podr�y z tablicy travel (destynacji i cen)
	  return "Method not filled yet";
  }

}
