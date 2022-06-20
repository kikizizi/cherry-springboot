package com.project.cherry.Service;

import javax.servlet.http.HttpSession;

import com.project.cherry.Dto.userDto;

public interface userService {
	public void signup(userDto dto);
	public boolean checkId(String id);
	public boolean checkPwd(userDto dto,HttpSession session);
}
