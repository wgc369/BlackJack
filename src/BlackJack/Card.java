package BlackJack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 


public abstract class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

  	//constructors
        public Card()
        {
            setFace(0);
            setSuit("");
        }
        
        public Card(int f, String s)
        {
            setSuit(s);
            setFace(f);
        }


	// modifiers
        public void setSuit(String s)
        {
            suit = s;
        }
        public void setFace(int f)
        {
            face = f;
        }

 

  	//accessors
        public int getFace()
        {
            return face;
        }
        public String getSuit()
        {
            return suit;
        }




  	public abstract int getValue();

	public boolean equals(Object obj)
	{
            Card c = new BlackJackCard();
            c=(Card)obj;
		if (c.getSuit() == suit && c.getValue() == getFace())
                {
                    return true;
		}
		return false;
	}

  	//toString
  	public String toString()
        {
            return FACES[face] + " of " + suit;
        }
 }