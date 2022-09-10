package net.archasmiel.util;

import net.archasmiel.model.Person;
import net.archasmiel.sort.PersonSort;

import java.util.*;

public class Task3Algorithm {

	/**
	 * @param userCount count of users
	 * @param sort sort algorithm
	 * @return number of weight sections unique heights (no repeats in weight and height)
	 */
	public static int processData(int userCount, PersonSort sort) {
		Person[] array = GenerationHelper.getArray(userCount);

		if (array.length < 1000) {
			System.out.println("Unsorted array: " + SortTestHelper.arrayToString(array, Person::getWeight, Person::getHeight));
		}
		SortTestHelper.doSort(array, Comparator.comparing(Person::getWeight), sort);
		if (array.length < 1000) {
			System.out.println("Sorted array: " + SortTestHelper.arrayToString(array, Person::getWeight, Person::getHeight));
		}

		return cUHIWS(array);
	}

	/**
	 * cUHIWS - count UniqueHeights In WeightSections
	 * @return number of weight sections unique heights (no repeats in weight and height)
	 */
	private static int cUHIWS(Person[] array) {
		// for every 'weight section' we're gonna process diff heights count
		// if count == 1 we count this height as unique value
		// it counts as unique person in task 3
		List<Integer> curHCount = new ArrayList<>();
		int curW = array[0].getWeight();
		int counter = 0;

		for (int i = 0 ; i < array.length ; i++) {
			int weight = array[i].getWeight();
			int height = array[i].getHeight();

			curHCount.add(height);
			if (curW == weight && i != array.length-1) continue;

			// adding unique persons to counter
			counter += curHCount.stream().distinct().count();

			// if we have different weight we must clear map and set new value
			curHCount.clear();
			curW = weight;
		}

		return counter;
	}

}
