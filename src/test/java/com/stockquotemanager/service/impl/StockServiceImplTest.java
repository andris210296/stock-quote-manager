package com.stockquotemanager.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.stockquotemanager.mapper.StockManagerMapper;
import com.stockquotemanager.model.StockJson;
import com.stockquotemanager.model.StockManager;
import com.stockquotemanager.utils.StockManagerTestConstants;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {
	
	@InjectMocks
	private StockServiceImpl stockServiceImpl;
	
	@Mock
	private StockManagerMapper stockManagerMapper;
	
	@Mock
	private List<StockManager> stockManagers = StockManagerTestConstants.exampleListStockManager();
	
	@Test
	public void addNewStockQuoteTest() {
		
		StockJson stockJsonExample =  StockManagerTestConstants.exampleStockJson("petr4");
		
		String result = stockServiceImpl.addNewStockQuote(stockJsonExample);
		
		assertEquals("Saved", result);
		
	}
	
	@Test
	public void getOneStockTest() {
		StockJson stockJsonExample =  StockManagerTestConstants.exampleStockJson("petr4");
		
		StockJson result = stockServiceImpl.getOneStock("petr4");
		
		assertEquals(stockJsonExample.getId(), result.getId());
		
	}

}
