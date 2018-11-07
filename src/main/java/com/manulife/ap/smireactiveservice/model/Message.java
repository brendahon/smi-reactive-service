package com.manulife.ap.smireactiveservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Brenda H Yu
 *
 */
@Document(collection = "messages")
public class Message {

	@Id
	private String id;
	
	
	private String content;

	public Message() {
	}

	public Message(String id, String content) {
		this.id = id;
		this.content = content;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
