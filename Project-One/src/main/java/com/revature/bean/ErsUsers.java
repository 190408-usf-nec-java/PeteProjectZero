package com.revature.bean;

public class ErsUsers {
	
	private int ERS_USERS_ID;
	private String ERS_USERNAME;
	private String ERS_PASSWORD;
	private String ERS_FIRST_NAME;
	private String ERS_LAST_NAME;
	private String USER_EMAIL;
	private int USER_ROLE_ID;
	
	
	public int getERS_USERS_ID() {
		return ERS_USERS_ID;
	}
	public void setERS_USERS_ID(int ERS_USERS_ID) {
		this.ERS_USERS_ID = ERS_USERS_ID;
	}
	public String getERS_USERNAME() {
		return ERS_USERNAME;
	}
	public void setERS_USERNAME(String ERS_USERNAME) {
		this.ERS_USERNAME = ERS_USERNAME;
	}
	public String getERS_PASSWORD() {
		return ERS_PASSWORD;
	}
	public void setERS_PASSWORD(String ERS_PASSWORD) {
		this.ERS_PASSWORD = ERS_PASSWORD;
	}
	public String getERS_FIRST_NAME() {
		return ERS_FIRST_NAME;
	}
	public void setERS_FIRST_NAME(String ERS_FIRST_NAME) {
		this.ERS_FIRST_NAME = ERS_FIRST_NAME;
	}
	public String getERS_LAST_NAME() {
		return ERS_LAST_NAME;
	}
	public void setERS_LAST_NAME(String ERS_LAST_NAME) {
		this.ERS_LAST_NAME = ERS_LAST_NAME;
	}
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String USER_EMAIL) {
		this.USER_EMAIL = USER_EMAIL;
	}
	public int getUSER_ROLE_ID() {
		return USER_ROLE_ID;
	}
	public void setUSER_ROLE_ID(int USER_ROLE_ID) {
		this.USER_ROLE_ID = USER_ROLE_ID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ERS_FIRST_NAME == null) ? 0 : ERS_FIRST_NAME.hashCode());
		result = prime * result + ((ERS_LAST_NAME == null) ? 0 : ERS_LAST_NAME.hashCode());
		result = prime * result + ((ERS_PASSWORD == null) ? 0 : ERS_PASSWORD.hashCode());
		result = prime * result + ((ERS_USERNAME == null) ? 0 : ERS_USERNAME.hashCode());
		result = prime * result + ERS_USERS_ID;
		result = prime * result + ((USER_EMAIL == null) ? 0 : USER_EMAIL.hashCode());
		result = prime * result + USER_ROLE_ID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErsUsers other = (ErsUsers) obj;
		if (ERS_FIRST_NAME == null) {
			if (other.ERS_FIRST_NAME != null)
				return false;
		} else if (!ERS_FIRST_NAME.equals(other.ERS_FIRST_NAME))
			return false;
		if (ERS_LAST_NAME == null) {
			if (other.ERS_LAST_NAME != null)
				return false;
		} else if (!ERS_LAST_NAME.equals(other.ERS_LAST_NAME))
			return false;
		if (ERS_PASSWORD == null) {
			if (other.ERS_PASSWORD != null)
				return false;
		} else if (!ERS_PASSWORD.equals(other.ERS_PASSWORD))
			return false;
		if (ERS_USERNAME == null) {
			if (other.ERS_USERNAME != null)
				return false;
		} else if (!ERS_USERNAME.equals(other.ERS_USERNAME))
			return false;
		if (ERS_USERS_ID != other.ERS_USERS_ID)
			return false;
		if (USER_EMAIL == null) {
			if (other.USER_EMAIL != null)
				return false;
		} else if (!USER_EMAIL.equals(other.USER_EMAIL))
			return false;
		if (USER_ROLE_ID != other.USER_ROLE_ID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ErsUsers [ERS_USERS_ID=" + ERS_USERS_ID + ", ERS_USERNAME=" + ERS_USERNAME + ", ERS_PASSWORD="
				+ ERS_PASSWORD + ", ERS_FIRST_NAME=" + ERS_FIRST_NAME + ", ERS_LAST_NAME=" + ERS_LAST_NAME
				+ ", USER_EMAIL=" + USER_EMAIL + ", USER_ROLE_ID=" + USER_ROLE_ID + "]";
	}
	public ErsUsers(int ERS_USERS_ID, String ERS_USERNAME, String ERS_PASSWORD, String ERS_FIRST_NAME,
			String ERS_LAST_NAME, String USER_EMAIL, int USER_ROLE_ID) {
		super();
		this.ERS_USERS_ID = ERS_USERS_ID;
		this.ERS_USERNAME = ERS_USERNAME;
		this.ERS_PASSWORD = ERS_PASSWORD;
		this.ERS_FIRST_NAME = ERS_FIRST_NAME;
		this.ERS_LAST_NAME = ERS_LAST_NAME;
		this.USER_EMAIL = USER_EMAIL;
		this.USER_ROLE_ID = USER_ROLE_ID;
	}
	public ErsUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
