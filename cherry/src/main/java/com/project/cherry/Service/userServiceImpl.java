package com.project.cherry.Service;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;


import com.project.cherry.Dao.chatDao;
import com.project.cherry.Dao.userDao;
import com.project.cherry.Dto.chatLogDto;
import com.project.cherry.Dto.userDto;


@Repository
public class userServiceImpl implements userService{
	@Autowired
	private userDao dao;
	@Autowired
	private chatDao dao2;
	@Override
	public void signup(userDto dto) {
		String pwd= dto.getPwd();
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPwd=encoder.encode(pwd);
		dto.setPwd(encodedPwd);
		chatLogDto chatDto=new chatLogDto();
		chatDto.setListener(dto.getId());
		chatDto.setTalker("정동욱");
		String ida[]= {"정동욱",dto.getId()};
		Arrays.sort(ida);
		String roomId=String.join("_", ida);
		chatDto.setRoomId(roomId);
		chatDto.setText("방문해 주셔서 감사합니다. ^^");
		chatDto.setRegdate(System.currentTimeMillis());
		dao.signup(dto);
		dao2.createRoom(chatDto);
		dao2.uploadChatLog(chatDto);
	}

	@Override
	public boolean checkId(String id) {
		userDto userData=dao.userData(id);
		if (userData==null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPwd(userDto dto,HttpSession session) {
		userDto userData=dao.userData(dto.getId());
		if (userData==null) {
			return false;
		}
		String encodedPwd=userData.getPwd();
		String pwd=dto.getPwd();
		boolean pwdMatch=BCrypt.checkpw(pwd, encodedPwd);
		if (pwdMatch) {
			session.setAttribute("id",dto.getId());
			return true;
		}
		return false;
	}
	
}
