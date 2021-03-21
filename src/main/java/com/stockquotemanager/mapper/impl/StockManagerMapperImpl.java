package com.stockquotemanager.mapper.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockquotemanager.mapper.StockManagerMapper;
import com.stockquotemanager.model.StockManager;

@Service
public class StockManagerMapperImpl implements StockManagerMapper {

	@Override
	public List<StockManager> callListStockManager() {
		try {
			URL url = new URL("http://localhost:8080/stock");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			InputStream responseStream = connection.getInputStream();
			
			return new ObjectMapper().readValue(responseStream, new TypeReference<List<StockManager>>() {});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
