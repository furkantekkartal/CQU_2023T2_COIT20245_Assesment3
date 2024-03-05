package appphase5;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages and provides quiz questions.
 */
public class Quiz {

    private int currentQuestion = -1;
    private Question[] questions;

    /**
     * Loads default quiz questions(For earlier phases).
     */
    public Quiz() {
        load();
    }

    /**
     * Loads quiz questions from a specified file.
     *
     * @param fileName The path of the file containing the quiz questions.
     */
    public Quiz(String fileName) {
        loadFromFile(fileName);
    }

    /**
     * Populates the questions array with default questions.
     */
    private void load() {
       String[] q = {
            """
            Q1. Which of the following numbers is irrational? 
            a. pi
            b. 22/7
            c. 3.14159
            d. all of the above
            """
            ,
            """
            Q2. Which of the following numbers is rational?
            a. pi
            b. 22/7
            c. 3.14159
            d. none of the above
            """
            ,
            """
            Q3. Two methods can be overloaded if they differ only in their return types.
            true or false?
            """
            ,
            """
            Q4. A variable must be ---- before it can be used.
            """
        };

        String[] a = {
            "a" ,       // q1
            "b" ,       // q2
            "false",    // q3
            "declared"  // q4
        };


        questions = new Question[q.length];
        for (int i = 0; i < q.length; i++) {
            questions[i] = new Question(q[i], a[i]);
        }
    }    
    
    /**
     * Loads questions from a specified file and populates the questions array.
     *
     * @param fileName Path of the file containing the quiz questions.
     */
    private void loadFromFile(String fileName) {
        List<Question> questionList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int numOfQuestions = Integer.parseInt(br.readLine().trim());
            br.readLine();  // Consuming the blank line

            for (int i = 0; i < numOfQuestions; i++) {
                // Read and construct the Question and Answer
                br.readLine();  // Read "QS"
                StringBuilder questionText = new StringBuilder();
                String line;
                while (!(line = br.readLine()).equals("QE")) {
                    questionText.append(line).append("\n");
                }
                br.readLine();  // Read "AS"
                String answerText = br.readLine().trim();
                br.readLine();  // Read "AE"
                br.readLine();  // Read the blank line if present

                questionList.add(new Question(questionText.toString(), answerText));
            }

            questions = questionList.toArray(new Question[0]);

        } catch (IOException e) {  // Close the program safely if there is an error.
            System.out.println("Error reading the quiz file. Please ensure 'quiz.txt' is placed correctly and try again.");
            System.exit(1);  
         }
    }

    /**
     * @return The first question from the quiz.
     */
    public Question firstQuestion() {
        currentQuestion = 0;
        return questions[currentQuestion];
    }

    /**
     * Retrieves the next question from the quiz.
     *
     * @return The next question or null if there are no more questions.
     */
    public Question nextQuestion() {
        currentQuestion++;
        if (currentQuestion >= questions.length) {
            return null;
        }
        return questions[currentQuestion];
    }
}
