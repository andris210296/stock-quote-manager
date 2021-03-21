package com.stockquotemanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockquotemanager.mapper.StockManagerMapper;
import com.stockquotemanager.model.StockDatabase;
import com.stockquotemanager.model.StockJson;
import com.stockquotemanager.repository.StockRepository;
import com.stockquotemanager.service.StockService;
import com.stockquotemanager.utils.StockUtils;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockManagerMapper stockManagerMapper;

	@Override
	public String addNewStockQuote(StockJson stock) {
		
		if(!StockUtils.stockExists(stock, stockManagerMapper.callListStockManager())) {
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

}
