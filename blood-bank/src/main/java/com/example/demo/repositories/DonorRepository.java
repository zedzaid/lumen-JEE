package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {

	//@Query(value = "select * from lumen_donors where donorGroup=:donorGroup", nativeQuery = true)
	List<Donor> findByDonorGroup(String donorGroup);
	
	List<Donor> findByLocation(String location);
	
	List<Donor> findBycampId(int campId);
	
	
	@Query(value = "SELECT * from lumen_donors where TIMESTAMPDIFF(MONTH, lastDonatedDate, :presentDate)>=6 and donorGroup=:donorGroup",nativeQuery = true)
	List<Donor> findEligibleDonors(@Param("presentDate") LocalDate presentDate,@Param("donorGroup") String donorGroup);
	
	
	@Query(value = "update lumen_donors set campId=:campId where donorId=:donorId",nativeQuery = true)
	@Modifying
	@Transactional
	int registerDonorWithCamp(@PathParam("donorId")int donorId,@PathParam("campId") int campId);
}
