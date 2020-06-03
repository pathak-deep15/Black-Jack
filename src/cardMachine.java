import java.util.*;

import static java.lang.Thread.sleep;

public class cardMachine {

    public int nextCard() throws InterruptedException {
        Random rand = new Random();
        int newCardValue = rand.nextInt(13)+1;
        int newCardSuit = rand.nextInt(4) + 1;

        String cardSuit = findCardSuit(newCardSuit);
        String cardType = findCardType(newCardValue);

        System.out.println("--------New Card coming---------");
        sleep(300);
        System.out.println("New Card is " + cardType + " of " + cardSuit);
        System.out.println();

        if(newCardValue>10){ newCardValue=10;}

        return newCardValue;
    }

    public String findCardType(int cardValue){
        switch (cardValue){
            case 1:
                return "Ace";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return "Wrong Card";
        }
    }

    public String findCardSuit(int newCardSuit){
        switch (newCardSuit){
            case 1:
                return "Spade";
            case 2:
                return "Diamond";
            case 3:
                return "Hearts";
            case 4:
                return "Clubs";
            default:
                return "Wrong Suit";
        }
    }
}
