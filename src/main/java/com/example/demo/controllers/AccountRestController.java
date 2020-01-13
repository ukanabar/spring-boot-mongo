package com.example.demo.controllers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.model.Bookmark;
import com.example.demo.repository.AccountDal;
import com.example.demo.repository.AccountRepository;
import java.util.Comparator;


@RestController
@RequestMapping(value = "/")
public class AccountRestController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final AccountRepository accRepository;

	private final AccountDal accDAL;

	public AccountRestController(AccountRepository accRepository, AccountDal accDAL) {
		this.accRepository = accRepository;
		this.accDAL = accDAL;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Account addNewAccount(@RequestBody Account acc) {
		LOG.info("Saving account.");
		return accRepository.save(acc);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Account> getAllAccounts() {
		LOG.info("Getting all accounts.");
		return accRepository.findAll();
	}

	@RequestMapping(value = "/{accId}", method = RequestMethod.GET)
	public Account getAccount(@PathVariable String accId) {
		LOG.info("Getting user with ID: {}.", accId);
		return accRepository.findOne(accId);
	}
	
	@RequestMapping(value = "/{accId}/bookmarks", method = RequestMethod.GET)
	public Set<Bookmark> getBookmarks(@PathVariable String accId) {
		LOG.info("Getting user with ID: {}.", accId);
		return accDAL.findBookmarkById(accId);
	}
}
