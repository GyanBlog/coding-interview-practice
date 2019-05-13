package com.gyanblog.common.parents;

public abstract class ProblemParent {

	private long startDate;
	private long endDate;
	
	private void initiate() {
		this.startDate = System.nanoTime();
	}
	
	private void finish() {
		this.endDate = System.nanoTime();
		
		this.showTimeTaken();
	}
	
	private void showTimeTaken() {
		long diff = this.endDate - this.startDate;
		long ms = diff / 1000000;
		long sec = ms / 1000;
		ms = ms % 1000;
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(sec + "sec " + ms + " ms");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	/**
	 * Clients has to call this method after initialization
	 */
	public final void doExecute() {
		this.initiate();
		
		this.execute();
		
		this.finish();
	}
	
	/**
	 * Clients has to define this method
	 */
	public abstract void execute();
}
