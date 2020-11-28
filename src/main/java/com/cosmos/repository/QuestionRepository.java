package com.cosmos.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cosmos.model.Question;
@Repository
public interface QuestionRepository extends MongoRepository<Question, Long>{
	List getQuestionByTechnology(@Param("technology") String technology);
	List findQuestionByActive();
	List findQuestionByTechnologyAndActive(String technology , boolean active);
	List<Question> findQuestionByActive(boolean b);

}
