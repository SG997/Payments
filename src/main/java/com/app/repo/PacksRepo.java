package com.app.repo;

import com.app.dao.Packs;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PacksRepo extends MongoRepository<Packs, String> {

}
