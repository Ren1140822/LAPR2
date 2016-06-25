/**
 * Package location for Pure Fabrication util classes.
 */
package lapr.project.utils;

import java.util.Random;

/**
 * Represents a Encrypter
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class Encrypter {

    public Encrypter() {

    }
    private static final String alphabet = ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,_!?@");

    /**
     * Encrypts a string using ceasers cypher.
     *
     * @param word the word to encrypt
     * @param shift the shift of characters
     * @return the encrypted string
     */
    public static String encryptStringCaesar(String word, int shift) {
        String encryptedWord = "";
        for (char letter : word.toCharArray()) {
            int index = alphabet.indexOf(letter);
            if (index + shift >= alphabet.length()) {
                index = (index + shift) - alphabet.length() - 1;
            }
            encryptedWord += alphabet.charAt(index + shift);
        }
        return encryptedWord;
    }

    /**
     * Decrypts a ceasers cypher.
     *
     * @param word the word to decrypt.
     * @param shift the caesers cypher
     * @return the decrypted string
     */
    public static String decryptStringCaesar(String word, int shift) {
        String decryptedWord = "";
        for (char letter : word.toCharArray()) {
            int index = alphabet.indexOf(letter);
            if (index - shift <= 0) {
                index = (index - shift) + alphabet.length() + 1;
            }
            decryptedWord += alphabet.charAt(index - shift);
        }
        return decryptedWord;
    }

    /**
     * Encrypts a string using a keyword as a cypher.
     *
     * @param word the word to encrypt
     * @param shift the shift of characters
     * @param keyword the keyword
     * @return the encrypted string
     */
    public static String encryptStringKeyword(String word, int shift, String keyword) {
        String encryptedWord = "";
        String keywordAlphabet = keyword;

        for (int i = 0; i < alphabet.length(); i++) {
            keywordAlphabet += alphabet.charAt(i);
            if (keywordAlphabet.length() == alphabet.length()) {
                break;
            }
        }
        for (char letter : word.toCharArray()) {
            int index = keywordAlphabet.indexOf(letter);
            if (index + shift >= keywordAlphabet.length()) {
                index = (index + shift) - keywordAlphabet.length() - 1;
            }
            encryptedWord += keywordAlphabet.charAt(index + shift);
        }
        return encryptedWord;
    }

    /**
     * Decrypts a string using a keyword as a cypher.
     *
     * @param word the word to encrypt
     * @param shift the shift of characters
     * @param keyword the keyword
     * @return the decrypted string
     */
    public static String decryptStringKeyword(String word, int shift, String keyword) {
        String decryptedWord = "";
        String keywordAlphabet = keyword;
        for (int i = 0; i< alphabet.length(); i++) {
            keywordAlphabet += alphabet.charAt(i);
            if (keywordAlphabet.length() == alphabet.length()) {
                break;
            }
        }
        for (char letter : word.toCharArray()) {
            int index = keywordAlphabet.indexOf(letter);
            if (index - shift <= 0) {
                index = (index - shift) + keywordAlphabet.length() + 1;
            }
            decryptedWord += keywordAlphabet.charAt(index - shift);
        }
        return decryptedWord;
    }

    public static void main(String[] args) {
        Encrypter enc = new Encrypter();
        System.out.println(enc.encryptStringKeyword("1140822@isep.ipp.pt", 15, ""));
    }
}
