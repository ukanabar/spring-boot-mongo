package com.example.demo.repository;

import java.util.List;
import java.util.Set;

import com.example.demo.model.Account;
import com.example.demo.model.Bookmark;

public interface AccountDal {
	List<Account> getAllAccounts();

	Account getAccountById(String accId);

	Account addNewAccount(Account account);
	
	Set<Bookmark> findBookmarkById(String id); 
}
