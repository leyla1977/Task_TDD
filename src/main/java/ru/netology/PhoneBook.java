package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    //2 мапы - имя по номеру и номер по имени
    Map<String, String> nameToNumber = new HashMap<>();
    Map<String, String> numberToName = new HashMap<>();

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

    // Заглушка printAllNames
    public String printAllNames() {
        return null;
    }

}
