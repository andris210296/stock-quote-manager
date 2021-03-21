package com.stockquotemanager.mapper;

import java.util.List;

import com.stockquotemanager.model.StockManager;

public interface StockManagerMapper {	
	
	public void callAddNewHostInStockmanager();
	
	public List<StockManager> callListStockManager();

}
