package challenge;

import java.util.Arrays;
import java.util.List;

public class CriptografiaCesariana implements Criptografia {
    private final List<String> ALPHABET = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
    private final int KEY = 3;

    @Override
    public String criptografar(String texto) {
        if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < texto.length(); i++) {
            String letter = String.valueOf(texto.charAt(i));
            int letter_position = ALPHABET.indexOf(letter.toLowerCase());
            if (letter_position != -1) {
                String letter_encrypted = ALPHABET.get((letter_position + this.KEY) % 26);
                result.append(letter_encrypted);
            } else {
                result.append(letter);
            }
        }
        return String.valueOf(result);
    }

    @Override
    public String descriptografar(String texto) {
        if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }
        StringBuilder result = new StringBuilder("");
        for(int i = 0 ; i < texto.length() ; i++) {
            String letter = String.valueOf(texto.charAt(i));
            int letter_position = ALPHABET.indexOf(letter.toLowerCase());
            if(letter_position != -1){
                String letter_encrypted = ALPHABET.get((letter_position - this.KEY) % 26);
                result.append(letter_encrypted);
            } else {
                result.append(letter);
            }
        }
        return String.valueOf(result);
    }
}
