package com.gyanblog.design.decorator;

public abstract class BeverageDecorator extends Beverage {
	private Beverage beverage;
	
	public BeverageDecorator(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public Beverage getBeverage() {
		return this.beverage;
	}
}
