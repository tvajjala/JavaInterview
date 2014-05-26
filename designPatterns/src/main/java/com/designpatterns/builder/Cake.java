package com.designpatterns.builder;

public class Cake {

	private double sugar; // cup
	private double butter;

	/**
	 * @return the sugar
	 */
	public double getSugar() {
		return sugar;
	}

	/**
	 * @param sugar
	 *            the sugar to set
	 */
	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	/**
	 * @return the butter
	 */
	public double getButter() {
		return butter;
	}

	/**
	 * @param butter
	 *            the butter to set
	 */
	public void setButter(double butter) {
		this.butter = butter;
	}

	private Cake(Builder builder) {
		this.sugar = builder.sugar;
		this.butter = builder.butter;
	}

	public static class Builder {
		private double sugar; // cup
		private double butter;

		public Builder sugar(double cup) {
			this.sugar = cup;
			return this;
		}

		public Builder butter(double cup) {
			this.butter = cup;
			return this;
		}

		public Cake build() {
			return new Cake(this);
		}

	}
}
