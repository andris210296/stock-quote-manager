package com.stockquotemanager.utils;

import java.util.*;

import com.stockquotemanager.model.StockDatabase;
import com.stockquotemanager.model.StockJson;
import com.stockquotemanager.model.StockManager;

public class StockManagerTestConstants {

	public static StockJson exampleStockJson(String idName) {

		Map<String, String> quotes = new LinkedHashMap<String, String>();
		quotes.put("2019-01-01", "10");
		quotes.put("2019-01-02", "11");
		quotes.put("2019-01-03", "14");

		return new StockJson.Builder()
				.setId(idName)
				.setQuotes(quotes)
				.build();
	}
	
	public static List<StockDatabase> exampleListStockDatabase(){
		
		List<StockDatabase> stockDatabases = new ArrayList<StockDatabase>();
		
		stockDatabases.add(new StockDatabase.Builder()
				.setId(1)
				.setName("petr3")
				.setDate("2019-01-01")
				.setPrice("10")
				.build());
		
		stockDatabases.add(new StockDatabase.Builder()
				.setId(2)
				.setName("petr3")
				.setDate("2019-01-02")
				.setPrice("11")
				.build());
		
		stockDatabases.add(new StockDatabase.Builder()
				.setId(3)
				.setName("petr3")
				.setDate("2019-01-03")
				.setPrice("14")
				.build());
				
		return stockDatabases;
		
	}
	
	
	public static List<StockManager> exampleListStockManager(){
		List<StockManager> stockManagers = new ArrayList<StockManager>();
		stockManagers.add(new StockManager.Builder()
				.setId("petr4")
				.setDescription("Petrobras PN")
				.build());
		stockManagers.add(new StockManager.Builder()
				.setId("vale5")
				.setDescription("Vale do Rio Doce PN")
				.build());
		return stockManagers;
	}
}
