package com.cosmos.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmos.model.Question;
import com.cosmos.service.QuestionServide;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionServide questionService;
	
	@GetMapping("/{questionId}")
	public Question getQuestionById(@PathVariable int questionId){
		return questionService.getQuestionById(questionId);
	}
	@GetMapping("/technology/{technology}")
	public List<Question> getQuestionByTechnology(@PathVariable String technology){
		return questionService.getQuestionByTechnology(technology);
	}
	@GetMapping
	public List<Question> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	@PostMapping
	public Question saveQuestion(@RequestBody Question question) {
		return questionService.saveQuestion(question);
	}
	@PutMapping("/{questionId}")
	public Question updateQuestion(@PathVariable int questionId,@RequestBody Question question) {
		return questionService.updateQuestion(questionId,question);
	}
	@DeleteMapping("/{questionId}")
	public Response deleteQuiestion(@PathVariable int questionId) {
		return questionService.deleteQuestion(questionId);
	}

}
