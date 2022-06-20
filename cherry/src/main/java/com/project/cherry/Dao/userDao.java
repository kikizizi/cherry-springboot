package com.project.cherry.Dao;

import com.project.cherry.Dto.userDto;

public interface userDao {
	public void signup(userDto dto);
	public userDto userData(String id);
}
