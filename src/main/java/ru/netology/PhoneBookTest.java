package ru.netology;

import org.junit.jupiter.api.Test;

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
}
