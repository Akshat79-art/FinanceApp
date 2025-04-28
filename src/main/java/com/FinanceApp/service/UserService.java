package com.FinanceApp.service;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.FinanceApp.model.User;
import com.FinanceApp.repository.UserRepository;

public class UserService {

	private UserRepository userRepository; 
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public void saveUser(HashMap<String, String> userDetails) throws Exception{
		User newUser = new User();
		for(Map.Entry<String, String> map: userDetails.entrySet()) {
			PropertyDescriptor pd = new PropertyDescriptor(map.getKey(), newUser.getClass());
			pd.getWriteMethod().invoke(newUser, map.getValue());
		}
		userRepository.save(newUser);
	}
	
	public void updateUserDetails(String email, HashMap<String, String> userDetails) throws Exception{
		User user = this.getUserByEmail(email);
		for(Map.Entry<String, String> map: userDetails.entrySet()) {
			PropertyDescriptor pd = new PropertyDescriptor(map.getKey(), user.getClass());
			pd.getWriteMethod().invoke(user, map.getValue());
		}
		userRepository.save(user);
	}
	
	public void updateEmail(String oldEmail, String newEmail) {}
	
	public void updatePassword(String oldEmail, String newPassword) {}
	
	public void deleteUser(String email) {
		User userToDelete = this.getUserByEmail(email);
		userRepository.delete(userToDelete);
	}
}
