package com.example.SoftwareManagement.SoftwareInterface;


import java.util.List;

import com.example.SoftwareManagement.Softwaremodel.User;

public interface UserService {
	public void addUser(User obj);
	public List<User> findBookedUsersBySoftwareId(long softwareId);
}