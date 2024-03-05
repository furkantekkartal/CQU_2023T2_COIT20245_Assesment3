/**
 * @author "12223508 - Furkan Tekkartal" 
 *
 * The program is a quiz application that presents users with a series of 
 * questions. Users can answer each question with a limited number of attempts. 
 * Their responses are logged and, at the end, a performance summary is 
 * displayed on the console. Additionally, a detailed log is saved to 
 * "report.txt", outlining the results for each question. 
 */

//The main class for the Assignment3 Phase5.
package appphase5;
public class AppPhase5 {
     
    /**
     * The entry point for the quiz application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        Quiz quiz = new Quiz("quiz.txt"); 
        Manager manager = new Manager(quiz, 2); // 2 attempts for the future
        manager.takeQuiz();
    }
}
