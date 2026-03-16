package com.softserve.academy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookManagerTest {

    private BookManager bookManager;

    @BeforeEach
    void setUp() {
        bookManager = new BookManager();
        bookManager.addBook(new Book("The Great Adventure", "Alice Johnson", "Drama", 2022));
        bookManager.addBook(new Book("Space Odyssey", "Alice Johnson", "Fantastic", 2024));
        bookManager.addBook(new Book("Life's Journey", "Bob Smith", "Drama", 2021));
        bookManager.addBook(new Book("Science Explained", "Charlie Brown", "Science", 2019));
    }

    @Test
    void shouldAddNewUniqueBook() {
        // Arrange
        Book newBook = new Book("New Discoveries", "Diana Green", "Drama", 2024);

        // Act
        bookManager.addBook(newBook);

        // Assert
        assertEquals(5, bookManager.size());
    }

    @Test
    void shouldThrowExceptionWhenAddingNullBook() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(null));
    }

    @Test
    void shouldReturnListOfAllUniqueAuthors() {
        // Act
        List<String> authors = bookManager.listOfAllAuthors();

        // Assert
        assertEquals(3, authors.size());
        assertTrue(authors.contains("Alice Johnson"));
        assertTrue(authors.contains("Bob Smith"));
        assertTrue(authors.contains("Charlie Brown"));
    }

    @Test
    void shouldReturnAuthorsForExistingGenre() {
        // Act
        List<String> authors = bookManager.listAuthorsByGenre("Drama");

        // Assert
        assertEquals(2, authors.size());
        assertTrue(authors.contains("Alice Johnson"));
        assertTrue(authors.contains("Bob Smith"));
    }

    @Test
    void shouldReturnEmptyOptionalForNonExistingAuthor() {
        // Act
        Optional<Book> result = bookManager.findBookByAuthor("Unknown Author");

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    void shouldFindAllBooksByGenre() {
        // Act
        List<Book> books = bookManager.findBooksByGenre("Drama");

        // Assert
        assertEquals(2, books.size());
    }

    @Test
    void shouldRemoveAllBooksByAuthor() {
        // Act
        bookManager.removeBooksByAuthor("Alice Johnson");

        // Assert
        assertEquals(2, bookManager.size());
    }

    @Test
    void shouldThrowExceptionWhenCriterionIsInvalid() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bookManager.sortBooksByCriterion("invalid"));
    }

    @Test
    void shouldReturnCorrectSize() {
        // Act
        int size = bookManager.size();

        // Assert
        assertEquals(4, size);
    }
}
