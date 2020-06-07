package com.turkish;

public class Recap {
int a;
String b;
 Recap(int a,String b){//we do not have a return type
	this.a=a;
	this.b=b;//current class variable 
	System.out.println("my number is "+a+" my name is a "+b);
}
Recap(int a,String b,boolean flag){
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recap obj=new Recap(23,"tugba");

	}

}
