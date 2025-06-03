package org;
// default and static methods in interface cannot be overriden
interface Bank {
    void deposit();
    void withdraw();
    static void studentaccount()
    {
    	  System.out.println("Yes we provide student account");
    }
    default void savingsaccount()
    {
    	  System.out.println("Savings account is available");
    }
}
class SBI implements Bank {
	@Override
    public void deposit() {
        System.out.println("Deposit in SBI Bank");
    }

    public void withdraw() {
        System.out.println("Withdraw from SBI Bank");
    }
}

class AXIS implements Bank {
	@Override
    public void deposit() {
        System.out.println("Deposit in AXIS Bank");
    }

    public void withdraw() {
        System.out.println("Withdraw from AXIS Bank");
    }
}
class ICICI implements Bank {
	@Override
    public void deposit() {
        System.out.println("Deposit in ICICI Bank");
    }

    public void withdraw() {
        System.out.println("Withdraw from ICICI Bank");
    }
}

public class Interface_with_default_static {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Bank sbi = new SBI();
	     sbi.deposit();
	     sbi.withdraw();
	     
	     Bank.studentaccount();
	     sbi.savingsaccount();
	     
	     Bank axis = new AXIS();
	     axis.deposit();
	     axis.withdraw();
	     
	     Bank icici  = new ICICI();
	     icici.deposit();
	     icici.withdraw();

	}

}
