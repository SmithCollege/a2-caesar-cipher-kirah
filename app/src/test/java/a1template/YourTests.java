// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import org.junit.Test;
import static org.junit.Assert.*;

public class YourTests {
    Integer[] count;

    public void createCount(){
        this.count = new Integer[10];
        for (int i = 0; i < 10; i++) {
            count[i] = Integer.valueOf(i);
        }
    }
    
    @Test
    public void negativeOffsetAlphaTest() {
        CaesarCipher classUnderTest = new CaesarCipher(-3);
        assertEquals("this is a secret message", classUnderTest.encode("qefp fp x pbzobq jbppxdb"));
        assertEquals("qefp fp x pbzobq jbppxdb", classUnderTest.decode("this is a secret message"));
    }
    @Test
    public void negativeOffsetCountTest(){
        createCount();
        DynamicArray<Integer> numberTest = new DynamicArray<Integer>(-3, this.count);
        assertEquals("Is 0 returned by the 0 index (offset -3)?", numberTest.get(0, -3).intValue(), 3);
        assertEquals("Is 9 returned by the 9th index (offset -3)?", numberTest.get(9, -3).intValue(), 6);
    }



}