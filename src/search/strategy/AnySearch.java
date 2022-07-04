package search.strategy;

import java.util.*;

public class AnySearch implements TypeOfSearch {

    @Override
    public Set<Integer> search(Map<String, ArrayList<Integer>> wordOfPersons) {

        final Set<Integer> filterPeople = new LinkedHashSet<>();

        System.out.println("Enter a name or email to search any suitable people.");
        String inputData = scanner.nextLine().toLowerCase();

        Arrays.stream(inputData.split(" ")).forEach(data -> {
            if (wordOfPersons.containsKey(data)) {
              filterPeople.addAll(wordOfPersons.get(data));
            }
        });

        return filterPeople;
    }

}
