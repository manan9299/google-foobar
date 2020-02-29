import java.util.HashMap;

public class BrailleTranslation {

    public static void main(String[] args) {

        String result = solution("code");
        System.out.println(result.equals("100100101010100110100010"));

        result = solution("Braille");
        System.out.println(result.equals("000001110000111010100000010100111000111000100010"));

        result = solution("The quick brown fox jumps over the lazy dog");
        System.out.println(result.equals("000001011110110010100010000000111110101001010100100100101000000000110000111010101010010111101110000000110100101010101101000000010110101001101100111100011100000000101010111001100010111010000000011110110010100010000000111000100000101011101111000000100110101010110110"));

    }

    /**
     * Converts a given sentence into a braille string consisting of 0's and 1's
     * @param   s   String for which we need the braille string
     * @return  Returns the braille string
     */
    public static String solution(String s) {

        StringBuilder brailleSentence = new StringBuilder();
        String capitalizationMark = "000001";

        for(int i = 0; i < s.length(); i++){
            Character letter = s.charAt(i);

            // If Character is Capital, append capitalization mark before character
            // and convert it to lowercase
            if(Character.isUpperCase(letter)){
                brailleSentence.append(capitalizationMark);
                letter = Character.toLowerCase(letter);
            }
            String brailleString = getBrailleStringFromLetter(letter);
            brailleSentence.append(brailleString);
        }

        return brailleSentence.toString();
    }

    /**
     * Gets the encoded braille string for a given letter.
     * @param   letter  character for which we need encoded braille string.
     * @return  corresponding encoded braille string for this Character
     */
    private static String getBrailleStringFromLetter(char letter) {

        // HashMap with Character to corresponding Braille String Mapping
        HashMap<Character, String> charToBrailleStr = new HashMap<>();

        charToBrailleStr.put(' ', "000000");
        charToBrailleStr.put('a', "100000");
        charToBrailleStr.put('b', "110000");
        charToBrailleStr.put('c', "100100");
        charToBrailleStr.put('d', "100110");
        charToBrailleStr.put('e', "100010");
        charToBrailleStr.put('f', "110100");
        charToBrailleStr.put('g', "110110");
        charToBrailleStr.put('h', "110010");
        charToBrailleStr.put('i', "010100");
        charToBrailleStr.put('j', "010110");
        charToBrailleStr.put('k', "101000");
        charToBrailleStr.put('l', "111000");
        charToBrailleStr.put('m', "101100");
        charToBrailleStr.put('n', "101110");
        charToBrailleStr.put('o', "101010");
        charToBrailleStr.put('p', "111100");
        charToBrailleStr.put('q', "111110");
        charToBrailleStr.put('r', "111010");
        charToBrailleStr.put('s', "011100");
        charToBrailleStr.put('t', "011110");
        charToBrailleStr.put('u', "101001");
        charToBrailleStr.put('v', "111001");
        charToBrailleStr.put('w', "010111");
        charToBrailleStr.put('x', "101101");
        charToBrailleStr.put('y', "101111");
        charToBrailleStr.put('z', "101011");

        return charToBrailleStr.get(letter);
    }
}
