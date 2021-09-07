package org.alberthein.model.test;

public class Customer {

	private int noOfStamps;
	private int noOfFullCards;
	private Promotion[] promotions;
	
	public Customer(int noOfStamps, int noOfFullCards, Promotion[] promotions) {
		super();
		this.noOfStamps = noOfStamps;
		this.noOfFullCards = noOfFullCards;
		this.promotions = promotions;
	}

	public int getNoOfStamps() {
		return noOfStamps;
	}

	public int getNoOfFullCards() {
		return noOfFullCards;
	}

	public Promotion[] getPromotions() {
		return promotions;
	}
	
	
}
