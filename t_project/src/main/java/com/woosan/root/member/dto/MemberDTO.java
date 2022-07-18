package com.woosan.root.member.dto;

import java.util.Date;

public class MemberDTO {
	private String id, pw, addr, name, email, prf_addr, 
			gender, phNum, auto_cookie, per_cate, session_id;

	
	private int age, rpt;
	
	private java.sql.Date limit_time;
	
	public java.sql.Date getLimit_time() {
		return limit_time;
	}
	public void setLimit_time(java.sql.Date limit_time) {
		this.limit_time = limit_time;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPrf_addr() {
		return prf_addr;
	}
	public void setPrf_addr(String prf_addr) {
		this.prf_addr = prf_addr;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	public String getAuto_cookie() {
		return auto_cookie;
	}
	public void setAuto_cookie(String auto_cookie) {
		this.auto_cookie = auto_cookie;
	}
	public String getPer_cate() {
		return per_cate;
	}
	public void setPer_cate(String per_cate) {
		this.per_cate = per_cate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRpt() {
		return rpt;
	}
	public void setRpt(int rpt) {
		this.rpt = rpt;
	}
	
	
}
