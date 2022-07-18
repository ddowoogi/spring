package com.spring_boot.projectEx.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_boot.projectEx.model.CartVO;
import com.spring_boot.projectEx.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService cartService;
	
	// 장바구니에 추가 요청 처리
	@RequestMapping("/product/insertCart")
	public String insertCart(CartVO vo, HttpSession session) {
		// 로그인 성공 후 설정한 세션 sid 값이 가져오기
		String memId = (String)session.getAttribute("sid");
		// VO에 memId 값 설정
		vo.setMemId(memId);
		
		// (1) 동일 상품이 존재하는지 확인
		int count = cartService.checkPrdInCart(vo.getPrdNo(), memId);
		
		if(count == 0) { // 동일 상품이 존재하지 않으면
			cartService.insertCart(vo); // (2) 장바구에 새로 추가
		} else { // (3) 존재하면 장바구니에서 해당 상품의 주문수량 변경
			cartService.updateQtyInCart(vo);
		}
		
		return "redirect:/product/cartList"; // 뷰페이지 이름 아님. 
		//포워딩 :  @RequestMapping("/product/cartList") 요청으로 보내는 것
	}
	
	//장바구니 목록 보기 요청 처리
	@RequestMapping("/product/cartList")
	public String cartList(HttpSession session, Model model) {
		// cart 테이블에서 현재 memId에 해당되는 내용만 출력
		String memId = (String)session.getAttribute("sid");
		ArrayList<CartVO> cartList = cartService.cartList(memId);
		model.addAttribute("cartList", cartList);
		
		return "product/cartListView";
	}
}






