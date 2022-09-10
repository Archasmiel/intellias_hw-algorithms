package net.archasmiel;

import net.archasmiel.model.Person;
import net.archasmiel.sort.BubbleSort;
import net.archasmiel.sort.PersonSort;
import net.archasmiel.sort.QuickSort;
import net.archasmiel.util.Task2Algorithm;
import net.archasmiel.util.Task3Algorithm;

public class Main {

	public static final int MAX_SIZE = 100_000;

	public static void main(String[] args) {
		task1();
	}

	/** Quicksort complexity - O(n*logn)
	 * Bubblesort complexity - O(n^2)
	*/
	private static void task1() {
		PersonSort sort;

		// quicksort - sorting by age
		sort = new QuickSort();
		for (int i = 10; i <= MAX_SIZE; i *= 10) {
			Task2Algorithm.processSort(i, Person::getAge, sort);
		}
		System.out.println("\n-----------------------------");

		// bubblesort - sorting by age
		sort = new BubbleSort();
		for (int i = 10; i <= MAX_SIZE; i *= 10) {
			Task2Algorithm.processSort(i, Person::getAge, sort);
		}
		System.out.println("\n-----------------------------");
	}


	/** Quicksort complexity - O(n*logn)
	 */
	private static void task2() {
		PersonSort sort;

		// quicksort - sorting by height
		sort = new QuickSort();
		for (int i = 10; i <= MAX_SIZE; i *= 10) {
			Task2Algorithm.processSort(i, Person::getHeight, sort);
		}
		System.out.println("\n-----------------------------");

		// quicksort - sorting by weight
		for (int i = 10; i <= MAX_SIZE; i *= 10) {
			Task2Algorithm.processSort(i, Person::getWeight, sort);
		}
		System.out.println("\n-----------------------------");
	}

	/**    Complexity -      O(n*logn) (quicksort) + O(n) (values search in heights)
	  *    Total      -      O((n+1)*logn)
	  */
	private static void task3() {
		PersonSort sort;

		// quicksort - number of elements with identical weight but different height
		sort = new QuickSort();
		for (int i = 10; i <= MAX_SIZE; i *= 10) {
			int result = Task3Algorithm.processData(i, sort);
			System.out.printf("Unique values in array: %d%n%n", result);
		}
	}

	/**  Питання: У завданні 1 чи можна забезпечити лінійну складність алгоритму по часу?
	  *  Відповідь: можна забезпечити лінійну, наприклад за допомогою radixsort O(a*(n+b)) = O(n)
	  */
	private static void answer() {
		// Just answer for task's additional question
	}

}
