package com.example.SoftwareManagement.SoftwareRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SoftwareManagement.Softwaremodel.User;



	@Repository
	public interface UserRepository extends JpaRepository<User, Long>{

		@Query(value = "SELECT * FROM User_table p WHERE p.software_id = ?1",nativeQuery = true  )
		public List<User> findBookedUsersBySoftwareId(long softwareId);
	}