package com.project.cherry.Dao;

import java.util.List;

import com.project.cherry.Dto.chatListDto;
import com.project.cherry.Dto.chatLogDto;

public interface chatDao {
	public void uploadChatLog(chatLogDto dto);
	public int roomListCheck(String roomId);
	public void createRoom(chatLogDto dto);
	public void updateRoom(chatLogDto dto);
	public List<chatListDto> getRoomList(String id);
	public List<chatLogDto> getChatLog(String roomId);
	public void resetIsRead(String roomId);
}
