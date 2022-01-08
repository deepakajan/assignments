package com.bank;

public class BankInfo {
	
	 protected void saving() {
		System.out.println("Saving Accounts");
		long accNum = 798456L;
		int bal = 4500;
		System.out.println("Account Number: " + accNum + " and " + "Balance: " + bal + "/-");
	 }
		
		public void	fixed() {
			System.out.println("Fixed Deposit amount is 45000");
		}
		
		public void deposit(int amount)
		{
			System.out.println("Cuurent Deposited amount: "+ amount + "/-");
		}
		
	}


