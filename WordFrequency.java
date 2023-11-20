package wordfrequency.java;
import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        System.out.println("Choose an option:");
        System.out.println("1. Enter text manually");
        System.out.println("2. Import text from a file");

        int option = 0;
        boolean validOption = false;

        while (!validOption) {
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option == 1 || option == 2) {
                    validOption = true;
                } else {
                    System.out.println("Invalid option. Please choose 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Please enter a number.");
            }
        }

        if (option == 1) {
            System.out.println("Enter the text:");
            text = scanner.nextLine();
        } else if (option == 2) {
            System.out.println("Enter the file path of the text (.txt) file:");
            String filePath = scanner.nextLine();
            try {
                File file = new File(filePath);
                Scanner fileScanner = new Scanner(file);
                StringBuilder textBuilder = new StringBuilder();
                while (fileScanner.hasNextLine()) {
                    textBuilder.append(fileScanner.nextLine()).append("\n");
                }
                text = textBuilder.toString();
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please enter a valid file path.");
                scanner.close();
                return;
            }
        }

        scanner.close();

        // Remove punctuation and convert text to lowercase
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        // Split the text into words
        String[] words = text.split("\\s+");

        // Count word frequencies
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        // Display word frequencies
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("-------------------------");
        System.out.println("Go Hatters!!");
        System.out.println("Program by: Theo Oliver");
    }
}
