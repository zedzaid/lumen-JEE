package com.example.demo.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donor {
	
	int donorId;
	String donorName;
	int donorAge;
	String donorGender;
	String donorGroup;
	String location;
	String mobileNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate lastDonatedDate;
	int campId;
	

}
