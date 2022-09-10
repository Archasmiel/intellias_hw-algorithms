package net.archasmiel.util;

import net.archasmiel.model.Person;
import net.archasmiel.sort.PersonSort;

import java.util.Comparator;
import java.util.function.Function;

public class SortTestHelper {

	/**
	 * Performs sorting algorithm with given comparator
	 * @param array array of persons
	 * @param comparator comparator for sorting
	 * @param sortAlgo sorting algorithm
	 */
	public static void doSort(Person[] array, Comparator<Person> comparator, PersonSort sortAlgo) {
		long startTime = System.currentTimeMillis();
		sortAlgo.sort(array, comparator);
		System.out.printf("Array of %d users sorted by '%s' in %fs%n", array.length, sortAlgo.getName(), (System.currentTimeMillis() - startTime)/1000f);
	}

	/**
	 * @param array array of persons
	 * @param functions functions to object fields (for comparator usually) in right order
	 * @return stylish string with all elements based on given functions
	 */
	public static String arrayToString(Person[] array, Function<Person, Integer>... functions) {
		StringBuilder builder = new StringBuilder("[");
		for (Person person: array) {
			builder.append("{");
			for (Function<Person, Integer> function: functions) {
				builder.append(function.apply(person)).append(",");
			}
			builder.deleteCharAt(builder.length()-1).append("}, ");
		}
		return builder.substring(0, builder.length()-2) + "]";
	}

}
