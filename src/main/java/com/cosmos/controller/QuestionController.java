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
import com.cosmos.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/{questionseq}")
	public Question getQuestionById(@PathVariable Long questionseq){
		return questionService.getQuestionById(questionseq);
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
	@PostMapping("/clone")
	public Question cloneQuestion(@RequestBody Question question) {
		return questionService.cloneQuestion(question);
	}
	@PutMapping("/{questionseq}")
	public Question updateQuestion(@PathVariable Long questionseq,@RequestBody Question question) {
		return questionService.updateQuestion(questionseq,question);
	}
	@DeleteMapping("/{questionseq}")
	public void deleteQuiestion(@PathVariable Long questionseq) {
		questionService.deleteQuestion(questionseq);
	}
	@GetMapping("/deleted")
	public List<Question> getAllDeletedQuestions(){
		return questionService.getAllDeletedQuestions();
	}
	@GetMapping("/undo/{questionseq}")
	public void undoQuestionById(@PathVariable Long questionseq){
		questionService.undoQuestionById(questionseq);
	}
	@DeleteMapping("permanent/{questionseq}")
	public void deleteQuiestionPermanently(@PathVariable Long questionseq) {
		questionService.deleteQuiestionPermanently(questionseq);
	}

}
