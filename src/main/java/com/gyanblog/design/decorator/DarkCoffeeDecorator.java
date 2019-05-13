package com.gyanblog.design.decorator;

public class DarkCoffeeDecorator extends BeverageDecorator {

	public DarkCoffeeDecorator(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return this.getBeverage().getDescription() + ", With Dark Coffee";
	}

}
