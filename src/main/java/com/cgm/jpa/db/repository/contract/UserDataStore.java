package com.cgm.jpa.db.repository.contract;

import java.util.List;
import com.cgm.jpa.domain.User;

public interface UserDataStore {

	void storeUser(User user);
	List<User> readUser();
	
}
