package com.cosmos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seqforq")
public class IdSequence {
	@Id
	private String id;
	
	public long seq;

	public IdSequence() {
		super();
	}

	public IdSequence(long seq) {
		super();
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}
	

}
