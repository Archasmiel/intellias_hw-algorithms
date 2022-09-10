package net.archasmiel.util;

import net.archasmiel.model.Person;
import net.archasmiel.sort.PersonSort;

import java.util.Comparator;
import java.util.function.Function;

public class Task2Algorithm {


	/**
	 * @param userCount count of needed users
	 * @param function function in object person
	 * @param sort sorting algorithm {link }
	 */
	public static void processSort(int userCount, Function<Person, Integer> function, PersonSort sort) {
		Person[] array = GenerationHelper.getArray(userCount);
		if (array.length < 1000) {
			System.out.println("Unsorted array: " + SortTestHelper.arrayToString(array, function));
		}
		SortTestHelper.doSort(array, Comparator.comparing(function), sort);
		if (array.length < 1000) {
			System.out.println("Sorted array: " + SortTestHelper.arrayToString(array, function));
		}
		System.out.println();
	}

}

