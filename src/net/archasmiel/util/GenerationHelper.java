package net.archasmiel.util;

import net.archasmiel.model.Person;

import java.util.Random;

public class GenerationHelper {

	public static final Random random = new Random();

	/**
	 * Generates pseudorandom array of users with given size
	 * @param count number of users in output array
	 * @return output array
	 */
	public static Person[] getArray(int count) {
		long startTime = System.currentTimeMillis();
		Person[] res = new Person[count];

		for (int i = 0 ; i < count ; i++) {
			res[i] = new Person(
				random.nextInt(100, 230),
				random.nextInt(50, 200),
				random.nextInt(0, 200)
			);
		}

		System.out.printf("Generated array of %d users in %f seconds%n", count, (System.currentTimeMillis() - startTime)/1000f);
		return res;
	}
}
