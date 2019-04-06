package BlackJack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BlackJack
{
	//add in Player instance variable
	//add in Dealer instance variable
    //Player player;
    //Dealer dealer;
    private int playerNum;
    private ArrayList<Playerable> players;
    
    public BlackJack()
    {
        Scanner keyboard = new Scanner(System.in);

        //player = new Player();
        //dealer = new Dealer();
        players = new ArrayList<Playerable>();
        out.println("How many players? ");
        playerNum = keyboard.nextInt()+1;
        Dealer d = new Dealer();
        players.add(d);
        for(int i=1; i<playerNum; i++)
        {
            players.add(new Player());
        }
    }

    public void playGame()
    {
        Scanner keyboard = new Scanner(System.in);
        /*char*/String choice = "";
        //String playerHit = "n";
        do
        {
            //multiplayer blackjack
            ((Dealer)players.get(0)).shuffle();
            for(int i=1; i<playerNum; i++)
            {
                players.get(i).addCardToHand(((Dealer)players.get(0)).deal());
                players.get(i).addCardToHand(((Dealer)players.get(0)).deal());
            }
            players.get(0).addCardToHand(((Dealer)players.get(0)).deal());
            players.get(0).addCardToHand(((Dealer)players.get(0)).deal());
            for(int i=1; i<playerNum; i++)
            {
                Player player = (Player)players.get(i);
                Dealer dealer = (Dealer)players.get(0);
                int playerTotal = players.get(i).getHandValue();
                out.println("Player"+i+" Current hand " + players.get(i).toString()+ " total:"+ playerTotal);
                out.println("Do you want to hit :: [Y/N]");
                String playerHit = keyboard.nextLine();
                while(playerTotal<21 && playerHit.equals("y"))
                {
                player.addCardToHand(dealer.deal());
                player.hit();
                playerTotal = player.getHandValue();
                out.println("Player"+i+" Current hand " + player.toString()+ " total:" + playerTotal);
                out.println("Do you want to hit :: [Y/N]");
                playerHit = keyboard.nextLine();
                playerTotal = player.getHandValue();
                }
            }
            Dealer dealer = (Dealer)players.get(0);
            int dealerTotal = dealer.getHandValue();
            out.println("\nDEALER ");
            out.println("Hand Value :: " + dealerTotal );
            out.println("Hand Size :: " + dealer.getHandSize() );
            out.println("Cards in Hand :: " + dealer.toString() + " total:" + dealerTotal);
            for(int i=1; i<playerNum; i++)
            {
                Player player = (Player)players.get(i);

                int playerTotal = players.get(i).getHandValue();
                out.println("\nPLAYER" + i);
                out.println("Hand Value :: " + playerTotal );
                out.println("Hand Size :: " + player.getHandSize() );
                out.println("Cards in Hand :: " + player.toString()+ " total:" + playerTotal );
            }
                            int big = 0;
                            int index = 0;
            for(int i=1; i<playerNum; i++)
            {
                int playerTotal = players.get(i).getHandValue();
                if(playerTotal>big && playerTotal<=21)
                {
                    big = playerTotal;
                    index = i;
                }
            }
            if(big<dealer.getHandValue() && dealer.getHandValue()<=21)
            {
                out.print("Dealer won!");
                dealer.setWinCount(dealer.getWinCount()+1);
            }
            else
            {
                out.println("Player"+index+" won!");
                players.get(index).setWinCount(players.get(index).getWinCount()+1);
            }
/*
            //regular blackjack
            dealer.shuffle();
            player.addCardToHand(dealer.deal());
            dealer.addCardToHand(dealer.deal());
            player.addCardToHand(dealer.deal());
            dealer.addCardToHand(dealer.deal());
            int playerTotal = player.getHandValue();
            int dealerTotal = dealer.getHandValue();
            out.println("Current hand " + player.toString()+ " total:"+playerTotal);
            out.println("Do you want to hit :: [Y/N]");
            playerHit = keyboard.nextLine();
            while(playerTotal<21 && playerHit.equals("y"))
            {
                player.addCardToHand(dealer.deal());
                player.hit();
                playerTotal = player.getHandValue();
                out.println("Current hand " + player.toString()+ " total:" + playerTotal);
                out.println("Do you want to hit :: [Y/N]");
                playerHit = keyboard.nextLine();
                playerTotal = player.getHandValue();
            }
            out.println("\nPLAYER ");
            out.println("Hand Value :: " + playerTotal );
            out.println("Hand Size :: " + player.getHandSize() );
            out.println("Cards in Hand :: " + player.toString()+ " total:" + playerTotal );
            while(dealerTotal<=17)
            {
                
                dealer.hit();
                dealerTotal = dealer.getHandValue();
            }
            out.println("\nDEALER ");
            out.println("Hand Value :: " + dealerTotal );
            out.println("Hand Size :: " + dealer.getHandSize() );
            out.println("Cards in Hand :: " + dealer.toString() + "total:" + dealerTotal);
            if(playerTotal>21&&dealerTotal<=21)
		{
		   out.println("\nDealer wins - Player busted!");
                   dealer.setWinCount(dealer.getWinCount()+1);
		}
		else if(playerTotal<=21&&dealerTotal>21)
		{
		   out.println("\nPlayer wins - Dealer busted!");
                   player.setWinCount(player.getWinCount()+1);
		}
		else if(playerTotal>21&&dealerTotal>21){
		   out.println("Both players bust!");
		}
		else if(playerTotal<dealerTotal){
		   out.println("\nDealer has bigger hand value!");
                   dealer.setWinCount(dealer.getWinCount()+1);
		}
		else{
		   out.println("\nPlayer has bigger hand value!");
                   player.setWinCount(player.getWinCount()+1);
		}
            
            out.println("Dealer has won " + dealer.getWinCount() + " times");
            out.println("Player has won " + player.getWinCount() + " times");
*/
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