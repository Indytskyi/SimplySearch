package search.strategy;

import java.util.*;

public class AllSearch implements TypeOfSearch {

    @Override
    public Set<Integer> search(Map<String, ArrayList<Integer>> wordOfPersons) {

        final Set<Integer> filterPeople = new LinkedHashSet<>();

        System.out.println("Enter a name or email to search all suitable people.");
        String inputData = scanner.nextLine().toLowerCase();

        int counter = 0;

        for (String data: inputData.split(" ")) {
            if (wordOfPersons.containsKey(data)) {
                if (counter == 0) {
                    filterPeople.addAll(wordOfPersons.get(data));
                } else {
                    filterPeople.retainAll(wordOfPersons.get(data));
                }
                counter++;
            }
        }

        return filterPeople;

    }

}
