package org.alberthein.model.test;

public class Promotion {
	private String itemName;
	private int noOfFullCard;
	private double amountToPay;
	
	public Promotion(String itemName, int noOfFullCard, double amountToPay) {
		super();
		this.itemName = itemName;
		this.noOfFullCard = noOfFullCard;
		this.amountToPay = amountToPay;
	}

	public String getItemName() {
		return itemName;
	}

	public int getNoOfFullCard() {
		return noOfFullCard;
	}

	public double getAmountToPay() {
		return amountToPay;
	}

}
