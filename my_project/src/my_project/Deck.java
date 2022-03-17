package my_project;

public class Deck {
	private int[] deck;
	public static final int NUMCARDS = 52;
	
	public Deck()
	{
		deck = new int[NUMCARDS];
		for (int i = 0; i < NUMCARDS; i++)
		{
			deck[i] = i;
		}
	}
	public void shuffle()
	{
		
	}
}
