package spring.beans.generic.di;

import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {

	@Override
	public String toString() {
		return "UserService [repository=" + repository + "]";
	}

	

}
