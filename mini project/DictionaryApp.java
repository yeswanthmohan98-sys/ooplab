import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/** Thrown when a searched/updated word is not in the dictionary. */
class WordNotFoundException extends Exception {
    public WordNotFoundException(String word) {
        super("Word not found: \"" + word + "\"");
    }
}

/** Thrown when adding a word that already exists. */
class DuplicateWordException extends Exception {
    public DuplicateWordException(String word) {
        super("Word already exists: \"" + word + "\". Use update instead.");
    }
}

/** Thrown for blank word or meaning input. */
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

/**
 * Dictionary stores word -> meaning pairs in a Map.
 * The map is private (encapsulation); access only through methods.
 */
class Dictionary {
    // TreeMap keeps words sorted alphabetically when displayed
    private final Map<String, String> entries = new TreeMap<>();

    private String normalize(String word) throws InvalidInputException {
        if (word == null || word.trim().isEmpty()) {
            throw new InvalidInputException("Word cannot be empty.");
        }
        return word.trim().toLowerCase();
    }

    private String checkMeaning(String meaning) throws InvalidInputException {
        if (meaning == null || meaning.trim().isEmpty()) {
            throw new InvalidInputException("Meaning cannot be empty.");
        }
        return meaning.trim();
    }

    public void addWord(String word, String meaning)
            throws DuplicateWordException, InvalidInputException {
        String key = normalize(word);
        String value = checkMeaning(meaning);
        if (entries.containsKey(key)) {
            throw new DuplicateWordException(key);
        }
        entries.put(key, value);
    }

    public String searchWord(String word)
            throws WordNotFoundException, InvalidInputException {
        String key = normalize(word);
        String meaning = entries.get(key);
        if (meaning == null) {
            throw new WordNotFoundException(key);
        }
        return meaning;
    }

    public void updateWord(String word, String newMeaning)
            throws WordNotFoundException, InvalidInputException {
        String key = normalize(word);
        String value = checkMeaning(newMeaning);
        if (!entries.containsKey(key)) {
            throw new WordNotFoundException(key);
        }
        entries.put(key, value);
    }

    public void displayAll() {
        if (entries.isEmpty()) {
            System.out.println("Dictionary is empty.");
            return;
        }
        System.out.println("\n---------- Dictionary Entries (" + entries.size() + ") ----------");
        int i = 1;
        for (Map.Entry<String, String> e : entries.entrySet()) {
            System.out.printf("%2d. %-15s : %s%n", i++, e.getKey(), e.getValue());
        }
        System.out.println("----------------------------------------------");
    }

    public int size() {
        return entries.size();
    }
}

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner sc = new Scanner(System.in);

        // Sample data
        try {
            dictionary.addWord("java", "A high-level, object-oriented programming language.");
            dictionary.addWord("map", "A collection that stores key-value pairs.");
        } catch (Exception ignored) { }

        int choice = 0;
        do {
            System.out.println("\n===== Dictionary Management System =====");
            System.out.println("1. Add word");
            System.out.println("2. Search word");
            System.out.println("3. Update word");
            System.out.println("4. Display all entries");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter word: ");
                        String w = sc.nextLine();
                        System.out.print("Enter meaning: ");
                        String m = sc.nextLine();
                        dictionary.addWord(w, m);
                        System.out.println("Word added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter word to search: ");
                        String sw = sc.nextLine();
                        String meaning = dictionary.searchWord(sw);
                        System.out.println("Word    : " + sw.trim().toLowerCase());
                        System.out.println("Meaning : " + meaning);
                        break;
                    case 3:
                        System.out.print("Enter word to update: ");
                        String uw = sc.nextLine();
                        System.out.print("Enter new meaning: ");
                        String um = sc.nextLine();
                        dictionary.updateWord(uw, um);
                        System.out.println("Word updated successfully.");
                        break;
                    case 4:
                        dictionary.displayAll();
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Enter 1-5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: please enter a number.");
                sc.nextLine(); // clear bad input
                choice = 0;
            } catch (WordNotFoundException | DuplicateWordException | InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 5);

        sc.close();
    }
}
