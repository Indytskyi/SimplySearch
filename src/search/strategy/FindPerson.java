package search.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindPerson {
    private final List<String> allPeopleDataFromFile;
    private TypeOfSearch typeOfSearch;
    private Set<Integer> filterIndexOfPeople;


    public FindPerson(List<String> allPeopleDataFromFile) {
        this.allPeopleDataFromFile = allPeopleDataFromFile;
    }

    public void setTypeOfSearch(TypeOfSearch typeOfSearch) {
        this.typeOfSearch = typeOfSearch;
    }

    public void search(Map<String, ArrayList<Integer>> wordOfPersons) {
        filterIndexOfPeople = this.typeOfSearch.search(wordOfPersons);
        view();
    }

    public void view() {

        if (filterIndexOfPeople.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(filterIndexOfPeople.size() + " person found:");
            filterIndexOfPeople.forEach(i -> System.out.println(allPeopleDataFromFile.get(i)));
        }
    }


}
