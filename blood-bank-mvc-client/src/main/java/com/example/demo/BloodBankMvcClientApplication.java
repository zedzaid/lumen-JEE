package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.DonationCamp;
import com.example.demo.entities.Donor;

@SpringBootApplication
@EnableDiscoveryClient
public class BloodBankMvcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankMvcClientApplication.class, args);
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	@Bean
	public ModelAndView modelView() {
		return new ModelAndView();
	}
	
	
	@Bean
	public Donor donor() {
		return new Donor();
	}
	
	@Bean
	public DonationCamp camp() {
		return new DonationCamp();
	}

}
