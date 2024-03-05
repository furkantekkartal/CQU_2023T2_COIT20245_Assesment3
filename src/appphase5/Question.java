package appphase5;

/**
 * Represents a single quiz question with its correct answer.
 */
public class Question {

    private String question;
    private String answer;

    /**
     * Initializes the question with its text and correct answer.
     *
     * @param q The text of the quiz question.
     * @param a The correct answer for the question.
     */
    public Question(String q, String a) {
        this.question = q;
        this.answer = a;
    }

    /**
     * @return The text of the quiz question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @return The correct answer for the question.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Evaluates a given response against the correct answer.
     *
     * @param response The user's answer.
     * @return True if the response matches the correct answer, false otherwise.
     */
    public boolean mark(String response) {
        return answer.equalsIgnoreCase(response);
    }
}
