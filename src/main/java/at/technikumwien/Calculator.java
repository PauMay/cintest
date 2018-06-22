package at.technikumwien;

import java.util.Arrays;

public class Calculator {
	public int sum(int... numbers) {
		if (numbers == null) {
			return 0;
		}
		
		return Arrays.stream(numbers).sum();
	}
}