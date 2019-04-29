package com.revature.bean;

public class Account {

		private double Deposit;
		private double Withdraw;
		private double Balance;
		private int AccountNum;
		private int accountid;
		private String service;
		
		
		public double getDeposit() {
			return Deposit;
		}
		public void setDeposit(double deposit) {
			this.Deposit = deposit;
		}
		public double getWithdraw() {
			return Withdraw;
		}
		public void setWithdraw(double withdraw) {
			this.Withdraw = withdraw;
		}
		public double getBalance() {
			return Balance;
		}
		public void setBalance(double balance) {
			this.Balance = balance;
		}
		public int getAccountNum() {
			return AccountNum;
		}
		public void setAccountNum(int accountNum) {
			this.AccountNum = accountNum;
		}
		public int getAccountid() {
			return accountid;
		}
		public void setAccountid(int accountid) {
			this.accountid = accountid;
		}
		public String getService() {
			return service;
		}
		public void setService(String service) {
			this.service = service;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + AccountNum;
			long temp;
			temp = Double.doubleToLongBits(Balance);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(Deposit);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(Withdraw);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + accountid;
			result = prime * result + ((service == null) ? 0 : service.hashCode());
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
			Account other = (Account) obj;
			if (AccountNum != other.AccountNum)
				return false;
			if (Double.doubleToLongBits(Balance) != Double.doubleToLongBits(other.Balance))
				return false;
			if (Double.doubleToLongBits(Deposit) != Double.doubleToLongBits(other.Deposit))
				return false;
			if (Double.doubleToLongBits(Withdraw) != Double.doubleToLongBits(other.Withdraw))
				return false;
			if (accountid != other.accountid)
				return false;
			if (service == null) {
				if (other.service != null)
					return false;
			} else if (!service.equals(other.service))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Account [Deposit=" + Deposit + ", Withdraw=" + Withdraw + ", Balance=" + Balance + ", AccountNum="
					+ AccountNum + ", accountid=" + accountid + ", service=" + service + "]";
		}
		public Account(double deposit, double withdraw, double balance, int accountNum, int accountid, String service) {
			super();
			this.Deposit = deposit;
			this.Withdraw = withdraw;
			this.Balance = balance;
			this.AccountNum = accountNum;
			this.accountid = accountid;
			this.service = service;
		}
		public Account() {
			super();
			// TODO Auto-generated constructor stub
		}
}
