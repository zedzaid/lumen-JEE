package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Donor;
import com.example.demo.repositories.DonorRepository;

@Service
public class DonorService {
	
	@Autowired
	DonorRepository repo;
	
	
	public List<Donor> findAll(){
		return this.repo.findAll();
	}
	
	
	
	public Donor saveDonor(Donor donor) {
		
		return this.repo.save(donor);
	}
	
	
	public int removeDonor(Integer id) {
		int result = 0;
		if(this.repo.existsById(id)) {
			result=1;
			this.repo.deleteById(id);
		}
		return result;
	}
	
	public List<Donor> findDonorByGroup(String donorGroup){
		
		return this.repo.findByDonorGroup(donorGroup);
	}
	
	
	public List<Donor> findDonorByLocation(String location){
		
		return this.repo.findByLocation(location);
	}
	
	
	public List<Donor> findEligibleDonors(String donorGroup){
		return this.repo.findEligibleDonors(LocalDate.now(),donorGroup);
	}



	public boolean checkDonorExist(int id) {
		boolean isDonorExist=false;
		if(this.repo.existsById(id)) {
			isDonorExist = true;
		}
		return isDonorExist;
	}
	
	
	public Optional<Donor> findById(int id) {
		return this.repo.findById(id);
	}
	
	
	public List<Donor> findByCampId(int campId){
		return this.repo.findBycampId(campId);
	}
	
	
	public int registerCamp(int donorId,int campId){
		return this.repo.registerDonorWithCamp(donorId, campId);
	}

}
