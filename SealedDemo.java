package org;

// Sealed class is a technique that limits the number of classes that can inherit the given class.
sealed class Human permits Manish, Vartika, Anjali
{   
	int site=5;
    public void printName()
    {
        System.out.println("Default");
    }
}

non-sealed class Manish extends Human
{
    public void printName()
    {
        System.out.println("Manish Sharma: "+site);
    }
}

non-sealed class Vartika extends Human
{
    public void printName()
    {
        System.out.println("Vartika Dadheech: "+site);
    }
}

final class Anjali extends Human
{
    public void printName()
    {
        System.out.println("Anjali Sharma: "+site);
    }
}

public class SealedDemo
{
    public static void main(String[] args)
    {   
        Human h1 = new Anjali();
        Human h2 = new Vartika();
        Human h3 = new Manish();
        
        h1.printName();
        h2.printName();
        h3.printName();
    }
}
