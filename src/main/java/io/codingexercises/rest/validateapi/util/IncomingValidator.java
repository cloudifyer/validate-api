package io.codingexercises.rest.validateapi.util;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IncomingValidator {
	public static String findDuplicates(String stringWithDuplicates) {
		List<Character> findDuplicatesList = stringWithDuplicates.chars()
			    .mapToObj(e->(char)e).collect(Collectors.toList());
		Set<Character> uniques = new HashSet<>();
		Set<Character> duplicates = new LinkedHashSet<>();
		for(Character c : findDuplicatesList) {
			if(!uniques.add(c)) {
	            duplicates.add(c);
	        }
		}
		
		String duplicateString = "";
		for (Character c : duplicates)
		{
			duplicateString += c + "\t";
		}
		return duplicateString.trim();
	}
	
	public static int[] numbersMeetNumbers(int[] intArray) {
		int max[]= {0};
		for(int i = 0; i < intArray.length; i++) {
			if (intArray[i] > max[0])
				max[0] = intArray[i];
		}
		return max;
	}
	
	public static String whiteSpacesGalore(String stringWithSpaces) {
		String[] incomingWithoutSpacesArray = stringWithSpaces.split("\\s+");
		String incomingWithoutSpaces="";
		for(int i = 0; i < incomingWithoutSpacesArray.length; i++)
			incomingWithoutSpaces += incomingWithoutSpacesArray[i];
		
		return incomingWithoutSpaces;
	}

}
