package com.codecool.shop.tests;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestProductDao {
    private ProductDao productDao;
//
//    /**
//     * Make a new instance every time before running a test
//     */
//    @BeforeEach
//    void setup() {
//        ProductDao productDao = new ProductDaoMem.getInstance();
//    }

//    /**
//     * Start with the most trivial tests like checking what happens if
//     * the FilePartReader parameter is null
//     */
//    @Test
//    void testWordsArePalindromeWhenFilePartReaderNullShouldThrowNullPointerException() {
//        fileWordAnalyzer = new FileWordAnalyzer(null);
//        assertThrows(NullPointerException.class, () -> fileWordAnalyzer.getStringsWhichPalindromes());
//    }
//
//    /**
//     * Normal working of alphabetical ordering
//     * @throws IOException
//     */
//    @Test
//    void testGetWordsOrderedAlphabeticallyWhenProperSetupThenWorkingProperly() throws IOException {
//        ArrayList<String> expected = new ArrayList<>(Arrays.asList(
//                "All gathering days creeping.",
//                "Cattle second under creeping god, whose firmament.",
//                "Creature greater great Fly moving. Bring.",
//                "Creeping. Whales brought you're.",
//                "Day After saw one To rule.",
//                "Divided. Face greater good subdue isn't land.",
//                "Every lesser don't land.",
//                "Fly itself divide forth she'd to. The.",
//                "Fruit Shall earth have.",
//                "In spirit Whales to unto from. There.",
//                "Moved forth, she'd yielding together.",
//                "Moved rule isn't moveth grass a meat third.",
//                "Moveth days.",
//                "Said fowl female together spirit.",
//                "Saying night heaven divided Seas darkness yielding divide.",
//                "Sore was I ere I saw Eros",
//                "There creature second whose light all gathering.",
//                "To shall forth in two.",
//                "Upon there fowl male.",
//                "Warsaw was raw",
//                "Xanax"
//        ));
//        assertEquals(expected, fileWordAnalyzer.getWordsOrderedAlphabetically());
//    }
//
//    /**
//     * Test the normal working of the substring finder
//     * @throws IOException
//     */
//    @Test
//    void testGetWordsContainingSubstringWhenThereIsMatchThenGivesThemBack() throws IOException {
//        ArrayList<String> expected = new ArrayList<>(Arrays.asList(
//                "Moved rule isn't moveth grass a meat third.",
//                "Moved forth, she'd yielding together.",
//                "Moveth days."
//        ));
//        assertEquals(expected, fileWordAnalyzer.getWordsContainingSubstring("Move"));
//    }
//
//    /**
//     * And don't forget to test when there are no matches for the substring
//     * we are searching for
//     * @throws IOException
//     */
//    @Test
//    void testGetWordsContainingSubstringWhenNoMatchThenReturnEmptyList() throws IOException {
//        List<String> expected = new ArrayList<>();
//        assertEquals(expected, fileWordAnalyzer.getWordsContainingSubstring("Kamehameha"));
//    }
//
//    /**
//     * The same for the palindromes. This one is the normal way of working
//     * @throws IOException
//     */
//    @Test
//    void testGetStringsWhichPalindromesWhenThereIsMatchThenGivesThemBack() throws IOException {
//        ArrayList<String> expected = new ArrayList<>(Arrays.asList(
//                "Sore was I ere I saw Eros",
//                "Xanax"
//        ));
//        assertEquals(expected, fileWordAnalyzer.getStringsWhichPalindromes());
//    }
//
//    /**
//     * There are times when you would need another setup to run before each test
//     * but it should test the same class. What to do?
//     * Nested test class can be an answer to this. Read about it here:
//     *
//     * https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested
//     * https://howtoprogram.xyz/2016/08/19/junit-5-nested-tests-examples/
//     *
//     */
//    @Nested
//    class EmptyResultTests {
//        @BeforeEach
//        void setup() {
//            FilePartReader filePartReader = new FilePartReader();
//            filePartReader.setup(TestUtils.TEST_FILE_PATH, 1, 1);
//
//            fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
//        }
//
//        /**
//         * It's also a good idea to check what happens if there is only one
//         * entry in the FilePartReader.
//         * @throws IOException
//         */
//        @Test
//        void testGetWordsOrderedAlphabeticallyWhenOneLineThenWorksProperly() throws IOException {
//            ArrayList<String> expected = new ArrayList<>(Arrays.asList(
//                    "All gathering days creeping."));
//            assertEquals(expected, fileWordAnalyzer.getWordsOrderedAlphabetically());
//        }
//
//        /**
//         * The same with palindromes: what happens when no palindromes found?
//         * @throws IOException
//         */
//        @Test
//        void testGetStringsWhichPalindromesWhenNoPalindromeThenGivesEmptyList() throws IOException {
//            List<String> expected = new ArrayList<>();
//            assertEquals(expected, fileWordAnalyzer.getStringsWhichPalindromes());
//        }
//    }

    /* We could test several more cases:
        - the result is only one palindrome/substring
        - all of the lines containing palindromes/substrings
        - make sure to have words which are almost palindromes.
          The one character should be around the center like: "abcdefdcba" or "abcdfedcba"
    */
}
