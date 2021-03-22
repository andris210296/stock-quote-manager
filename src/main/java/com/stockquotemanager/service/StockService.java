package com.stockquotemanager.service;

import com.stockquotemanager.model.StockDatabase;
import com.stockquotemanager.model.StockJson;

public interface StockService {

	public String addNewStockQuote(StockJson stock);

	public Iterable<StockDatabase> getAllQuotes();
	
	public StockJson getOneStock(String name);
	
	public String resetCache();

}
