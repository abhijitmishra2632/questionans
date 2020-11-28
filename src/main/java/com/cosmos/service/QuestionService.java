package com.cosmos.service;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmos.model.Question;
import com.cosmos.repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private IdSequenceService idSequenceService;

	public Question getQuestionById(Long questionseq) {
		// TODO Auto-generated method stub
		return questionRepository.findById(questionseq).get();
	}

	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		//List<Question> activeQuestions = questionRepository.findQuestionByActive();
		return questionRepository.findAll();
	}

	public Question saveQuestion(Question question) {
		// TODO Auto-generated method stub
		Long id=idSequenceService.getNext();
		question.setQuestionseq(id);
		question.setActive(true);
		return questionRepository.save(question);
	}

	public Question updateQuestion(Long questionseq, Question question) {
		return questionRepository.save(question);
	}

	public void deleteQuestion(Long questionseq) {
		// TODO Auto-generated method stub
		Question oldQ= questionRepository.findById(questionseq).get();
		oldQ.setActive(false);
		questionRepository.save(oldQ);
	}

	public List<Question> getQuestionByTechnology(String technology) {
		// TODO Auto-generated method stub
		return questionRepository.findQuestionByTechnologyAndActive(technology,true);
	}

	public Question cloneQuestion(Question question) {
		// TODO Auto-generated method stub
		question.setQuestionseq(idSequenceService.getNext());
		return questionRepository.save(question);
	}

	public List<Question> getAllDeletedQuestions() {
		return questionRepository.findQuestionByActive(false);
	}

	public void undoQuestionById(Long questionseq) {
		// TODO Auto-generated method stub
		Question oldQ= questionRepository.findById(questionseq).get();
		oldQ.setActive(true);
		questionRepository.save(oldQ);
	}

	public void deleteQuiestionPermanently(Long questionseq) {
		// TODO Auto-generated method stub
		Question oldQ= questionRepository.findById(questionseq).get();
		questionRepository.delete(oldQ);
	}

}
