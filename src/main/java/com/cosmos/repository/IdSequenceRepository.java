package com.cosmos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cosmos.model.IdSequence;

@Repository
public interface IdSequenceRepository extends MongoRepository<IdSequence, String>{
	IdSequence findTopByOrderByIdDesc();
}
