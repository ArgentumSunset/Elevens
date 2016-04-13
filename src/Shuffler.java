/**
 * This class provides a convenient way to test shuffling methods.
 */

public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();
		

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Results of flip(): " + flip());
		System.out.println();
		int[] arr1 = {1,2,3};
		int[] arr2 = {3,1,2};
		int[] arr3 = {1,4,3};
		int[] arr4 = {1,2,3,4,5};
		int[] arr5 = {5,3,4,1,2};
		int[] arr6 = {6,3,4,1,2,18,44,2,2,3};
		int[] arr7 = {2,44,6,2,3,3,1,18,2,4};
		int[] arr8 = {1,1};
		int[] arr9 = {2,44,6,2,3,4,1,18,2,4};
		System.out.println("This should be true: " + arePermutations(arr1, arr2));
		System.out.println("This should be false: " + arePermutations(arr1, arr3));
		System.out.println("This should be true: " + arePermutations(arr4, arr5));
		System.out.println("This should be true: " + arePermutations(arr5, arr4));
		System.out.println("This should be true: " + arePermutations(arr6, arr7));
		System.out.println("This should be false: " + arePermutations(arr4, arr6));
		System.out.println("This should be false: " + arePermutations(arr6, arr9));
		System.out.println("This should be false: " + arePermutations(arr1, arr8));
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int[] vals = new int[values.length];
		for(int i = 0; i < values.length; i ++) { vals[i] = values[i]; }
		int k = 0;
		int l = 1;
		for (int j = 0; j < (vals.length + 1) / 2; j++) {
			values[k] = vals[j];
			k += 2;
		}
		for (int j = (vals.length + 1) / 2; j < vals.length; j++) {
			values[l] = vals[j];
			l += 2;
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		for(int k = values.length - 1; k >= 0; k--) {
			int r = (int) Math.floor(Math.random() * values.length);
			int x = values[k];
			values[k] = values[r];
			values[r] = x;
		}
	}
	
	public static String flip() {
		int r = (int) Math.floor(Math.random() * 3); 
		return (r == 0 || r == 1) ? "heads" : "tails";
	}
	
	public static boolean arePermutations(int[] arr1, int[] arr2) {
		if(arr1.length == arr2.length) {
			arr1 = selectionSort(arr1);
			arr2 = selectionSort(arr2);
			for(int i = 0; i < arr1.length; i++) {
				if(arr1[i] != arr2[i]) return false;
			}
		}
		return true;
	}
	
	public static int[] selectionSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int iMin = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] <= arr[iMin]) {
					iMin = j;
				}
			}
			int x = arr[iMin];
			arr[iMin] = arr[i];
			arr[i] = x;
		}
		return arr;
	}
}
