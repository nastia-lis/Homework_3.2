package geekbrains.homework;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int numbWord = random.nextInt(words.length);
        String hiddenWord = words[numbWord];
        System.out.println("Давайте сыграем!\nВаша задача угать слово из предложенных:");
        System.out.printf("   %3s, %3s, %3s, %3s, %3s,\n   %3s, %3s, %3s, %3s, %3s,\n   %3s, %3s, %3s, %3s, %3s,\n   %3s, %3s, %3s, %3s, %3s,\n   %3s, %3s, %3s, %3s, %3s,\n", words);
        while (true) {
            System.out.println("\nВведите ваш ответ: ");
            String userAnswer = scanner.nextLine();
            compareWord(hiddenWord, userAnswer);
            if (userAnswer.matches(hiddenWord)) {
                System.out.println("\nПоздравляем! Вы угадали!");
                break;
            }
        }
        System.out.println("Игра окончена!");
    }
    public static void compareWord(String hiddenWord, String userAnswer) {
        System.out.println("Вы угадали слелующие буквы (# - неугаданные буквы): ");
        char guessSym = '#';
        int guessSymNumb = 15;
        int symHidden = guessSymNumb - hiddenWord.length();
        int symUser = guessSymNumb - userAnswer.length();
        if (hiddenWord.length() >= userAnswer.length()) {
            for (int i = 0; i < userAnswer.length(); i++) {
                userAnswer.charAt(i);
                hiddenWord.charAt(i);
                if (userAnswer.charAt(i) == hiddenWord.charAt(i)) {
                    System.out.print(userAnswer.charAt(i));
                } else {
                    System.out.print(guessSym);
                }
            }
            for (int i = 0; i < symUser; i++) {
                System.out.print(guessSym);
            }
        } else if (hiddenWord.length() <= userAnswer.length()) {
            for (int i = 0; i < hiddenWord.length(); i++) {
                userAnswer.charAt(i);
                hiddenWord.charAt(i);
                if (userAnswer.charAt(i) == hiddenWord.charAt(i)) {
                    System.out.print(userAnswer.charAt(i));
                } else {
                    System.out.print(guessSym);
                }
            }
            for (int i = 0; i < symHidden; i++) {
                System.out.print(guessSym);
            }
        }
    }
}
