package search.strategy;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public interface TypeOfSearch {
    Scanner scanner = new Scanner(System.in);
    Set<Integer> search(Map<String, ArrayList<Integer>> wordOfPersons);
}
