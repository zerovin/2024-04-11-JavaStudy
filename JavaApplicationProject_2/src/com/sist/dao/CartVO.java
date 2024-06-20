package com.sist.dao;
/*
 CNO                                       NOT NULL NUMBER
 ID                                                 VARCHAR2(20)
 GNO                                                NUMBER
 ACCOUNT                                            NUMBER
 PRICE                                              NUMBER
 REGDATE                                            DATE 
 */
import java.util.*; //자바<=>오라클 - 데이터를 모아서 관리, 송수신
import lombok.Data;
// VO = DTO : Data Transfer Object;
public class CartVO {
	private int cno, gno, price, account;
	private String id;
	private Date regdate;
	private GoodsVO gvo=new GoodsVO();
	//조인, 서브쿼리 => 해당 VO를 포함
	//VO는 반드시 테이블 한개만 연결
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public GoodsVO getGvo() {
		return gvo;
	}
	public void setGvo(GoodsVO gvo) {
		this.gvo = gvo;
	}
	
}
