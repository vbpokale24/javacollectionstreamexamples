

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/**
 * 
 * @author Vaibhav53
 * @Description - This program can be used to find the duplicates from the arraylist
 */
public class FIndDuplicates {
/**
 * 
 * @param args
 * Main method with no arguments
 */
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(new Integer[]{1,2,1,3,4,4}); 
		numbers.stream().filter(i -> Collections.frequency(numbers, i) >1)
        .collect(Collectors.toSet()).forEach(System.out::println);
	}
}
