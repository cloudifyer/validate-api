package io.codingexercises.rest.validateapi.controller;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.codingexercises.rest.validateapi.model.Outgoing;
import io.codingexercises.rest.validateapi.repository.OutgoingRepository;

@RestController
public class OutgoingController {

	@Autowired
	public OutgoingRepository outgoingRepository;
	
	@GetMapping(value="/")
	public List<Outgoing> getAllValidData() {
		return outgoingRepository.findAll();
	}
	
	@PostMapping(value="/incoming")
	public String validateAndCreate(@RequestBody Outgoing incoming) {
		if(incoming.getValidateMeOnlyIActuallyShouldBeABoolean().trim().equalsIgnoreCase("true") 
				|| incoming.getValidateMeOnlyIActuallyShouldBeABoolean().trim().equalsIgnoreCase("false"))
			incoming.setValidateMeOnlyIActuallyShouldBeABoolean("true");
		else
			incoming.setValidateMeOnlyIActuallyShouldBeABoolean("false");
		
		incoming.setFindDuplicates(findDuplicates(incoming.getFindDuplicates()));
		incoming.setNumbersMeetNumbers(numbersMeetNumbers(incoming.getNumbersMeetNumbers()));
		incoming.setWhiteSpacesGalore(whiteSpacesGalore(incoming.getWhiteSpacesGalore()));
		Outgoing outgoing = outgoingRepository.insert(incoming);
		return "Valid data created: " + outgoing.getId();
	}
	
	private String findDuplicates(String findDuplicates) {
		List<Character> findDuplicatesList = findDuplicates.chars()
			    .mapToObj(e->(char)e).collect(Collectors.toList());
		Set<Character> uniques = new HashSet<>();
//		List<Character> duplicates = new ArrayList<>();
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
		return duplicateString;
	}
	
	private int[] numbersMeetNumbers(int[] numbersMeetNumbers) {
		int max[]= {0};
		for(int i = 0; i < numbersMeetNumbers.length; i++) {
			if (numbersMeetNumbers[i] > max[0])
				max[0] = numbersMeetNumbers[i];
		}
		return max;
	}
	
	private String whiteSpacesGalore(String whiteSpacesGalore) {
		String[] incomingWithoutSpacesArray = whiteSpacesGalore.split("\\s+");
		String incomingWithoutSpaces="";
		for(int i = 0; i < incomingWithoutSpacesArray.length; i++)
			incomingWithoutSpaces += incomingWithoutSpacesArray[i];
		
		return incomingWithoutSpaces;
	}
}
