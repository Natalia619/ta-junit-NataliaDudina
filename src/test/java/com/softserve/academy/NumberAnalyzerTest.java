package com.softserve.academy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberAnalyzerTest {

    private NumberAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new NumberAnalyzer(new ArrayList<>(Arrays.asList(
                45, 12, 78, 23, 56, 89, 34, 67, 90, 15,
                42, 8, 73, 29, 61, 5, 38, 82, 50, 19
        )));
    }

    @Test
    void shouldCreateAnalyzerWithValidNumbers() {
        // Arrange & Act
        NumberAnalyzer newAnalyzer = new NumberAnalyzer(Arrays.asList(1, 2, 3));

        // Assert
        assertEquals(3, newAnalyzer.size());
    }

    @Test
    void shouldThrowExceptionWhenNumbersListIsNull() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new NumberAnalyzer(null));
    }

    @Test
    void shouldFindMinimumNumber() {
        // Act
        int min = analyzer.findMinimum();

        // Assert
        assertEquals(5, min);
    }

    @Test
    void shouldFindMaximumNumber() {
        // Act
        int max = analyzer.findMaximum();

        // Assert
        assertEquals(90, max);
    }

    @Test
    void shouldCalculateAverageValue() {
        // Act
        double average = analyzer.calculateAverage();

        // Assert
        assertEquals(45.8, average, 0.001);
    }

    @Test
    void shouldReturnTrueWhenNumberExists() {
        // Act & Assert
        assertTrue(analyzer.contains(50));
    }

    @Test
    void shouldReturnFalseWhenNumberDoesNotExist() {
        // Act & Assert
        assertFalse(analyzer.contains(100));
    }

    @Test
    void shouldSortNumbersInAscendingOrder() {
        // Arrange
        List<Integer> expected = Arrays.asList(5, 8, 12, 15, 19, 23, 29, 34, 38, 42, 45, 50, 56, 61, 67, 73, 78, 82, 89, 90);

        // Act
        analyzer.sortAscending();

        // Assert
        assertEquals(expected, analyzer.getNumbers());
    }

    @Test
    void shouldReturnCorrectSize() {
        // Act
        int size = analyzer.size();

        // Assert
        assertEquals(20, size);
    }
}
