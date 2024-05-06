package interviewpractice;

import java.util.*;

public class StreamAPIParallelSumTest {

	public static long factorial(long number) {
		long result = 1;

		for (int factor = 2; factor <= number; factor++) {
			result *= factor;
		}

		return result;
	}

	public static void main(String args[]) {

		List<Long> numbers = new ArrayList<Long>();
		numbers.add(4L);
		numbers.add(5L);

		Long sum = numbers.stream().parallel().map((val) -> factorial(val)).parallel().reduce(0L, (a, b) -> a + b);
		// Long sum = numbers.stream().parallel().mapToLong((val) ->
		// factorial(val)).sum();
		// Long sum = numbers.stream().parallel().mapToLong((val) ->
		// factorial(val)).parallel().sum();

		System.out.println(sum);

	}

}
