package com.app.repo;


import com.app.dao.Payments;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentsRepo extends MongoRepository<Payments, String> {

}