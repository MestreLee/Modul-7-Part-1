package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter){
		this.brand = brand;
		this.diameter = diameter;
	}

	@Override
	public String toString() {
		return "Roda : marca=" + brand + ", diametre=" + diameter + ".";
	}
	
	/*public void setDiameter (double diameter) {
		this.diameter = diameter;
	}
	
	public double getDiameter() {
		return this.diameter;
	}*/
}
