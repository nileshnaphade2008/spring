package com.nilesh.poc.laundry.dao;

import com.nilesh.poc.laundry.exception.LaundryException;
import com.nilesh.poc.laundry.pojos.User;

public interface IUserDao {
	User auntheticateUser(String email, String pwd) throws LaundryException;
    String register(User u) throws LaundryException;
}
