package com.stockquotemanager.mapper.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockquotemanager.mapper.StockManagerMapper;
import com.stockquotemanager.model.StockManager;

@Service
public class StockManagerMapperImpl implements StockManagerMapper {

	@Override
	@Cacheable("stockManager")
	public List<StockManager> callListStockManager() {
		try {
			URL url = new URL("http://localhost:8080/stock");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			InputStream responseStream = connection.getInputStream();

			return new ObjectMapper().readValue(responseStream, new TypeReference<List<StockManager>>() {
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	@EventListener(ApplicationReadyEvent.class)
	public void callAddNewHostInStockmanager() {

		try {

			JSONObject json = new JSONObject();
			json.put("host", "localhost");
			json.put("port", 8081);

			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			try {
				HttpPost request = new HttpPost("http://localhost:8080/notification");
				StringEntity params = new StringEntity(json.toString());
				request.addHeader("content-type", "application/json");
				request.setEntity(params);
				HttpResponse response = httpClient.execute(request);
				HttpEntity entity = response.getEntity();

			} catch (Exception ex) {

			} finally {
				httpClient.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
