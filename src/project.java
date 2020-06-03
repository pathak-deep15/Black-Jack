import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class project {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("------Welcome to the Black Jack Game-------");
        System.out.println();

        Scanner sc = new Scanner((System.in));

//        System.out.println("How many players are there");
//        int numberOfPlayers = sc.nextInt();
//
//        ArrayList<Integer>[] players = new ArrayList[numberOfPlayers];
//
//        for(int i = 0; i<players.length; i++){
//
//            System.out.println("");
//        }
//


        System.out.println("You will be dealt 2 cards now");
        System.out.println();


        int playerCard1, playerCard2;
        int dealerCard1;
        boolean playerBlackJack = false;
        boolean dealerBlackJack = false;
        boolean playerBusted = false;
        boolean dealerBusted = false;

        Random rand = new Random();
        cardMachine card = new cardMachine();
        BlackJack newBlackJack = new BlackJack();

        System.out.println("------Player's Turn---------");
        System.out.println();

        playerCard1 = card.nextCard();
        System.out.println("The value of your first card is " + playerCard1);
        System.out.println();

        sleep(300);

        playerCard2 = card.nextCard();
        System.out.println("The value of your second card is " + playerCard2);
        System.out.println();

        int sumPlayer = playerCard1 + playerCard2;
        playerBlackJack = newBlackJack.checkBlackJack(sumPlayer, "Player");

        if (!playerBlackJack) {

            System.out.println("The sum of your first two cards are " + sumPlayer);
            System.out.println();
            System.out.println("----------Dealer's Turn---------");
            System.out.println();
            System.out.println("Now Dealer will take one card");
            System.out.println();

            sleep(300);
            dealerCard1 = card.nextCard();
            int sumDealer = dealerCard1;
            System.out.println("Dealer's first card's value is " + dealerCard1 + " and so the sum of dealer cards as of now is " + sumDealer);
            System.out.println();

            System.out.println("--------Player's turn to pick cards---------");
            System.out.println();

            while (true) {
                System.out.println("Do you want dealer to deal next card y/n");
                String ans = sc.next();
                if (ans.equals("y")) {
                    sleep(300);
                    int newPlayerCard = card.nextCard();
                    if (newPlayerCard == 1) {
                        if (11 + sumPlayer < 21) {
                            newPlayerCard = 11;
                        }
                    }
                    System.out.println("Your next card's value is " + newPlayerCard);
                    System.out.println();
                    sumPlayer = newPlayerCard + sumPlayer;

                    playerBlackJack = newBlackJack.checkBlackJack(sumPlayer, "Player");
                    if (playerBlackJack) {
                        break;
                    }

                    playerBusted = newBlackJack.checkBusted(sumPlayer, "Player");
                    if (playerBusted) {
                        break;
                    }

                    System.out.println("The sum of your cards is now " + sumPlayer);
                    System.out.println();
                } else break;
            }

            if (!playerBlackJack && !playerBusted) {
                System.out.println("Your final sum is " + sumPlayer);
                System.out.println();
                System.out.println("----Dealer's turn to take cards-------");
                System.out.println();
                while (sumDealer < 17) {
                    sleep(300);
                    int newDealerCard = card.nextCard();
                    if (newDealerCard == 1) {
                        if (11 + sumDealer < 21) {
                            newDealerCard = 11;
                        }
                    }
                    sumDealer += newDealerCard;
                    System.out.println("Dealer's next card value is " + newDealerCard);
                    System.out.println();

                    dealerBlackJack = newBlackJack.checkBlackJack(sumDealer, "Dealer");
                    if (dealerBlackJack) {
                        break;
                    }

                    dealerBusted = newBlackJack.checkBusted(sumDealer, "Dealer");
                    if (dealerBusted) {
                        break;
                    }

                    System.out.println("The sum of Dealer's cards is now " + sumDealer);
                    System.out.println();
                }

                if (!dealerBlackJack && !dealerBusted) {
                    newBlackJack.checkFinalResult(sumPlayer, sumDealer);
                }

            }
        }
    }
}
