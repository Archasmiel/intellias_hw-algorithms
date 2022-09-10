package net.archasmiel.sort;

import net.archasmiel.model.Person;

import java.util.Comparator;

/**
 * Interface for sorting algorithms
 */
public interface PersonSort {
	String getName();
	void sort(Person[] people, Comparator<Person> comparator);
}
