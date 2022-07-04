package search.logic;

import search.logic.MapFinder;
import search.strategy.AllSearch;
import search.strategy.AnySearch;
import search.strategy.FindPerson;
import search.strategy.NoneSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static List<String> peopleData = new ArrayList<>();

    private void menu() {
        MapFinder mapFinder = new MapFinder();
        mapFinder.fillingMap(peopleData);


        FindPerson findPerson = new FindPerson(peopleData);

        while (true) {
            System.out.println("""
                    === Menu ===
                    1. Find a person
                    2. Print all people
                    0. Exit""");
            int controller;
            String controllerString = scanner.nextLine();
            if (!controllerString.matches("[0-2]")) {
                System.out.println("Incorrect option! Try again.");
                continue;
            } else {
                controller = Integer.parseInt(controllerString);
            }

            switch (controller) {
                case 1 -> {
                    typeOfStrategy(findPerson);
                    findPerson.search(mapFinder.getWordOfPersons());
                }

                case 2 -> printAllPerson();

                case 0 -> {
                    System.out.println("\nBye!");
                    return;
                }
            }
        }
    }

    private void typeOfStrategy(FindPerson findPerson) {
        while (true) {
            System.out.println("Select a matching strategy: ALL, ANY, NONE");
            String strategy = scanner.nextLine();

            switch (strategy) {
                case "ALL" -> {
                    findPerson.setTypeOfSearch(new AllSearch());
                    return;
                }

                case "ANY" -> {
                    findPerson.setTypeOfSearch(new AnySearch());
                    return;
                }

                case "NONE" -> {
                    findPerson.setTypeOfSearch(new NoneSearch());
                    return;
                }
            }

        }
    }

    private void printAllPerson() {
        System.out.println("\n=== List of people ===");
        peopleData.forEach(System.out::println);
    }

    public void getFromFileDataOfPeople() {
        File file = new File("./src/text.txt");

        try (Scanner scanner1 = new Scanner(file)) {
            while (scanner1.hasNext()) {
                peopleData.add(scanner1.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        menu();
    }
}
