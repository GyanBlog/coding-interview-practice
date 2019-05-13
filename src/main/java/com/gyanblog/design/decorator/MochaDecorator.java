package com.gyanblog.design.decorator;

public class MochaDecorator extends BeverageDecorator {

	public MochaDecorator(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return this.getBeverage().getDescription() + ", With Mocha";
	}

}
