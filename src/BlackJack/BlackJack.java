package BlackJack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
	//add in Player instance variable
	//add in Dealer instance variable
    Player player;
    Dealer dealer;
    public BlackJack()
    {
        player = new Player();
        dealer = new Dealer();
    }

    public void playGame()
    {
        Scanner keyboard = new Scanner(System.in);
        /*char*/String choice = "";
        String playerHit = "n";
        do
        {
            dealer.shuffle();
            player.addCardToHand(dealer.deal());
            dealer.addCardToHand(dealer.deal());
            player.addCardToHand(dealer.deal());
            dealer.addCardToHand(dealer.deal());
            int playerTotal = player.getHandValue();
            int dealerTotal = dealer.getHandValue();
            out.println("Current hand hand = " + player.toString()+playerTotal);
            out.println("Do you want to hit :: [Y/N]");
            playerHit = keyboard.nextLine();
            while(playerTotal<21 && playerHit.equals("y"))
            {
                //player.addCardToHand(dealer.deal());
                player.hit();
            }
            out.println("\nPLAYER ");
            out.println("Hand Value :: " + playerTotal );
            out.println("Hand Size :: " + player.getHandSize() );
            out.println("Cards in Hand :: " + player.toString() );
            while(dealerTotal<=17)
            {
                dealer.hit();
            }
            out.println("\nDEALER ");
            out.println("Hand Value :: " + dealerTotal );
            out.println("Hand Size :: " + dealer.getHandSize() );
            out.println("Cards in Hand :: " + dealer.toString() );
            if(playerTotal>21&&dealerTotal<=21)
		{
		   out.println("\nDealer wins - Player busted!");
		}
		else if(playerTotal<=21&&dealerTotal>21)
		{
		   out.println("\nPlayer wins - Dealer busted!");
		}
		else if(playerTotal>21&&dealerTotal>21){
		   out.println("Both players bust!");
		}
		else if(playerTotal<dealerTotal){
		   out.println("\nDealer has bigger hand value!");
		}
		else{
		   out.println("\nPlayer has bigger hand value!");
		}
            out.println("Do you want to play again? [Y,y,N,n]");
            choice = keyboard.nextLine();
        }while(choice.equals("y"));
    }
    public static void main(String[] args)
    {
	BlackJack game = new BlackJack();
	game.playGame();
    }
}