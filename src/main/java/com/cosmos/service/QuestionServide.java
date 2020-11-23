package com.cosmos.service;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmos.model.Question;
import com.cosmos.repository.QuestionRepository;

@Service
public class QuestionServide {
	@Autowired
	private QuestionRepository questionRepository;

	public Question getQuestionById(int questionId) {
		// TODO Auto-generated method stub
		return questionRepository.findById(questionId).get();
	}

	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}

	public Question saveQuestion(Question question) {
		// TODO Auto-generated method stub
		question.setActive(true);
		return questionRepository.save(question);
	}

	public Question updateQuestion(int questionId, Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response deleteQuestion(int questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> getQuestionByTechnology(String technology) {
		// TODO Auto-generated method stub
		return questionRepository.getQuestionByTechnology(technology);
	}

}
