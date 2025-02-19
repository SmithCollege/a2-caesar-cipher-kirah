// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A collection of JUnit tests for the CaesarCipher and DynamicArray
 * implementations.
 * 
 * This class tests the encoding and decoding functionality of the CaesarCipher
 * using both negative
 * and large offsets. It also verifies the element retrieval from a DynamicArray
 * with specified offsets.
 * 
 */
public class YourTests {
    Integer[] count;

    /**
     * Initializes the {@code count} array with Integer values from 0 to 9.
     */
    public void createCount() {
        this.count = new Integer[10];
        for (int i = 0; i < 10; i++) {
            count[i] = Integer.valueOf(i);
        }
    }

    /**
     * Tests the encoding functionality of {@code CaesarCipher} with a negative
     * offset (-3).
     * 
     * The test asserts that the encoded output of the provided cipher texts match
     * the expected plain texts.
     * 
     */
    @Test
    public void negativeOffsetCipherEncodingTest() {
        CaesarCipher classUnderTest = new CaesarCipher(-3);
        // Encoding "qufp fp x pbzobq jbppxdb" should produce "this is a secret message"
        assertEquals("this is a secret message", classUnderTest.encode("qefp fp x pbzobq jbppxdb"));
        // Encoding "rkfq qbpqfkd" should produce "unit testing"
        assertEquals("unit testing", classUnderTest.encode("rkfq qbpqfkd"));
        // Encoding "ebiil tloia" should produce "hello world"
        assertEquals("hello world", classUnderTest.encode("ebiil tloia"));
        // Encoding "gxsx moldoxjjfkd" should produce "java programming"
        assertEquals("java programming", classUnderTest.encode("gxsx moldoxjjfkd"));

    }

    /**
     * Tests the decoding functionality of {@code CaesarCipher} with a negative
     * offset (-3).
     * 
     * The test asserts that decoding the provided plain texts returns the expected
     * cipher texts.
     * 
     */
    @Test
    public void negativeOffsetCipherDecodingTest() {
        CaesarCipher classUnderTest = new CaesarCipher(-3);
        // Decoding "this is a secret message" with a negative offset should produce "qefp fp x pbzobq jbppxdb"
        assertEquals("qefp fp x pbzobq jbppxdb", classUnderTest.decode("this is a secret message"));
        // Decoding "java programming" with a negative offset should produce "gxsx moldoxjjfkd"
        assertEquals("gxsx moldoxjjfkd", classUnderTest.decode("java programming"));
        // Decoding "hello world" with a negative offset should produce "ebiil tloia"
        assertEquals("ebiil tloia", classUnderTest.decode("hello world"));
        // Decoding "unit testing" with a negative offset should produce "rkfq qbpqfkd"
        assertEquals("rkfq qbpqfkd", classUnderTest.decode("unit testing"));

    }

    /**
     * Tests the encoding functionality of {@code CaesarCipher} with a large offset.
     * 
     * The test prints the encoded output for the given input string using both a
     * positive and negative offset,
     * allowing visual verification of the results.
     * 
     */
    @Test
    public void largeOffsetCipherEncodingTest() {
        CaesarCipher classUnderTest = new CaesarCipher(29);
        System.out.println(classUnderTest.encode("this isn't very secret."));
        CaesarCipher D = new CaesarCipher(-29);
        System.out.println(D.encode("this isn't very secret."));

    }

    /**
     * Tests the decoding functionality of {@code CaesarCipher} with a large
     * positive offset (29) and large negative offset (-29).
     * 
     * The test prints the decoded output for the given cipher text using both a
     * positive and negative offset,
     * allowing visual verification of the results.
     * 
     */
    @Test
    public void largeOffsetCipherDecodingTest() {
        CaesarCipher classUnderTest = new CaesarCipher(29);
        System.out.println(classUnderTest.decode("qefp fpk'q sbov pbzobq."));
        CaesarCipher D = new CaesarCipher(-29);
        System.out.println(D.decode("qefp fpk'q sbov pbzobq."));
    }

    /**
     * Tests the retrieval of elements from a {@code DynamicArray} using a negative
     * offset (-5).
     * 
     * The test asserts that the element returned at various indices with the given
     * offset is as expected.
     * 
     */
    @Test
    public void negativeOffsetCountTest() {
        createCount();
        DynamicArray<Integer> numberTest = new DynamicArray<Integer>(-5, this.count);
        assertEquals("Is 0 returned by the 0 index (offset -5)?", numberTest.get(0, -5).intValue(), 5);
        assertEquals("Is 9 returned by the 9th index (offset -5)?", numberTest.get(9, -5).intValue(), 4);
        assertEquals("Is -1 returned by the 9th index(offset -5)?", numberTest.get(-1, -5).intValue(), 4);
    }

    /**
     * Tests the retrieval of elements from a {@code DynamicArray} using both large
     * negative (-15) and large positive (15) offsets.
     * 
     * The test asserts that the elements returned at specified indices with the
     * given offsets are as expected.
     * 
     */
    @Test
    public void largeOffsetCountTest() {
        createCount();
        DynamicArray<Integer> numberTest = new DynamicArray<Integer>(-15, this.count);
        assertEquals("Is 0 returned by the 0 index (offset -15)?", numberTest.get(0, -15).intValue(), 5);
        assertEquals("Is 9 returned by the 9th index (offset -15)?", numberTest.get(9, -15).intValue(), 4);
        assertEquals("Is 0 returned by the 0 index (offset -15)?", numberTest.get(-1, -15).intValue(), 4);
        DynamicArray<Integer> numberTest2 = new DynamicArray<Integer>(15, this.count);
        assertEquals("Is 0 returned by the 0 index (offset 15)?", numberTest2.get(0, 15).intValue(), 5);
        assertEquals("Is 9 returned by the 9th index (offset 15)?", numberTest2.get(9, 15).intValue(), 4);
    }

}