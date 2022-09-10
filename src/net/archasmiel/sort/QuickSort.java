package net.archasmiel.sort;

import net.archasmiel.model.Person;

import java.util.Comparator;

/**
 * QuickSort algorithm
 */
public class QuickSort implements PersonSort {

	public static final String NAME = "QuickSort";

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void sort(Person[] people, Comparator<Person> comparator) {
		recursion(people, 0, people.length-1, comparator);
	}

	private void recursion(Person[] array, int low, int high, Comparator<Person> comparator) {
		if (low >= high) return;

		int mid = low + (high - low) / 2;
		Person main = array[mid];

		int i = low;
		int j = high;
		while (i <= j) {
			while (comparator.compare(array[i], main) < 0) i++;
			while (comparator.compare(array[j], main) > 0) j--;
			if (i <= j) swap(array, i++, j--);
		}

		if (low < j) recursion(array, low, j, comparator);
		if (high > i) recursion(array, i, high, comparator);
	}

	private void swap(Person[] people, int i, int j) {
		Person temp = people[i];
		people[i] = people[j];
		people[j] = temp;
	}

}
