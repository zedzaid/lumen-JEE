package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.DonationCamp;
import com.example.demo.services.DonationCampService;

@RestController
@RequestMapping(path = "/api/v1/camps")
@CrossOrigin(origins = "*")
public class DonationCampController {
	
	
	@Autowired
	DonationCampService service;
	
	
	@GetMapping(path = "")
	public List<DonationCamp> getAllCamps(){
		return this.service.findAll();
	}
	
	@PostMapping(path = "")
	public ResponseEntity<?> addCamp(@RequestBody DonationCamp donationCamp){
		DonationCamp campObj = this.service.saveDonationCamp(donationCamp);
		return ResponseEntity.ok().body(campObj);
	}
	
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> DeleteCamp(@PathVariable("id") int id){
		int result = this.service.removeDonationCamp(id);
		String responseBody;
		if(result==1) {
			responseBody="deleted successfully";
			return ResponseEntity.ok().body(responseBody);
		}
		else {
			responseBody="Could not delete the Camp";
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseBody);
		}
	}
	
	@GetMapping(path = "/{campId}")
	public DonationCamp getCampNameById(@PathVariable("campId") int campId){
		return this.service.findCampNameById(campId);
	}

}
