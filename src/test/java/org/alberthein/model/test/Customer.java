package org.alberthein.model.test;

public class Customer {

	private int noOfStamps;
	private int noOfFullCards;
	private Promotion promotion;
	
	public Customer(int noOfStamps, int noOfFullCards, Promotion promotion) {
		super();
		this.noOfStamps = noOfStamps;
		this.noOfFullCards = noOfFullCards;
		this.promotion = promotion;
	}

	public int getNoOfStamps() {
		return noOfStamps;
	}

	public int getNoOfFullCards() {
		return noOfFullCards;
	}

	public Promotion getPromotion() {
		return promotion;
	}
}
