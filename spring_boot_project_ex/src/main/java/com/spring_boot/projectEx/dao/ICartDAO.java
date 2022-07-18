package com.spring_boot.projectEx.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot.projectEx.model.CartVO;

public interface ICartDAO {
	void insertCart(CartVO vo);  // 장바구니에 추가
	int checkPrdInCart(HashMap<String, Object> map);  // 동일 삼품 존재 여부 확인
	void updateQtyInCart(CartVO vo);  // 동일 상품이 존재하는 경우 수량만 변경
	ArrayList<CartVO> cartList(String memId);
	void deleteCart(String cartNo); // 장바구니에서 cartNo에 해당되는 것 삭제
}
