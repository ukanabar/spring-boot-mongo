package com.example.demo.repository;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;
import com.example.demo.model.Bookmark;
@Repository
public class AccountDalImpl implements AccountDal{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Account> getAllAccounts() {
		return mongoTemplate.findAll(Account.class);
	}

	@Override
	public Account getAccountById(String accId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(accId));
		return mongoTemplate.findOne(query, Account.class);
	}

	@Override
	public Account addNewAccount(Account account) {
		mongoTemplate.save(account);
		return account;
	}
	
	@Override
	public Set<Bookmark> findBookmarkById(String id){
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		Account acc = mongoTemplate.findOne(query, Account.class);
		Set<Bookmark> bookmarks = acc.getBookmarkSet();
		return bookmarks.stream().sorted(Comparator.comparing(Bookmark::getDate)).collect(Collectors.toSet());
	}
	
}
