package com.stockquotemanager.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.stockquotemanager.model.StockDatabase;
import com.stockquotemanager.model.StockJson;
import com.stockquotemanager.model.StockManager;
import com.stockquotemanager.utils.StockUtils;

@RunWith(MockitoJUnitRunner.class)
public class StockUtilsTest {

	@Test
	public void translateStockJsonToListStockDatabaseTest() {

		StockJson stockJsonExample = StockManagerTestConstants.exampleStockJson("petr3");

		List<StockDatabase> result = StockUtils.translateStockJsonToListStockDatabase(stockJsonExample);

		assertEquals(stockJsonExample.getId(), result.get(0).getName());
		assertEquals(stockJsonExample.getQuotes().get("2019-01-01"), result.get(0).getPrice());

	}
	
	@Test
	public void translateListStockDatabaseToStockJson() {
		List<StockDatabase> stockDatabasesExample = StockManagerTestConstants.exampleListStockDatabase();
		
		StockJson result = StockUtils.translateListStockDatabaseToStockJson(stockDatabasesExample);
		
		assertEquals(stockDatabasesExample.get(0).getName(), result.getId());
		assertEquals(stockDatabasesExample.get(0).getPrice(), result.getQuotes().get("2019-01-01"));
	}
	
	@Test
	public void stockExistsTest() {
		List<StockManager> stockManagersExample = StockManagerTestConstants.exampleListStockManager();
		
		boolean result1 = StockUtils.stockExists(StockManagerTestConstants.exampleStockJson("petr4"), stockManagersExample);
		assertTrue(result1);
		
		boolean result2 = StockUtils.stockExists(StockManagerTestConstants.exampleStockJson("error"), stockManagersExample);
		assertFalse(result2);
	}

}
