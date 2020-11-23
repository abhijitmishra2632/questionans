package com.cosmos.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cosmos.model.Question;
@Repository
public interface QuestionRepository extends MongoRepository<Question, Integer>{
	List getQuestionByTechnology(@Param("technology") String technology);

}
