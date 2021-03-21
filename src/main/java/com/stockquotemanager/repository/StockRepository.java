package com.stockquotemanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.stockquotemanager.model.StockDatabase;

public interface StockRepository extends CrudRepository<StockDatabase, Integer> {

	List<StockDatabase> findByName(String name);

}
