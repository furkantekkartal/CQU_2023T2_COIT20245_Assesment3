package appphase5;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Represents a log that keeps track of user responses during a quiz session.
 * Provides methods to add entries, calculate statistics, and save logs to a file.
 */
public class Log {

    private ArrayList<Entry> answers;
    
    /**
     * Initializes an empty log.
     */
    public Log() {
        this.answers = new ArrayList<>();
    }

    /**
     * Logs the user's response to a quiz question.
     *
     * @param questionNumber The number of the question.
     * @param correct        Indicates if the response was correct.
     * @param attempts       The number of attempts taken for the question.
     */
    public void add(int questionNumber, boolean correct, int attempts) {
        Entry entry = new Entry(questionNumber, correct, attempts);
        answers.add(entry);
    }

    /**
     * Calculates the total number of attempts across all questions.
     *
     * @return Total attempts.
     */
    public int attempts() {
        int totalAttempts = 0;
        for (Entry entry : answers) {
            totalAttempts += entry.getAttempts();
        }
        return totalAttempts;
    }

    /**
     * Counts the number of questions answered correctly.
     *
     * @return The count of correct answers.
     */
    public int correct() {
        int correctCount = 0;
        for (Entry entry : answers) {
            if (entry.isCorrect()) {
                correctCount++;
            }
        }
        return correctCount;
    }

    /**
     * Gets the total number of questions logged.
     *
     * @return Total questions logged.
     */
    public int numberOfQuestions() {
        return answers.size();
    }

    /**
     * Writes the log data to a file specified by the path.
     * If an error occurs, a message is printed to the error stream.
     *
     * @param pathName The path of the file to write the log data.
     */
    public void save(String pathName) {
        try (PrintWriter writer = new PrintWriter(pathName)) {
            writer.println("    Question     Correct    Attempts");
            for (Entry entry : answers) {
                writer.printf("%12d %11s %11d%n", entry.getQuestionNumber(), entry.isCorrect(), entry.getAttempts());
            }
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
