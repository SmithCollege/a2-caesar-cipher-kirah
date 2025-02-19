// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

/**
 * A generic dynamic array that implements the {@code IndexAccess} interface.
 * 
 * This class supports retrieving and setting elements from an array, including
 * retrieval with an applied
 * offset. The offset allows cyclic access to the array elements.
 *
 * @param <T> the type of elements in this dynamic array
 */
public class DynamicArray<T> implements IndexAccess<T> {

    // What instance variables do you need?

    private T[] array;
    private int offset;

    // Write a constructor to make a new DynamicArray Object from an array

    /**
     * Constructs a new {@code DynamicArray} using the provided offset and array.
     *
     * @param offset the default offset for cyclic access
     * @param array  the array of elements to be managed
     */
    public DynamicArray(int offset, T[] array) {
        this.offset = offset;
        this.array = array;
    }

    // Now implement the methods from IndexAccess?

    /**
     * Retrieves the element at the specified index from the underlying array.
     *
     * @param i the index of the element to retrieve
     * @return the element at index {@code i}
     */
    @Override
    public T get(int i) {
        return (T) array[i];
    }

    /**
     * Retrieves the element at the specified index after applying a cyclic offset.
     * 
     * The method rotates the array by the given offset and then retrieves the
     * element at index {@code i}.
     * If the offset is positive, the array is rotate to the right by the offset.
     * If the offset is negative, the array is rotated to the left by the offset.
     * If the index is negative, it is starting from the end of the array.
     * and if index/offset exceeds the array bounds, it is reduced modulo the array length.
     * 
     *
     * @param i      the index of the element to retrieve after applying the offset
     * @param offset the offset to apply for cyclic access
     * @return the value at the adjusted index after applying the offset
     */
    @Override
    public T get(int i, int offset) {
        if (i < 0) {
            i = i + array.length;
        } else if (i > array.length || i < -array.length) {
            i = i % array.length;
        }
        T[] newArray = (T[]) new Object[array.length];
        if (offset < 0 && offset > (-array.length)) {
            System.arraycopy(array, 0, newArray, -offset, array.length + offset);
            System.arraycopy(array, array.length + offset, newArray, 0, -offset);
            return (T) newArray[i];
        } else if (0 <= offset && offset < array.length) {
            System.arraycopy(array, offset, newArray, 0, array.length - offset);
            System.arraycopy(array, 0, newArray, array.length - offset, offset);
            return (T) newArray[i];
        } else {
            if (offset >= array.length) {
                offset = offset % array.length;
                return get(i, offset);
            } else {
                offset = (-offset) % array.length;
                return get(i, -offset);
            }

        }

    }

    /**
     * Sets the element at the specified index in the underlying array to the given
     * value.
     *
     * @param i   the index where the value should be set
     * @param val the new value to set at the specified index
     */
    @Override
    public void set(int i, T val) {
        array[i] = val;
    }

    // public static void main(String[] args) {
    // // Integer[] count = new Integer[10];
    // // for (int i = 0; i < 10; i++) {
    // // count[i] = Integer.valueOf(i);
    // // }
    // // DynamicArray<Integer> numberTest = new DynamicArray<Integer>(0, count);
    // // System.out.println(numberTest.get(9));
    // Character[] alphabet = new Character[26];
    // for (int i = 0; i < 26; i++) {
    // alphabet[i] = Character.valueOf((char) ('a' + i));
    // }
    // DynamicArray<Character> alphaTest = new DynamicArray<Character>(0, alphabet);
    // System.out.println(alphaTest.get(0, -3));
    // System.out.println(alphaTest.get(-1, -3));
    // System.out.println(alphaTest.get(0, 3));
    // System.out.println(alphaTest.get(0, -29));
    // System.out.println(alphaTest.get(-1, -29));
    // System.out.println(alphaTest.get(0, 29));
    // }

}
