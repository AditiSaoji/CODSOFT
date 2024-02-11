import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text or provide a file path: ");
        String userInput = sc.nextLine();
        String text;
        if (isFilePath(userInput)) {
            text = readTextFromFile(userInput);
        } else {
            text = userInput;
        }
        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = 0;

        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
                if (!isStopWord(word.toLowerCase())) {
                    wordFrequencyMap.put(word.toLowerCase(), wordFrequencyMap.getOrDefault(word.toLowerCase(), 0) + 1);
                }
            }
        }
        System.out.println("Total number of words: " + wordCount);
        System.out.println("\nWord Frequency Statistics:");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        sc.close();
    }

    private static boolean isFilePath(String userInput) {
        return new File(userInput).exists();
    }

    private static String readTextFromFile(String filePath) {
        try {
            return new String(Files.readAllBytes(new File(filePath).toPath()));
        } catch (IOException e) {
            System.err.println("Error reading file. Please check the file path and try again.");
            System.exit(1);
            return null;
        }
    }

    private static boolean isStopWord(String word) {
        String[] stopWords = {"the", "and", "is", "in", "it", "to", "of", "for", "with", "on", "this", "that", "at"};
        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }
        return false;
    }
}
