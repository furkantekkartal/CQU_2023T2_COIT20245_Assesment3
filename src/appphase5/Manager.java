package appphase5;
import java.util.Scanner;

/**
 * Facilitates the quiz-taking process, recording user responses and presenting feedback.
 */
public class Manager {

    private int attemptsAllowedPerQuestion;
    private Scanner input;
    private Log log;
    private Quiz quiz;

    /**
     * Initializes the Manager with a Quiz and specifies allowed attempts for each question.
     *
     * @param q        The quiz to be administered.
     * @param attempts Allowed attempts per question.
     */
    public Manager(Quiz q, int attempts) {
        this.quiz = q;
        this.attemptsAllowedPerQuestion = attempts;
        this.input = new Scanner(System.in);
        this.log = new Log();
    }

    /**
     * Administers the quiz, prompting user inputs, and recording responses.
     */
    public void takeQuiz() {
        int questionNumber = 1;
        Question question = quiz.firstQuestion();

        while (question != null) {
            int attempts = 0;
            boolean correct = false;

            System.out.print(question.getQuestion());

            do {
                attempts++;
                System.out.print("> ");
                String userAnswer = input.nextLine();
                correct = question.mark(userAnswer);

                if (correct) {
                    System.out.println("Correct");
                } else {
                    System.out.println("Incorrect");
                }

            } while (!correct && attempts < attemptsAllowedPerQuestion);

            log.add(questionNumber, correct, attempts);
            questionNumber++;
            if (attempts > 0) System.out.println(); // Space line between questions
            question = quiz.nextQuestion();
        }

        displaySummary();
    }
    
    /**
     * Displays a summary of the user's performance after completing the quiz.
     */
    private void displaySummary() {
        int correctAnswers = log.correct();
        int totalQuestions = log.numberOfQuestions();
        int totalAttempts = log.attempts();

        System.out.println("Correct answers : " + correctAnswers + "/" + totalQuestions);
        System.out.println("Attempts        : " + totalAttempts + "/" + totalQuestions);

        log.save("report.txt");
    }
}