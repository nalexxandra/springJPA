package com.cgm.jpa.db.repository.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.cgm.jpa.domain.User;


public class UserResultSetExtractor implements ResultSetExtractor<User>{

	@Override
	public User extractData(ResultSet rs) throws SQLException {
		User cashDrawer = new User();
		cashDrawer.setUsername(rs.getString("username"));
		return cashDrawer;
	}

	
}
