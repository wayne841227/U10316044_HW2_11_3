import java.util.Scanner;
import java.util.Date;

public class TestAccount{
	public static void main(String[] args){
		
		Scanner scannerinput = new Scanner(System.in);
		int judge = 1;
		double money = 0;
		
		Account Account1 = new Account(1122,20000);
		Account SavingAccount = new Account(1122,20000);
		Account CheckingAccount = new Account(1122,20000);
		
		Account1.setAnnualInterestRate(4.5);
		SavingAccount.setAnnualInterestRate(4.5);
		CheckingAccount.setAnnualInterestRate(4.5);
		
		
		System.out.print("Welcome to Bible Bank ");
		
		System.out.print("Which action do you want to do [withdraw(1) or deposit(2)]?");	
		judge = scannerinput.nextInt();
		
		if(judge == 1){
			
			System.out.print("How much money do you want to withdraw (the overdraft limit =15000)?");
			money = scannerinput.nextDouble();
			
			if(money > 20000){
				System.out.print("You are overdrawnning.");
				
			}
			else{
			Account1.withdraw(money);
			SavingAccount.withdraw(money);
			
				if(money > 35000){
					System.out.print("You are over the overdraft limit.");
				
				}
				else{
					CheckingAccount.withdraw(money);
				}
			}
		}
		else{
		
			System.out.print("How much money do you want to deposit ?");
			money = scannerinput.nextDouble();
			
			Account1.deposit(money);
			SavingAccount.deposit(money);
			CheckingAccount.deposit(money);
		}
		System.out.print(Account1.toString());;
		System.out.print(SavingAccount.toString());
		System.out.print(CheckingAccount.toString());
			
	}

}
class Account{
	
	private int id ;
	private double balance ;
	private double annualInterestRate ;
	private Date dateCreated;
	
	public double deposit = 0;
	public double withdraw = 0;

	Account(){
		dateCreated = new Date();	
	}
	Account(int id1,double balance1){
		dateCreated = new Date();
		id = id1;
		balance = balance1;
	}
	
	
	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance1){
		balance = balance1;
	}
	
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate1){
		annualInterestRate = annualInterestRate1;
	}
	
	public double getMonthlyInterestRate(){
		return annualInterestRate / 1200;
	}
	
	public double getMonthlyInterest(){
		return balance * getMonthlyInterestRate();
	}
	
	public Date getDateCreated(){
		return dateCreated;
	}
	public String toString(){
		return "Your ID is " + id + "\n" + "Your balance is "+ getBalance() + "\n"
			 + "Your monthly interest is " + getMonthlyInterest() +"\n"
			 + "This moment is " + dateCreated +"\n";
	}
	
	public void withdraw(double withdraw){
		balance = getBalance() - withdraw;
	}
	public void deposit(double deposit){
		balance = getBalance() + deposit;
	}

}
class SavingAccount extends Account{
	
	SavingAccount(int idS,double balanceS){
		super(idS,balanceS);
	}
	public void setAnnualInterestRate(double annualInterestRate1){
		super.setAnnualInterestRate(annualInterestRate1);
	}
	
	
	public void withdraw(double withdraw){
		super.withdraw(withdraw);
	}
	public void deposit(double deposit){
		super.deposit(deposit);
	}
	
	
	public String toString(){
		return super.toString();
	}

	
}
class CheckingAccount extends Account{
	
	CheckingAccount(int idC,double balanceC){
		super(idC,balanceC);
	}
	public void setAnnualInterestRate(double annualInterestRate1){
		super.setAnnualInterestRate(annualInterestRate1);
	}
	
	public void withdraw(double withdraw){
		super.withdraw(withdraw);
	}
	public void deposit(double deposit){
		super.deposit(deposit);
	}
	
	public String toString(){
		return super.toString();
	}
	
	
	
}
