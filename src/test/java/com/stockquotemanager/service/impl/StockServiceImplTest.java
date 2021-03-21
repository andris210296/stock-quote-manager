package com.stockquotemanager.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.stockquotemanager.model.StockDatabase;
import com.stockquotemanager.model.StockJson;
import com.stockquotemanager.utils.StockManagerTestConstants;
import com.stockquotemanager.utils.StockUtils;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {

	@Test
	public void translateStockJsonToListStockDatabaseTest() {

		StockJson stockJsonExample = StockManagerTestConstants.exampleStockJson();

		List<StockDatabase> result = StockUtils.translateStockJsonToListStockDatabase(stockJsonExample);

		assertEquals(stockJsonExample.getId(), result.get(0).getName());
		assertEquals(stockJsonExample.getQuotes().get("2019-01-01"), result.get(0).getPrice());

	}

}
