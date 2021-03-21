package com.stockquotemanager.model;

import java.io.Serializable;
import java.util.Map;

public class StockJson implements Serializable {

	private static final long serialVersionUID = -1233670853007405880L;

	protected String id;

	protected Map<String, String> quotes;

	public String getId() {
		return id;
	}

	public Map<String, String> getQuotes() {
		return quotes;
	}

	public static class Builder extends StockJson implements Serializable {

		private static final long serialVersionUID = 4273829740659649583L;

		public Builder() {

		}

		public Builder setId(String id) {
			this.id = id;
			return this;
		}

		public Builder setQuotes(Map<String, String> quotes) {
			this.quotes = quotes;
			return this;
		}

		public StockJson build() {
			StockJson stockJson = new StockJson();
			stockJson.id = this.id;
			stockJson.quotes = this.quotes;
			return stockJson;
		}

	}

}
