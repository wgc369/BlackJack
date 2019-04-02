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
        char choice = 0;
        String playerHit = "n";
        do
        {
            dealer.shuffle();
            player.addCardToHand(dealer.deal());
            dealer.addCardToHand(dealer.deal());
            int playerTotal = player.getHandValue();
            out.println("\nPLAYER ");
            out.println("Hand Value :: " + playerTotal );
            out.println("Hand Size :: " + player.getHandSize() );
            out.println("Cards in Hand :: " + player.toString() );
            out.println("Do you want to hit :: y/n");
            playerHit = keyboard.nextLine();
            while(playerTotal<21 && playerHit.equals("y"))
            {
                
            }


        }while(choice=='y');
    }
    public static void main(String[] args)
    {
	BlackJack game = new BlackJack();
	game.playGame();
    }
}