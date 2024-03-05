package appphase5;

/**
 * @author 12223508
 * 
 * Represents a user's response for a quiz question.
 * Records question number, correctness, and number of attempts.
 *
 */
public class Entry {

    private int questionNumber;
    private boolean Correct;
    private int attempts;

    /**
     * Constructor for an Entry object.
     *
     * @param questionNumber The number of the question.
     * @param Correct      Whether the question was answered correctly.
     * @param attempts       Number of attempts made for the question.
     */
    public Entry(int questionNumber, boolean Correct, int attempts) {
        this.questionNumber = questionNumber;
        this.Correct = Correct;
        this.attempts = attempts;
    }
    
    /**
     * Retrieves the question number.
     *
     * @return The number of the question.
     */
    public int getQuestionNumber() {
        return questionNumber;
    }

    
    /**
     * Retrieves the number of attempts made for the question.
     *
     * @return The number of attempts.
     */
    public int getAttempts() {
        return attempts;
    }
    
    
    /**
     * Checks if the answer for the question is correct.
     *
     * @return true if the answer was correct, false otherwise.
     */
    public boolean isCorrect() {
        return Correct;
    }

}
