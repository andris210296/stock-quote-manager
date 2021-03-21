package com.stockquotemanager.model;

import java.io.Serializable;

public class StockManager implements Serializable{

	private static final long serialVersionUID = -5690934181857084653L;
	
	protected String id;
	
	protected String description;

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public static class Builder extends StockManager implements Serializable{

		private static final long serialVersionUID = -2526658454910974049L;
		
		public Builder() {
						
		}
		
		public Builder setId(String id) {
			this.id = id;
			return this;
		}
		
		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}
		
		public StockManager build() {
			StockManager stockManager = new StockManager();
			stockManager.id = this.id;
			stockManager.description = this.description;
			return stockManager;
		}
		
	}

}
