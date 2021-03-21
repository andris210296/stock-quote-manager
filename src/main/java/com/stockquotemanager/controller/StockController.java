package com.stockquotemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stockquotemanager.model.StockDatabase;
import com.stockquotemanager.model.StockJson;
import com.stockquotemanager.service.StockService;

@RestController
@RequestMapping(path = "/stock")
public class StockController {

	@Autowired
	StockService stockService;

	@PostMapping(path = "/addQuote")
	public @ResponseBody String addNewStockQuote(@RequestBody StockJson stock) {
		return stockService.addNewStockQuote(stock);
	}

	@GetMapping(path = "/allQuotes")
	public @ResponseBody Iterable<StockDatabase> getAllQuotes() {
		return stockService.getAllQuotes();
	}
	
	@GetMapping(path = "/{name}")
	public @ResponseBody StockJson getOneStock(@PathVariable("name") String name) {
		return stockService.getOneStock(name);
	}

}
