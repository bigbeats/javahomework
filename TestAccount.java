package test;
import java.util.Date; // 日期类创建开户日期
public class TestAccount {
	public static void main(String[] args) {
		Account account=new Account(1122,20000);
		account.setAnnualInterestRate(4.5);
		account.withDraw(2500);
		account.deposit(3000);
		System.out.println("当前账户的余额为："+account.getBalance());
		System.out.println("当前的月利息是："+account.getMonthlyInterest());
		System.out.println("该账户的开户日期是："+account.getDate());
	}
}
class Account{
	private int id=0;
	private double balance=0;
	private double annualInterestRate=0;
	private Date dateCreated = new Date();
	Account(){
	}
	Account(int newId,double newBalance){
		id=newId;
		balance=newBalance;
	}	
	int getId(){
		return id;
	}
	void setId(int newId){
		id=newId;
	}
	double getBalance(){
		return balance;
	}
	void setBalance(double NewBalance){
		balance=NewBalance;
	}
	double getAnnualInterestRate(){
		return annualInterestRate;
	}
	void setAnnualInterestRate(double NewAnnualInterestRate){
		annualInterestRate=NewAnnualInterestRate;
	}

	double getMonthlyInterestRate() {
		return (annualInterestRate/12/100);
	}
	double getMonthlyInterest() {
		return (balance*getMonthlyInterestRate());
	}
	void withDraw(double number) {
		balance=balance-number;
	}
	void deposit(double number) {
		balance=balance+number;
	}
	String getDate() {
		return dateCreated.toString();
	}
}

