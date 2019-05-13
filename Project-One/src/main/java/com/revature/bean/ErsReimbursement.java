package com.revature.bean;

import java.time.LocalDate;

public class ErsReimbursement {
	private int id;
	private double amount;
//	private LocalDate submitted;
//	private LocalDate resolved;
	private String Description;
//	private String Reciept;
	private int Author;
	private int Resolver;
	private int Status_Id;
	private int Type_Id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
	public int getAuthor() {
		return Author;
	}
	public void setAuthor(int author) {
		this.Author = author;
	}
	public int getResolver() {
		return Resolver;
	}
	public void setResolver(int resolver) {
		this.Resolver = resolver;
	}
	public int getStatus_Id() {
		return Status_Id;
	}
	public void setStatus_Id(int status_Id) {
		this.Status_Id = status_Id;
	}
	public int getType_Id() {
		return Type_Id;
	}
	public void setType_Id(int type_Id) {
		this.Type_Id = type_Id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Author;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + Resolver;
		result = prime * result + Status_Id;
		result = prime * result + Type_Id;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ErsReimbursement other = (ErsReimbursement) obj;
		if (Author != other.Author)
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (Resolver != other.Resolver)
			return false;
		if (Status_Id != other.Status_Id)
			return false;
		if (Type_Id != other.Type_Id)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ErsReimbursement [id=" + id + ", amount=" + amount + ", Description=" + Description + ", Author="
				+ Author + ", Resolver=" + Resolver + ", Status_Id=" + Status_Id + ", Type_Id=" + Type_Id + "]";
	}
	public ErsReimbursement(int id, double amount, String description, int author, int resolver, int status_Id,
			int type_Id) {
		super();
		this.id = id;
		this.amount = amount;
		this.Description = description;
		this.Author = author;
		this.Resolver = resolver;
		this.Status_Id = status_Id;
		this.Type_Id = type_Id;
	}
	public ErsReimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}