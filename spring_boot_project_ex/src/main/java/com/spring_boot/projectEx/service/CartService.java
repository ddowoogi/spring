package com.spring_boot.projectEx.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dao.ICartDAO;
import com.spring_boot.projectEx.model.CartVO;

@Service
public class CartService implements ICartService {
	@Autowired
	@Qualifier("ICartDAO")
	ICartDAO dao;

	@Override
	public void insertCart(CartVO vo) {
		dao.insertCart(vo);
	}

	@Override
	public int checkPrdInCart(String prdNo, String memId) {
		// 전달 받은 prdNo와 memId를 mapper에게 전달하는데
		// 매개변수가 2개 이상인 경우에는 HashMap으로 전달해야 함
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("prdNo", prdNo);
		map.put("memId", memId);
		
		return dao.checkPrdInCart(map);
	}

	@Override
	public void updateQtyInCart(CartVO vo) {
		dao.updateQtyInCart(vo);
	}

	@Override
	public ArrayList<CartVO> cartList(String memId) {
		return dao.cartList(memId);
	}

	@Override
	public void deleteCart(String cartNo) {
		// TODO Auto-generated method stub

	}

}
