import java.util.Scanner;
public class Main {

    public static void main (String[] args) {
        int sides, diceAmt;
        boolean calculateTotal = false, validInput = false;
        String answer;
        Scanner scan = new Scanner (System.in);

        while (validInput == false) {
            System.out.print ("Calculate the total? (Y/N): ");
            answer = scan.nextLine();
            answer = answer.toLowerCase();
            if (answer.equals("y") || answer.equals("yes")) {
                calculateTotal = true;
                validInput = true;
            }
            else if (answer.equals("n") || answer.equals("no")) {
                validInput = true;
            }
            else {
                System.out.println ("Please enter a valid input. (Y/N)\n---------------");
            }
        }

        System.out.print("Amount of dice to roll: ");
        diceAmt = scan.nextInt();
        Die[] dice = new Die[diceAmt];

        for (int i = 0; i < diceAmt; i++) {
            System.out.print ("Number of sides for die #" + (i+1) + ": ");
            sides = scan.nextInt();
            dice[i] = new Die(sides);
        }

        for (int i = 0; i < diceAmt; i++) {
            System.out.println ("---------------");
            System.out.println ("Die #" + (i+1) + ": " + dice[i].RollDie());
            if (dice[i].GetSides() == 20) {
                if (dice[i].GetRoll() == 20) {
                    System.out.println ("Critical hit!");
                }
                else if (dice[i].GetRoll() == 1) {
                    System.out.println ("Critical fail!");
                }
            }
        }

        if (calculateTotal == true) {
            System.out.println ("---------------\nTotal: " + addTotal(dice));
        }
    }

    static int addTotal(Die[] dice) {
        int total = 0;
        for (int i = 0; i < dice.length; i++) {
            total += dice[i].GetRoll();
        }
        return total;
    }
}
