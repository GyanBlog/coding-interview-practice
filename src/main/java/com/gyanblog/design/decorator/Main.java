package com.gyanblog.design.decorator;

public class Main {

	public static void main(String[] args) {
		Beverage drink = new Coffee();
		System.out.println(drink.getDescription());
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		drink = new MochaDecorator(drink);
		System.out.println(drink.getDescription());
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		drink = new MochaDecorator(drink);
		System.out.println(drink.getDescription());
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		drink = new DarkCoffeeDecorator(drink);
		System.out.println(drink.getDescription());
	}
}
