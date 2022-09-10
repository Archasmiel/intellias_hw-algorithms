package net.archasmiel.sort;

import net.archasmiel.model.Person;

import java.util.Comparator;

/**
 * BubbleSort algorithm
 */
public class BubbleSort implements PersonSort {

	public static final String NAME = "BubbleSort";

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void sort(Person[] people, Comparator<Person> comparator) {
		for (int i = 0 ; i < people.length-1 ; i++) {
			for (int j = 0 ; j < people.length-i-1 ; j++) {
				if (comparator.compare(people[j+1], people[j]) < 0) {
					swap(people, j, j+1);
				}
			}
		}
	}

	private void swap(Person[] people, int i, int j) {
		Person temp = people[i];
		people[i] = people[j];
		people[j] = temp;
	}

}
