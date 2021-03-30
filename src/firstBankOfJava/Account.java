package firstBankOfJava;

import java.util.Scanner;

public class Account {
	//Class Variables
	int balance;
	int previousTransaction;
	String clientName;
	String clientID;
	
	//Account class constructor
	Account(String name, String id) {
		clientName = name;
		clientID = id;
	}
	
	//Function for depositing money
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	//Function for withdrawing money from account
	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	//Function for showing previous transaction
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		} else 
			System.out.println("There was no transaction!");
	}
	
	//Function for calculating a 3.66% interest
	void calculateInterest(int years) {
		double interestRate = 3.66;
		double interestBalance = (balance * (interestRate / 100) * years) + balance;
		System.out.println("The current interest rate is " + interestRate);
		System.out.println("After " + years + " years, your balance will be: " + interestBalance);
	}
	
	void mainMenu() {
		int option;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome " + clientName + "! Your ID is " + clientID + "\n");
		System.out.println("What would you like to do?\n");
		System.out.println("1. Check balance");
		System.out.println("2. Make a deposit");
		System.out.println("3. Make a withdrawal");
		System.out.println("4. View previous transaction");
		System.out.println("5. Calculate interest");
		System.out.println("6. Exit application\n");
		
		do {
			System.out.print("Enter an option: ");
			option = scanner.nextInt();
			
			switch(option) {
			
			case 1:
				System.out.println("========================================");
				System.out.println("Balace = $" + balance);
				System.out.println("========================================\n");
				break;
			
			case 2:
				System.out.println("Enter an amount to deposit: ");
				int depositAmount = scanner.nextInt();
				deposit(depositAmount);
				break;
			
			case 3:
				System.out.println("Enter an amount to withdraw: ");
				int withdrawAmount = scanner.nextInt();
				withdraw(withdrawAmount);
				break;
			
			case 4:
				System.out.println("========================================");
				getPreviousTransaction();
				System.out.println("========================================\n");
				break;
				
			case 5:
				System.out.print("How many years of interest: ");
				int years = scanner.nextInt();
				calculateInterest(years);
				break;
				
			case 6:
				System.out.println("========================================");
				break;
			
			default: 
				System.out.println("Error, invalid option! Please choose options 1 through 6!");
				break;
			} 
			
		} while(option != 6);
		System.out.println("Thank you for using our application!");
		scanner.close();
	}
}
