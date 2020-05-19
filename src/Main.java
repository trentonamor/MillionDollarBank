import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final int PRIZEBALANCE = 1000000;
    public static void main(String[] args) {
        // Get User Input
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to input 2 numbers or run the whole suite? \n" +
                "Type n or numbers for just 2 numbers or type f or full for the full suite. Press any other key to quit.");
        String ans = keyboard.next();
        if(ans.toLowerCase().equals("n") || ans.toLowerCase().equals("numbers")) {
            System.out.println("Please input your FIRST number: ");
            int first = keyboard.nextInt();
            System.out.println("Please input your SECOND number: ");
            int second = keyboard.nextInt();
            System.out.println("Thank you!");
            String result = "";
            int time = calculateTime(first, second);
            if(time == -1) {
                result = "Your numbers " + first + ", " + second + " did not make a million dollars. Better luck next time!";
            } else {
                result = "Congratulations! Your numbers " + first + ", " + second + " made a million dollars in " + time + " days.";
            }
            System.out.println(result);
        } else if(ans.toLowerCase().equals("f") || ans.toLowerCase().equals("full")) {
            System.out.println("This should take approximately 45 minutes. Hang tight while we process your request");
            runSuite();
        }
    }

    public static int calculateTime(int first, int second) {
        int savings = 0;
        int previousSavings = 0;
        savings += first;
        previousSavings = savings;
        savings += second;

        int count = 0;
        while(savings < PRIZEBALANCE) { // Calculate until we are rich
            int temp = savings;
            savings += previousSavings;
            previousSavings = temp;

            count++;
            System.out.println(savings);
        }
        if(savings == PRIZEBALANCE) {
            return count;
        } else {
            return -1;
        }
    }

    public static void runSuite() {
        // Initialize Variables
        int firstAmt = 0;
        int secondAmt = 0;
        ArrayList<Winners> winners = new ArrayList<>();
        int longestTime = 0;
        int savings = 0;
        int percent = 0;

        for(int i = 0; i < (PRIZEBALANCE); i++) {
            if(i%10000 == 0) {
                System.out.println(percent + "%");
                percent++;
            }
            for(int j = 1; j <= (PRIZEBALANCE - i); j++) {
                savings = 0;
                int previousSavings = 0;
                savings += i;
                previousSavings = savings;
                savings += j;

                int count = 0;
                while(savings < PRIZEBALANCE) { // Calculate until we are rich
                    int temp = savings;
                    savings += previousSavings;
                    previousSavings = temp;

                    count++;
                }
                if((count > longestTime) && (savings == PRIZEBALANCE)) {
                    longestTime = count;
                    // Reset winners since a new longest was found
                    winners = new ArrayList<>();
                }
                if(savings == PRIZEBALANCE && count == longestTime) {
                    Winners w = new Winners(i,j);
                    winners.add(w);
                }
            }
        }

        System.out.print("Winning deposits: [");
        for (Winners winner: winners) {
            System.out.print(winner.toString() + ", ");
        }
        System.out.print("]\n");
        System.out.println("Time: " + longestTime);
    }
}
