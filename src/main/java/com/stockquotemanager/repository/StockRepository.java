package com.stockquotemanager.repository;

import org.springframework.data.repository.CrudRepository;

import com.stockquotemanager.model.StockDatabase;

public interface StockRepository extends CrudRepository<StockDatabase, Integer> {

	StockDatabase findById(String id);

}
