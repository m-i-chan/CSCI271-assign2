/*
Name: Marc Chan
Date: 02/05/2024
Class: CSCI 271 - Data Structures
Instructor: Dr. Jeff Gao
Pledge: I, Marc Chan, did not receive any help for this programming assignment.
 */

public class LotteryGame {
    /*
      Lottery game logic and helper functions. Contains variables for minimum allowed guess, maximum allowed
      guess, and prize amount.
    */
    private final int min, max;
    private final double prize;
    private int numWinners;
    private Bag entries = new Bag();

    public LotteryGame() {
        this(0,1,.1);
    }
    public LotteryGame(int min, int max, double prize) {
        this.min = min;
        this.max = max;
        this.prize = prize;
    }
    public int addTicket() {
        // Adds a ticket with a random pick. Returns what pick was submitted.
        return addTicket(randomNumberInRange());
    }
    public int addTicket(int pick) {
        // Adds a ticket with the given pick. Returns what pick was submitted.
        entries.insert(pick);
        return pick;
    }
    public int drawWinningNumber() {
        // Draws winning number and determines the amount of winners. Returns the winning number.
        int num = randomNumberInRange();
        numWinners = entries.occurrence(num);
        return num;
    }
    public int getNumWinners() {
        return numWinners;
    }
    public double getWinnings() {
        if (numWinners == 0) {
            return 0;
        }
        return prize/numWinners;
    }
    public int getNumEntries() {
        return entries.size();
    }
    public void newRound() {
        // Reset the entries and number of winners for a new round.
        entries = new Bag();
        numWinners = 0;
    }
    private int randomNumberInRange() {
        // Helper function to assign random picks or draw winning number.
        return (int) (Math.random() * (max - min) + min);
    }
}
