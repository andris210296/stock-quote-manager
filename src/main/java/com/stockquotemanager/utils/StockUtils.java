package com.stockquotemanager.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
	
	public static StockJson translateListStockDatabaseToStockJson(List<StockDatabase> stockDatabases) {
		
		LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();

		for (StockDatabase stockDatabase : stockDatabases) {
			hashMap.put(stockDatabase.getDate(), stockDatabase.getPrice());
		}
		
		return new StockJson.Builder()
				.setId(stockDatabases.get(0).getName())
				.setQuotes(hashMap)
				.build();
	}

}
