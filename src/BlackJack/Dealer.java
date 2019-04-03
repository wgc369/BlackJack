package BlackJack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 


//define Dealer class here
public class Dealer extends AbstractPlayer
{	
	
	
	//instance variable - Deck 
    Deck d = new Deck();




	//constructors
    public Dealer()
    {
        super();
    }




	//method to shuffle
    public void shuffle()
    {
        d.shuffle();
    }





	//method to deal a card
    public Card deal()
    {
        return d.nextCard();
    }




	//hit method goes here
    public boolean hit()
    {
       //addCardToHand(deal());
       return true;
    }
}