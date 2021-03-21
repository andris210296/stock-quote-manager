package com.stockquotemanager.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class StockDatabase implements Serializable {

	private static final long serialVersionUID = -7887161061478599469L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;

	protected String name;

	protected String date;

	protected String price;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getPrice() {
		return price;
	}

	public static class Builder extends StockDatabase implements Serializable {

		private static final long serialVersionUID = -1268295132721631990L;

		public Builder() {

		}

		public Builder setId(long id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setDate(String date) {
			this.date = date;
			return this;
		}

		public Builder setPrice(String price) {
			this.price = price;
			return this;
		}

		public StockDatabase build() {
			StockDatabase stockDatabase = new StockDatabase();
			stockDatabase.id = this.id;
			stockDatabase.name = this.name;
			stockDatabase.date = this.date;
			stockDatabase.price = this.price;
			return stockDatabase;
		}

	}

}
