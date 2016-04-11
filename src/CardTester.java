/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card queenOfSpades = new Card("Queen", "Spades", 5);
		Card kingOfHearts = new Card("King", "Hearts", 6);
		Card tenOfClover = new Card("ten", "Clover", 3);
		System.out.println(queenOfSpades.suit());
		System.out.println(queenOfSpades.toString());
		System.out.println(queenOfSpades.pointValue());
		System.out.println(kingOfHearts.toString());
	}
}
