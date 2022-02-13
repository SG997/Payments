package com.app.repo;

import com.app.dao.PendingTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PendingTransactionRepo extends MongoRepository<PendingTransaction, String> {

}