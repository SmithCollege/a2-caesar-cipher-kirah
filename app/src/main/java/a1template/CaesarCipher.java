// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;
import a1template.DynamicArray;

public class CaesarCipher {

    /** Character array to store the letters in the alphabet in order */
    Character[] alphabet;

    /** DynamicArray object providing ArrayList-like operations for Characters */
    DynamicArray<Character> cipher;

    /**
     * Private offset that tracks how many positions to shift the index for
     * This cipher
     */
    private int offset;

    /**
     * Constructor that should define the instance variables, including
     * populating the alphabet
     * 
     * @param offset Offset to use when creating `cipher` of DynamicArray type
     */
    CaesarCipher(int offset) {
        // Fill in here
        this.offset = offset;
        this.alphabet = new Character[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
        }
        this.cipher = new DynamicArray<>(offset, alphabet);
    }

    // public String toString() {
    //     for (int i = 0; i < 26; i++) {
    //         System.out.print(alphabet[i]);
    //     }
    //     return alphabet.toString();
    // }

    public char get(int index) {
        return cipher.get(index, -offset);
       
    }

    /**
     * Implementation of linear search that looks through the alphabet
     * array to identify the position of the passed value
     * 
     * @param val character to search for
     * @return int indicating position of val in the alphabet array
     */
    public int findIndex(char val) {
        // This is a stub -- fill in the code and return the
        // value you calculate
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == val) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Encode a message using the cipher
     * 
     * @param T message to encode
     * @return encoded message
     */
    public String encode(String message) {
        char[] charArray = message.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int alphabetIndex = findIndex(charArray[i]);
            if (alphabetIndex == -1) {
                charArray[i] = charArray[i];
            } else {
                charArray[i] = cipher.get(alphabetIndex, -offset);
            }

        }
        // Fill in here and update return statement based on your code
        return new String(charArray);
    }

    /**
     * Decode a message using the cipher
     * 
     * @param String message to decode
     * @param int    key to use in decoding
     * @return decoded message
     */
    public String decode(String message) {
        char[] charArray = message.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int alphabetIndex = findIndex(charArray[i]);
            if (alphabetIndex == -1) {
                charArray[i] = charArray[i];
            } else {
                charArray[i] = cipher.get(alphabetIndex, offset);
            }
        }
        // Fill in here and update return statement based on your code
        return new String(charArray);
    }

    public static void main(String[] args) {
        CaesarCipher A = new CaesarCipher(3);
        System.out.println(A.encode("this isn't very secret."));
        System.out.println(A.decode("qefp fpk'q sbov pbzobq."));
        CaesarCipher B = new CaesarCipher(29);
        System.out.println(B.encode("this isn't very secret."));
        System.out.println(B.decode("qefp fpk'q sbov pbzobq."));
        CaesarCipher C = new CaesarCipher(-3);
        System.out.println(C.encode("this isn't very secret."));
        System.out.println(C.decode("qefp fpk'q sbov pbzobq."));
        CaesarCipher D = new CaesarCipher(-29);
        System.out.println(D.encode("this isn't very secret."));
        System.out.println(D.decode("qefp fpk'q sbov pbzobq."));


        // System.out.println(A.get(0));
    }

}
