package com.example.SoftwareManagement.SoftwareServive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SoftwareManagement.SoftwareInterface.UserService;
import com.example.SoftwareManagement.SoftwareRepository.UserRepository;
import com.example.SoftwareManagement.Softwaremodel.User;



@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	public void addUser(User obj) {
		
		this.userRepo.save(obj);
	}
	
	public List<User> findBookedUsersBySoftwareId(long softwareId) {
		
		return this.userRepo.findBookedUsersBySoftwareId(softwareId);
	}

	

}