package spring.beans.annotation.respository;

import org.springframework.stereotype.Repository;

import spring.beans.annotation.controller.UserController;

@Repository("userRespository")
public class UserRespositoryImpl implements UserRespository {

	
	public void save() {
		System.out.println("UserRespository save...");
	}

}
