package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class StringFormatterTest {

    @BeforeEach
    void setup() {
        String os = System.getProperty("os.name").toLowerCase();
        assumeTrue(os.contains("win"), "Tests run only on Windows");
    }


    @Test
    void testReverseString() {
        String result = StringFormatter.reverseString("abcd");
        assertEquals("dcba", result);
    }

    @ParameterizedTest
    @CsvSource({
            "test, Test",
            "t, T",
            "123, 123",
            ", ",
            "two words, Two words"
    })
    void testCapitalizeFirstLetter(String input, String expected) {
        assertEquals(expected, StringFormatter.capitalizeFirstLetter(input));
    }


    @Test
    public void testAddExclamation() {
        assertThat(StringFormatter.addExclamation("hello"))
                .isEqualTo("hello!");
    }

}
