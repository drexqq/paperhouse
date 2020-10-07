package com.bit.paperhouse.dto;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;


/*
    CREATE TABLE USERTABLE2(
  ID VARCHAR2(100) PRIMARY KEY,
  PASSWORD CHAR(60) NOT NULL,
  NAME VARCHAR2(45) NOT NULL,
  AUTHORITY VARCHAR2(50) NOT NULL,
  ENABLED NUMBER(1) NOT NULL  
  )
    
 */

public class UserDto implements Serializable {
	
	private String id;
	private String pwd;
	private String name;
	private String authority;
	private String enabled;
	
	public UserDto() {
		
	}
	
	
	public UserDto(String id, String pwd, String name, String authority) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.authority = authority;
	}
	public UserDto(String id, String pwd, String name, String authority, String enabled) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.authority = authority;
		this.enabled = enabled;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", authority=" + authority + ", enabled="
				+ enabled + "]";
	}
	
	
	
	
}
