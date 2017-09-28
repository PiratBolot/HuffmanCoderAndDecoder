import java.util.*;

public class HuffmanDecoder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int symbolCount = input.nextInt();
        int stringLength = input.nextInt();
        input.nextLine();
        Alphabet[] alphabets = new Alphabet[symbolCount];
        String str;

        for (int i = 0; i < symbolCount; i++) {
            str = input.nextLine();
            alphabets[i] = new Alphabet(str.charAt(0), str.substring(3));
        }
        Arrays.sort(alphabets);

        String letter = input.nextLine();
        StringBuilder builderLetter = new StringBuilder(letter);
        StringBuilder result = new StringBuilder();
        while (builderLetter.length() > 0) {
            for (int i = 0; i < symbolCount; i++) {
               if (builderLetter.toString().startsWith(alphabets[i].code)) {
                   result.append(alphabets[i].symbol);
                   builderLetter.delete(0, alphabets[i].code.length());
               }
            }
        }
        System.out.println(result.toString());
    }

    static class Alphabet implements Comparable<Alphabet> {
        char symbol;
        String code;

        public Alphabet(char symbol, String code) {
            this.symbol = symbol;
            this.code = code;
        }

        @Override
        public int compareTo(Alphabet o) {
            if (this.code.length() < o.code.length()) {
                return -1;
            } else if (this.code.length() > o.code.length()){
                return 1;
            } else {
                return this.code.compareTo(o.code);
            }
        }
    }

}
