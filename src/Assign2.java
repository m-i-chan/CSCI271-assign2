/*
Name: Marc Chan
Date: 02/05/2024
Class: CSCI 271 - Data Structures
Instructor: Dr. Jeff Gao
Pledge: I, Marc Chan, did not receive any help for this programming assignment.
 */

import java.util.Scanner;

public class Assign2 {
    /*
      Lottery program that allows entry of guesses to a bag. "Empty" guesses are assigned a random number. Duplicates are
      allowed. When sales are closed, program draws a winning number, reports the winning number, then determines whether
      there are any winners/how much each winner won. If there are no winners, program begins a new round with new entries.
    */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LotteryGame lotto = new LotteryGame(1,20,4000);
        if (args.length == 3) {
            // Allows alternate values for testing purposes.
            int min = Integer.parseInt(args[0]);
            int max = Integer.parseInt(args[1]);
            double prize = Double.parseDouble(args[2]);
            lotto = new LotteryGame(min, max, prize);
            System.out.printf("Welcome to the lottery. The prize pool is $%.2f.\n", prize);
            System.out.printf("The winning number will be picked from %d-%d.\n", min, max);
        }
         else {
            System.out.println("Welcome to the lottery. The prize pool is $4000.00.");
            System.out.println("The winning number will be picked from 1-20.");
        }
        boolean payout = false;
        while (!payout) {
            System.out.println("Enter a number to purchase a ticket. Invalid entries will be assigned a random number.");
            System.out.println("Enter -1 to close sales and draw a winner.");
            while (true) {
                String temp = input.nextLine();
                try {
                    int pick = Integer.parseInt(temp);
                    if (pick < 0) {
                        break;
                    }
                    System.out.printf("%d was added to the bag.\n",lotto.addTicket(pick));
                } catch (Exception e) {
                    System.out.printf("%d was added to the bag.\n",lotto.addTicket());
                }
            }
            if (lotto.getNumEntries() == 0) {
                System.out.println("No tickets were purchased. Beginning a new round.\n");
                continue;
            }
            System.out.printf("Sales are closed. The winning number is %d.\n",lotto.drawWinningNumber());
            int numWinners = lotto.getNumWinners();
            switch (numWinners) {
                case 0: lotto.newRound();
                        System.out.println("There are no winners. Beginning a new round.\n");
                        break;
                case 1: System.out.printf("There is %d winner. They won $%.2f! Congratulations.\n", numWinners, lotto.getWinnings());
                        payout = true;
                        break;
                default: System.out.printf("There are %d winners. They each won $%.2f! Congratulations.\n", numWinners, lotto.getWinnings());
                         payout = true;
            }
        }
        input.close();
    }
}



