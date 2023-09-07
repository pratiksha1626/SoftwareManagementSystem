package com.example.SoftwareManagement.SoftwareRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SoftwareManagement.Softwaremodel.Software;



/**
 * The SoftwareRepository interface is a Spring Data JPA repository that provides
 * database access and CRUD operations for the Software entity.
 */

@Repository
public interface SoftwareRepository extends JpaRepository<Software, Integer> {
	
	List< Software> findBySoftwareNameContainingIgnoreCase(String softwareName);

	List<Software> findByIsDesktopApplication(boolean status);

	Iterable<Software> findByDeveloperContainingIgnoreCase(String developerName);
	
	

	

	
	


}



