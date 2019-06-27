package spring.beans.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.beans.annotation.respository.UserRespository;

@Service
public class UserService {
	
	@Autowired
	private UserRespository userRespository;
	public void add() {
		System.out.println("UserService add");
		userRespository.save();
	}
}
