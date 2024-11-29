package com.satishlabs.booksearch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.booksearch.entity.BookInventory;

public interface BookInventoryDAO extends JpaRepository<BookInventory, Integer>{

}
