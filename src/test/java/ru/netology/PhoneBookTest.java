package ru.netology;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PhoneBookTest {
    // тесты add
    @Test
    void testAddNewContact() {
        PhoneBook phoneBook = new PhoneBook();
        int size = phoneBook.add("Alice", "9101234567");
        assertEquals(1, size);
    }

    @Test
    void testAddDuplicateContact() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Bob", "9259876543");
        int size = phoneBook.add("Bob", "9259876543"); // Дубликат по имени
        assertEquals(1, size); // Размер не увеличивается
    }

    // тесты fındByNumber
    @Test
    void testFindByNumber_existingNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "9101234567");

        String result = phoneBook.findByNumber("9101234567");

        assertEquals("Alice", result);
    }

    @Test
    void testFindByNumber_nonExistingNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Bob", "9259876543");

        String result = phoneBook.findByNumber("0000000000");

        assertNull(result);
    }

    //тесты findByName

    @Test
    void testFindByNameExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "9101234567");

        String result = phoneBook.findByName("Alice");

        assertEquals("9101234567", result); // должен вернуть номер
    }

    @Test
    void testFindByNameNonExisting() {
        PhoneBook phoneBook = new PhoneBook();

        String result = phoneBook.findByName("Bob");

        assertNull(result); // имени нет — возвращает null
    }

    //тесты printAllNames
    @Test
    void testPrintAllNamesEmpty() {
        PhoneBook phoneBook = new PhoneBook();
        assertEquals("", phoneBook.printAllNames());
    }

    @Test
    void testPrintAllNamesMultiple() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Michael", "9101256347");
        phoneBook.add("Alice", "9101234567");
        phoneBook.add("Bob", "9259876543");

        // Ожидаемый список имён
        List<String> expectedNames = List.of("Alice", "Bob", "Michael");

        // Полученные имена из метода
        String result = phoneBook.printAllNames();

        // Преобразуем строку обратно в список
        List<String> actualNames = Arrays.asList(result.strip().split("\\R")); // \\R — любой перенос строки

        assertEquals(expectedNames, actualNames);
    }


}
