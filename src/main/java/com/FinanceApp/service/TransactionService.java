package com.FinanceApp.service;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.FinanceApp.model.Transaction;
import com.FinanceApp.repository.TransactionRepository;

public class TransactionService {

	private TransactionRepository transactionRepository;

	@Autowired
	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}
	
	public void addTransaction(HashMap<String, String> transactionDetails) throws Exception {
		Transaction newTransaction = new Transaction();
		for(Map.Entry<String, String> map: transactionDetails.entrySet()) {
			PropertyDescriptor pd = new PropertyDescriptor(map.getKey(), newTransaction.getClass());
			pd.getWriteMethod().invoke(newTransaction, map.getValue());
		}
		transactionRepository.save(newTransaction);
	}
	
	public void editTransaction(HashMap<String, String> transactionDetails) {}
	
	public void deleteTransaction() {}
}
