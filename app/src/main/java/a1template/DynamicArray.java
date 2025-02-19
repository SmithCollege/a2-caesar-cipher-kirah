// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

public class DynamicArray<T> implements IndexAccess<T> {

    // What instance variables do you need?

    // Write a constructor to make a new DynamicArray Object from an array

    // Now implement the methods from IndexAccess?

    private T[] array;
    private int offset;

    public DynamicArray(int offset, T[] array) {
        this.offset = offset;
        this.array = array;
    }

    @Override
    public T get(int i) {
        return (T) array[i];
    }

    @Override
    public T get(int i, int offset) {
        if(i<0){
            i=i+array.length;
        }else if(i>array.length){
            i=i-array.length;
        }
        T[] newArray = (T[]) new Object[array.length];
        if(offset<0 && offset>(-array.length)){
            System.arraycopy(array,0,newArray,-offset,array.length+offset);
            System.arraycopy(array,array.length+offset,newArray,0,-offset);
            return (T) newArray[i];
        }
        else if(0<=offset&&offset<array.length){
            System.arraycopy(array,offset,newArray,0,array.length-offset);
            System.arraycopy(array,0,newArray,array.length-offset,offset);
            return (T) newArray[i];
        }else{
            if(offset>=array.length){
                offset=offset%array.length;
                return get(i,offset);
            }
            else{
                offset=(-offset)%array.length;
                return get(i,-offset);
            }

        }
       
        

    }

    @Override
    public void set(int i, T val) {
        array[i] = val;
    }

    public static void main(String[] args) {
        // Integer[] count = new Integer[10];
        // for (int i = 0; i < 10; i++) {
        // count[i] = Integer.valueOf(i);
        // }
        // DynamicArray<Integer> numberTest = new DynamicArray<Integer>(0, count);
        // System.out.println(numberTest.get(9));
        Character[] alphabet = new Character[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = Character.valueOf((char) ('a' + i));
        }
        DynamicArray<Character> alphaTest = new DynamicArray<Character>(0, alphabet);
        System.out.println(alphaTest.get(0, -3));
        System.out.println(alphaTest.get(-1, -3));
        System.out.println(alphaTest.get(0, 3));
        System.out.println(alphaTest.get(0, -29));
        System.out.println(alphaTest.get(-1, -29));
        System.out.println(alphaTest.get(0, 29));
    }

}
