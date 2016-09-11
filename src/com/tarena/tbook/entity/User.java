package com.tarena.tbook.entity;

/**
 * Created by hanamingming on 16/3/4.
 */
public class User {

	private int id;
	private String email;
	private boolean emailVerify;
	private String emailVerifyCode;
	private String lastLoginIp;
	private long lastLoginTime;
	private String nickname;
	private String password;
	private int userIntegral;


	public User() {
	}

	public User(int id, String email, boolean emailVerify, String emailVerifyCode, String lastLoginIp, int lastLoginTime, String nickname, String password) {
		this.id = id;
		this.email = email;
		this.emailVerify = emailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginIp = lastLoginIp;
		this.lastLoginTime = lastLoginTime;
		this.nickname = nickname;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmailVerify() {
		return emailVerify;
	}

	public void setEmailVerify(boolean emailVerify) {
		this.emailVerify = emailVerify;
	}

	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}
}
