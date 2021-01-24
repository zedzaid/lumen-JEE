package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.DonationCamp;
import com.example.demo.entities.Donor;
import com.example.demo.repositories.DonationCampRepository;
import com.example.demo.repositories.DonorRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class BloodBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			DonorRepository repo;
			
			@Autowired
			DonationCampRepository campRepo;
			
			@Override
			public void run(String... args) throws Exception {
				
				DonationCamp campObj = new DonationCamp(0, "undefined", "undefined");
				
				this.campRepo.save(campObj);
				
				this.repo.save(
						new 
						Donor(1,"dummy",24,"male","O+ve","Bilwada","77955",LocalDate.of(1996, 03, 20),0));
				
				
				
			}
		};
	}

}
