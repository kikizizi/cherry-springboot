package com.project.cherry.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.project.cherry.Dto.chatLogDto;

public interface chatService {
	public void uploadChatLog(chatLogDto dto);
	public void getRoomList(HttpSession session,ModelAndView mView);
	public List<chatLogDto> getChatLog(String roomId);
	public void resetIsRead(String roomId);
	public void getNoRead(HttpSession session,HttpServletRequest req);
}
