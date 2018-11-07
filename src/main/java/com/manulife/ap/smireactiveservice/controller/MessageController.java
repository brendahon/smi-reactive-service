package com.manulife.ap.smireactiveservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manulife.ap.smireactiveservice.infra.repo.MessageReactiveRepository;
import com.manulife.ap.smireactiveservice.model.Message;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Brenda H Yu
 *
 */
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

	@Autowired
	private MessageReactiveRepository messageReactiveRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Flux<Message> getAllMessages() {
		return messageReactiveRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Mono<Message> getMessageById(@PathVariable("id") String id) {
		return messageReactiveRepository.findById(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Mono<Message> createMessage(@Valid @RequestBody String content) {
		
		Message message = new Message();
		message.setContent(content);
		return messageReactiveRepository.save(message);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Mono<Void> deleteMessage(@PathVariable String id) {
		return messageReactiveRepository.deleteById(id);

	}
}
