package com.project.cherry.Service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.cherry.Dto.productsDto;

public interface productsService {
	public void addProduct(productsDto dto,HttpServletRequest req);
	public HashMap<String, Object> getProductList(String category,int num,String search);
	public void getDetail(HttpServletRequest req,HttpSession session);
	public void conWish(HttpServletRequest req);
	public HashMap<String, Object> getMyProduct(productsDto dto);
	public HashMap<String, Object> getMyWish(productsDto dto);
	public void salesCompleted(int num);
	public void delProduct(int num);
}
