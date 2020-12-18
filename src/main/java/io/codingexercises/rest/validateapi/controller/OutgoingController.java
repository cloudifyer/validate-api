package io.codingexercises.rest.validateapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.codingexercises.rest.validateapi.model.Outgoing;
import io.codingexercises.rest.validateapi.repository.OutgoingRepository;
import io.codingexercises.rest.validateapi.util.IncomingValidator;

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
		
		incoming.setFindDuplicates(IncomingValidator.findDuplicates(incoming.getFindDuplicates()));
		incoming.setNumbersMeetNumbers(IncomingValidator.numbersMeetNumbers(incoming.getNumbersMeetNumbers()));
		incoming.setWhiteSpacesGalore(IncomingValidator.whiteSpacesGalore(incoming.getWhiteSpacesGalore()));
		Outgoing outgoing = outgoingRepository.insert(incoming);
		return "Valid data created: " + outgoing.getId();
	}
	
}
