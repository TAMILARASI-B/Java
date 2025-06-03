package com;
interface  Bank
{
	public abstract void roi() ;
	default void StudentAccount() {
		System.out.println("yes we provide a student accoiint ");
	}
	static void OT() {	
		System.out.println("Without object ...!");
	}
	// we must have to implement all the interface methods
	// in java 8 : Default and static
}
class Sbi implements Bank
{
	@Override
	public void roi() {
		System.out.println("10%"); // same method same signature but different implementation
	}
}
class Axis  implements Bank
{
	@Override
	public void roi() {
		System.out.println("12%"); // same method same signature but different implementation
	}
}
// 1000 class
public class  InterfaceExample {
	public static void main(String[] args) {
		Sbi s = new Sbi();s.roi();s.StudentAccount(); // defautt : with object
		Axis a = new Axis();a.roi();
		Bank.OT();
	}
}
 
