/* Paul Lukaszewicz 
 * pjl@uwm.edu 
 * CS250 LEC 401 LAB 803 
 * Program09
 * Due 05-04-2020 @2359
 * 
 * Followed instructions and used intuitive naming conventions. Two methods were added. welcome 
 * gives an opening message. shuffleQ asks the user if they want to shuffle and how many times. It 
 * returns an int value to be used in the shuffleDeck method. If "n" is entered 0 becomes the return
 * value and the shuffleDeck method skips the entire looping body. Thanks for running this program! 
 */

import java.util.Scanner;

public class LowShuffle {

    public static void main(String[] args) {
        int shuffleTimes = 0;
        int[] deck = new int[36];
        Scanner userIn = new Scanner(System.in);
        
        //Test Section: Remove Comments to use.
        //initDeck(deck);
        //displayDeck(deck);
        //System.out.println("");
        //cutDeck(deck);
        //displayDeck(deck);
        //System.out.println("");
        //shuffleDeck(deck, 1);
        //displayDeck(deck);
        //System.out.println("");
        
        
        welcome();
        initDeck(deck);
        displayDeck(deck);
        
        do {
        shuffleTimes = shuffleQ(userIn);
        shuffleDeck(deck, shuffleTimes);
        
        if (shuffleTimes > 0) {
        displayDeck(deck);
        }
        
        } while(shuffleTimes > 0);
    }
    
    public static int cardValue(int card) {
        int val = (card % 9) + 1;
        
        return val;
    }
    
    public static String cardSuit(int card) {
        int suitNum = card / 9;
        String suit = "";
        
        if(suitNum == 0) {
            suit = "Club";
        }
        else if(suitNum == 1) {
            suit = "Spade";
        }
        else if(suitNum == 2) {
            suit = "Heart";
        }
        else {
            suit = "Diamond";
        }
        
        return suit;
    }
    
    public static void displayCard(int card) {
        System.out.println("" + cardValue(card) + " of " + cardSuit(card));
    }
    
    public static void initDeck(int[] deck) {
        for (int i = 0; i < 36; ++i) {
            deck[i] = i;
        }
    }
    
    public static void cutDeck(int[] deck) {
        int cutIndex = (int)(Math.random() * 18) + 6; 
        int[] top = new int[cutIndex];
        int[] bottom = new int[36 - cutIndex];
        
        for(int i = 0; i < cutIndex; ++i) {
            top[i] = deck[i];
        }
        
        for(int j = cutIndex; j < 36; ++j) {
            bottom[j - cutIndex] = deck[j];
        }
        
        for(int k = 0; k < 36; ++k) {
            
            if(k < bottom.length) {
                deck[k] = bottom [k];
            }
            else {
                deck[k] = top[k - bottom.length];
            }
        }
    }
    
    public static void shuffleDeck(int[] deck, int n) {
        int[] top = new int[18];
        int[] bottom = new int[18];
       
        for(int shuffleTimes = 1; shuffleTimes <= n; ++shuffleTimes) {
        cutDeck(deck);
        
        for(int i = 0; i < 18; ++i) {
                top[i] = deck[i];
            }
        
        for(int j = 18; j < 36; ++j) {
            bottom[j - 18] = deck[j];
        }
        
        for(int k = 0; k < 36; ++k) {
            if(k % 2 == 0) {
                deck[k] = top[k / 2];
            }
            else {
                deck[k] = bottom[k / 2];
            }
        }
        System.out.println("Shuffled " + shuffleTimes + " Time(s)");
    }
        System.out.println("");
    }
    
    public static void displayDeck(int[] deck) {
        
        for(int i = 0; i < 36; ++i) {
            displayCard(deck[i]);
        }
    }
    
    public static void welcome() {
        System.out.println("-----Welcome to the Automated Card Shuffler-----\n");
        System.out.println("You start with an unshuffled deck, it is recommended "
            + "to shuffle several times.\n");
    }
    
    public static int shuffleQ(Scanner userIn) {
        String decision = "";
        int shuffleTimes = 0;
        
        do {
            System.out.println("");
            System.out.print("Would you like to shuffle? (y/n): ");
            decision = userIn.next();
            System.out.println("");
        } while (!(decision.equalsIgnoreCase("y")) && !(decision.equalsIgnoreCase("n")));
        
        if (decision.equalsIgnoreCase("y")) {
            
            do {
            System.out.print("How many times? [1-10]: ");
            shuffleTimes = userIn.nextInt();
            System.out.println("");
            } while (!(shuffleTimes >= 1) && !(shuffleTimes <= 10));
        }
        else {
            shuffleTimes = 0;
            System.out.println("-----Thanks for Using the Automated Card Shuffler-----");
        }
        
        return shuffleTimes;
    }
}
