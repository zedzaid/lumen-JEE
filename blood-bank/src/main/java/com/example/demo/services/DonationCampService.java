package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.DonationCamp;
import com.example.demo.repositories.DonationCampRepository;

@Service
public class DonationCampService {
	
	@Autowired
	DonationCampRepository repo;
	
	
	public List<DonationCamp> findAll(){
		return this.repo.findAll();
	}
	
	
	
	public DonationCamp saveDonationCamp(DonationCamp donationCamp) {
		
		return this.repo.save(donationCamp);
	}
	
	
	public int removeDonationCamp(Integer id) {
		int result = 0;
		if(this.repo.existsById(id)) {
			result=1;
			this.repo.deleteById(id);
		}
		return result;
	}
	
	
	
	
	public List<DonationCamp> findCampByLocation(String location){
		
		return this.repo.findByLocation(location);
	}
	
	
	
	public DonationCamp findCampNameById(int campId){
		
		return this.repo.findCampById(campId);
	}
	
	

}
