// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import org.junit.Test;
import static org.junit.Assert.*;

public class YourTests {
    Integer[] count;

    public void createCount() {
        this.count = new Integer[10];
        for (int i = 0; i < 10; i++) {
            count[i] = Integer.valueOf(i);
        }
    }

    @Test
    public void negativeOffsetCipherEncodingTest() {
        CaesarCipher classUnderTest = new CaesarCipher(-3);
        assertEquals("this is a secret message", classUnderTest.encode("qefp fp x pbzobq jbppxdb"));
        // Decoding "rkfq qbpqfkd" should produce "unit testing"
        assertEquals("unit testing", classUnderTest.encode("rkfq qbpqfkd"));
        // Decoding "ebiil tloia" should produce "hello world"
        assertEquals("hello world", classUnderTest.encode("ebiil tloia"));
        // Decoding "gxsx moldoxjjfkd" should produce "java programming"
        assertEquals("java programming", classUnderTest.encode("gxsx moldoxjjfkd"));

    }

    @Test
    public void negativeOffsetCipherDecodingTest() {
        CaesarCipher classUnderTest = new CaesarCipher(-3);
        assertEquals("qefp fp x pbzobq jbppxdb", classUnderTest.decode("this is a secret message"));
        // Decoding "java programming" with a negative offset should produce "gxsx
        // moldoxjjfkd"
        assertEquals("gxsx moldoxjjfkd", classUnderTest.decode("java programming"));
        // Decoding "hello world" with a negative offset should produce "ebiil tloia"
        assertEquals("ebiil tloia", classUnderTest.decode("hello world"));
        // Decoding "unit testing" with a negative offset should produce "rkfq qbpqfkd"
        assertEquals("rkfq qbpqfkd", classUnderTest.decode("unit testing"));

    }

    @Test
    public void largeOffsetCipherEncodingTest() {
        CaesarCipher classUnderTest = new CaesarCipher(29);
        System.out.println(classUnderTest.encode("this isn't very secret."));
        CaesarCipher D = new CaesarCipher(-29);
        System.out.println(D.encode("this isn't very secret."));

    }

    @Test
    public void largeOffsetCipherDecodingTest() {
        CaesarCipher classUnderTest = new CaesarCipher(29);
        System.out.println(classUnderTest.decode("qefp fpk'q sbov pbzobq."));
        CaesarCipher D = new CaesarCipher(-29);
        System.out.println(D.decode("qefp fpk'q sbov pbzobq."));
    }

    @Test
    public void negativeOffsetCountTest() {
        createCount();
        DynamicArray<Integer> numberTest = new DynamicArray<Integer>(-5, this.count);
        assertEquals("Is 0 returned by the 0 index (offset -5)?", numberTest.get(0, -5).intValue(), 5);
        assertEquals("Is 9 returned by the 9th index (offset -5)?", numberTest.get(9, -5).intValue(), 4);
        assertEquals("Is -1 returned by the 9th index(offset -5)?", numberTest.get(-1, -5).intValue(), 4);
    }

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