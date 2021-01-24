package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lumen_donors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donor {
	
	@Id
	int donorId;
	String donorName;
	int donorAge;
	String donorGender;
	String donorGroup;
	String location;
	String mobileNumber;
	LocalDate lastDonatedDate;
	
	int campId;
	
	
	

}
