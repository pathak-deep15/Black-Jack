public class BlackJack {

    public boolean checkBlackJack(int cardSum, String player){
        if(cardSum==21){
            System.out.print("Congratulations " + player + " has the BlackJack as the sum has become " + cardSum + ". So " + player + " won.");
            System.out.println();
            return true;
        }
        return false;
    }

    public boolean checkBusted(int cardSum, String player){
        if(cardSum>21){
            System.out.println(player + " is busted with the sum " + cardSum + ". So " + player + " lost.");
            System.out.println();
            if(player.equals("Dealer")){System.out.println("Congratulations you won as the dealer busted.");}
            return true;
        }
        return false;
    }

    public void checkFinalResult(int sumPlayer, int sumDealer){
        if(sumDealer == sumPlayer){
            System.out.println("The score is tied at " + sumDealer + " . So the Dealer won");
        } else if(sumDealer > sumPlayer){
            System.out.println("Dealer has higher score of " + sumDealer + " than your score of " + sumPlayer + " . So Dealer won.");
        } else{
            System.out.println("Your score of " + sumPlayer + " is higher than Dealer's score of " + sumDealer + " . So you won.");
        }

    }
}
