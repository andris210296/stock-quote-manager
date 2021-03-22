package com.stockquotemanager.mapper.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.stockquotemanager.model.StockManager;

@RunWith(MockitoJUnitRunner.class)
public class StockManagerMapperImplTest {
	
	@InjectMocks
	private StockManagerMapperImpl stockManagerMapperImpl;
	
	
	@Test
	public void callListStockManager() {
		
		List<StockManager> result = stockManagerMapperImpl.callListStockManager();
		
		
	}

}
