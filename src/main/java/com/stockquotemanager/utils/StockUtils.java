package com.stockquotemanager.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.stockquotemanager.model.StockDatabase;
import com.stockquotemanager.model.StockJson;

public class StockUtils {

	public static List<StockDatabase> translateStockJsonToListStockDatabase(StockJson stockJson) {

		List<StockDatabase> stockDatabases = new ArrayList<StockDatabase>();

		for (Entry<String, String> map : stockJson.getQuotes().entrySet()) {
					
			stockDatabases.add(new StockDatabase.Builder()
					.setName(stockJson.getId())
					.setDate(map.getKey())
					.setPrice(map.getValue())
					.build());

		}

		return stockDatabases;
	}

}
