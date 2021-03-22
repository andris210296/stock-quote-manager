package com.stockquotemanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.stockquotemanager.mapper.StockManagerMapper;
import com.stockquotemanager.model.StockDatabase;
import com.stockquotemanager.model.StockJson;
import com.stockquotemanager.model.StockManager;
import com.stockquotemanager.repository.StockRepository;
import com.stockquotemanager.service.StockService;
import com.stockquotemanager.utils.StockUtils;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockManagerMapper stockManagerMapper;

	private List<StockManager> stockManagers = new ArrayList<StockManager>();
	
	@Override
	public String addNewStockQuote(StockJson stock) {
		
		if(!StockUtils.stockExists(stock, stockManagers)) {
			return "Stock Id Invalid";
		}
		
		List<StockDatabase> stockDatabases = StockUtils.translateStockJsonToListStockDatabase(stock);
		
		for (StockDatabase stockDatabase : stockDatabases) {
			stockRepository.save(stockDatabase);
		}

		return "Saved";
	}

	@Override
	public Iterable<StockDatabase> getAllQuotes() {
		return stockRepository.findAll();
	}

	@Override
	public StockJson getOneStock(String name) {
		List<StockDatabase> stockDatabases = (List<StockDatabase>) stockRepository.findByName(name);			
		return StockUtils.translateListStockDatabaseToStockJson(stockDatabases);
	}
	
	@Override
	public String resetCache() {
		callListStockManager();
		
		return "Cache updated";
	}
	
	@EventListener(ApplicationReadyEvent.class)
	private void  callListStockManager() {
		stockManagers = stockManagerMapper.callListStockManager();
	}


}
