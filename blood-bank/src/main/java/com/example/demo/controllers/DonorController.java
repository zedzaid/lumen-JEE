package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Donor;
import com.example.demo.services.DonorService;

import java.util.*;


@RestController
@RequestMapping(path = "/api/v1/donors")
@CrossOrigin(origins = "*")
public class DonorController {
	
	@Autowired
	DonorService service;
	
	
	@GetMapping(path = "")
	public List<Donor> getAllDonors(){
		return this.service.findAll();
	}
	
	@PostMapping(path = "")
	public ResponseEntity<?> addDonor(@RequestBody Donor donor){
		Donor donorObj = this.service.saveDonor(donor);
		return ResponseEntity.ok().body(donorObj);
	}
	
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> DeleteDonor(@PathVariable("id") int id){
		int result = this.service.removeDonor(id);
		String responseBody;
		if(result==1) {
			responseBody="deleted successfully";
			return ResponseEntity.ok().body(responseBody);
		}
		else {
			responseBody="Could not delete the donor";
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseBody);
		}
	}
	
	
	@GetMapping(path = "/group/{donorGroup}")
	public List<Donor> findDonorByGroup(@PathVariable("donorGroup") String donorGroup){
		return this.service.findDonorByGroup(donorGroup);
	}
	
	
	@GetMapping(path = "/location/{location}")
	public List<Donor> findDonorByLocation(@PathVariable("location") String location){
		return this.service.findDonorByLocation(location);
	}

	
	
	@GetMapping(path = "/eligible/{donorGroup}")
	public List<Donor> findEligibleDonors(@PathVariable("donorGroup") String donorGroup){
		return this.service.findEligibleDonors(donorGroup);
	}
	
	
	
	@GetMapping(path = "/exist/{donorId}")
	public Boolean checkDonorIdExist(@PathVariable("donorId") int id){
		return this.service.checkDonorExist(id);
	}
	
	
	@GetMapping(path = "/{donorId}")
	public Optional<Donor> findById(@PathVariable("donorId") int id){
		return this.service.findById(id);
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<?> updateDonor(@RequestBody Donor donor){
		Donor donorObj = this.service.saveDonor(donor);
		return ResponseEntity.ok().body(donorObj);
	}
	
	
	@GetMapping(path = "/camps/{campId}")
	public List<Donor> findByCampId(@PathVariable("campId") int campId){
		return this.service.findByCampId(campId);
	}
	
	
	
	@PutMapping(path = "/camps/register")
	public int registerByCamp(@RequestBody Donor donor){
		return this.service.registerCamp(donor.getDonorId(), donor.getCampId());
	}

}
