/* The game expo ticket will test these scenarios:
    - Boys age >7 and <10 - Storytelling.       CHECk
    - Girls age >7 and <10 - Drawing.           CHECK
    - Boys age >11 and <15, Quiz.               CHECK
    - Girls age >10 and <15 - Essay Writing.    CHECK
    - Boys and girls age <6 - Rhyming.          CHECK
    - Girls and boys age >20 - Poetry.          CHECK
*/
import java.util.Scanner;

public class GameExpoTicket {
    public static final String BOY = "boy";
    public static final String GIRL = "girl";

    public static String getCompetition(int age, String gender) {
        if (gender == null) return "Invalid Input";

        // Trim and lowercase input
        gender = gender.trim().toLowerCase();

        //BOYS
        if (gender.equals(BOY)) {
            // if age < 6   - Rhyming
            if (age < 6) {
                return "Rhyming";
            }

            // Boys age >7 and <10 - Storytelling
            else if (age > 7 && age < 10) {
                return "Storytelling";
            }

            // Boys age >11 and <15, Quiz
            else if (age > 11 && age < 15) {
                return "Quiz";
            }
            // age > 20 - Poetry
            else if (age > 20) {
                return "Poetry";
            } 
            else return "No Competition Available"; 
        }

        //GIRLS
        else if (gender.equals(GIRL)) {
            // if age < 6   - Rhyming
            if (age < 6) {
                return "Rhyming";
            }

            // Girls age >7 and <10 - Drawing
            else if (age > 7 && age < 10) {
                return "Drawing";
            }

            // Girls age >10 and <15 - Essay Writing.
            else if (age > 10 && age < 15) {
                return "Essay Writing";
            }

            // age > 20 - Poetry
            else if (age > 20) {
                return "Poetry";
            }
            else return "No Competition Available"; 
        } 
        else return "Invalid Input";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        
        while (choice != 0) {
            System.out.println("=== GAME EXPO TICKET FOR CHILDREN ===");
            System.out.print("Input age: ");
            int age = sc.nextInt();
            System.out.print("Input gender: ");
            String gender = sc.next().toLowerCase();

            // Check for valid age and gender
            String result = getCompetition(age, gender);
            System.out.println(result);  

            // Menu Switch for iterate
            System.out.println("\nEnter 1 to continue selecting ticket, 0 to quit.");
            choice = sc.nextInt();

            //1 to continue, 0 to quit
            switch (choice) {
                case 1:
                    System.out.println("Continuing...");
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Exiting...");
                    choice = 0;
            }
        }


        sc.close();

    }
}