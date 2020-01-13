package com.example.demo.repository;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Account;
import com.example.demo.model.Bookmark;

public interface AccountRepository extends MongoRepository<Account, String> {	
}
