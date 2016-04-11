/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"jack", "queen", "king"};
		String[] suits = {"black", "red"};
		int[] pointValues = {10, 11, 12};
		Deck d = new Deck(ranks, suits, pointValues); 
		System.out.println(d.isEmpty());
		System.out.println(d.size());
		System.out.println(d.deal());
		System.out.println(d.deal());
		System.out.println(d.deal());
		System.out.println(d.deal());
		System.out.println(d.deal());	
		System.out.println(d.deal());
		System.out.println(d.deal());
	}
}
