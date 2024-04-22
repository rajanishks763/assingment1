package com.assignment.dto;

public class UserDto {

    private String loginId;
    private String password;
    public UserDto( String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}
	public UserDto() {
		super();
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDto [ loginId=" + loginId + ", password=" + password + "]";
	}
}
