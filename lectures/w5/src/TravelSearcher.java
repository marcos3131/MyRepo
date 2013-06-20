import java.io.*;

public class TravelSearcher implements Serializable {

  private Travel[] travel;            // tablica podró¿y
  private int lastIndex = -1;         // indeks ostatnio zapisanej
  private final int MAX_COUNT = 5;    // max rozmiar tablicy
  private boolean sorted = false;     // czy jest posortowana

  // Konstruktor: tworzy tablicê
  public TravelSearcher() {
    travel = new Travel[MAX_COUNT];
  }

  // Metoda add dodaje nowy element do tablicy
  // je¿eli przekrozcono zakres
  // - zg³aszany jest wyj¹tek w³asnej klasy NoSpaceForTravelException
  public void add(Travel t) throws NoSpaceForTravelException {
    try {
      lastIndex++;
      travel[lastIndex] = t;
    } catch (ArrayIndexOutOfBoundsException exc) {
        lastIndex--;
        throw new NoSpaceForTravelException("Brakuje miejsca dla dodania podró¿y");
    }
    sorted = false;
  }

  // Jaki jest ostatni zapisany indeks
  public int getLastIndex() { return lastIndex; }


  // Wyszukiwanie podró¿y na podstawie podanego celu (destynacji)
  public Travel search(String dest) {
    if (!sorted) sortByDest();
    // ... wyszukiwanie binarne
  }

  // Sortowanie - aby mo¿na by³o stosowaæ wyszukiwanie binarne
  private void sortByDest() {
    // ... sortowanie
    sorted = true;
  }

  public String toString() {
    // zwraca spis podró¿y z tablicy travel (destynacji i cen)
  }

}
