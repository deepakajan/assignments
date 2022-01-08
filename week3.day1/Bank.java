package com.bank;

public class Bank extends BankInfo{
	
	public void deposit(int amount)
	{
		System.out.println("Cuurent Deposited amount: "+ amount + " /-");
	}

	public static void main(String[] args) {
	System.out.println("Bank Name: AXIS BANK");
	
	Bank bank = new Bank();
	bank.saving();
	bank.fixed();
	bank.deposit(2456); //parent
	
	BankInfo bankInfo = new BankInfo();
	bankInfo.deposit(1569); // over ride
}
}
