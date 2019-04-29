package com.revature.bean;

public class Junction {
	
	int AccountNum;
	int id;
	
	public int getAccountNum() {
		return AccountNum;
	}
	public void setAccountNum(int accountNum) {
		this.AccountNum = accountNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AccountNum;
		result = prime * result + id;
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
		Junction other = (Junction) obj;
		if (AccountNum != other.AccountNum)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Junction [AccountNum=" + AccountNum + ", id=" + id + "]";
	}
	public Junction(int accountNum, int id) {
		super();
		this.AccountNum = accountNum;
		this.id = id;
	}
	public Junction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
