import java.util.Arrays;

/*
 * Exercise 1-1
 */
public class Solution {

	public static void main(String[] args) {
		int[] array1 = {1,2,3,4,5};
		int[] array2 = {3,1,4,1,5,9,2,6};

		System.out.println("Case #1: \n");
		showReversedArray(array1);
		Arrays.stream(array1).forEach(System.out::println);

		System.out.println("Case #2: \n");
		showReversedArray(array2);
		Arrays.stream(array2).forEach(System.out::println);
	}
	
	/*
	 * Reverse an array and print it in the standard output
	 * @param a the input array
	 */
	public static void showReversedArray(int[] a) {
		int[] newArr = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			newArr[i] = a[i];
		}

		for (int i = 0; i < a.length; i++) {
			a[i] = newArr[a.length - i - 1];
		}
	}

}
