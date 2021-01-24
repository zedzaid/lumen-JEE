package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "donation_camp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationCamp {
	
	@Id
	int campId;
	String name;
	String location;

}
