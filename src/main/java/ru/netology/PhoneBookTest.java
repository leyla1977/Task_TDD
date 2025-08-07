package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class PhoneBookTest {
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

}
