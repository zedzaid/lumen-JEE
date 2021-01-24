package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.DonationCamp;

@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp, Integer> {

	List<DonationCamp> findByLocation(String location);
	
	@Query(value = "select * from donation_camp where campId=:campId",nativeQuery = true)
	DonationCamp findCampById(@Param("campId") int campId);
}
