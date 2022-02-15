package com.app.repo;

import com.app.dao.PendingTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PendingTransactionRepo extends MongoRepository<PendingTransaction, String> {

    Optional<PendingTransaction> findByProcessId(String processId);

}