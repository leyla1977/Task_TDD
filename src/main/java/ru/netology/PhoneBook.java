package ru.netology;

import java.util.*;

public class PhoneBook {

    // мапу Map<String, String> nameToNumber = new HashMap<>(); меняю на
    // private Map<String, String> nameToNumber = new TreeMap<>();
    // так как TreeMap хранит данные в алфавитном порядке.
    Map<String, String> numberToName = new HashMap<>();
    private Map<String, String> nameToNumber = new TreeMap<>();
    // add измененный
    public int add(String name, String number) {
        if (!nameToNumber.containsKey(name)) {
            nameToNumber.put(name, number);
            numberToName.put(number, name);
        }
        return nameToNumber.size();
    }


    //  findByNumber
    public String findByNumber(String number) {
        return numberToName.get(number);
    }

    //   findByName
    public String findByName(String name) {
        return nameToNumber.get(name);
    }

    //  printAllNames
    public String printAllNames() {
        return String.join("\n", nameToNumber.keySet()) + "\n";
    }

}
