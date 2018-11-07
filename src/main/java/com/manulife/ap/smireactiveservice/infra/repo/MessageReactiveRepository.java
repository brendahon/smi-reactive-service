package com.manulife.ap.smireactiveservice.infra.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.manulife.ap.smireactiveservice.model.Message;

/**
 * @author Brenda H Yu
 *
 */
@Repository
public interface MessageReactiveRepository 
		extends ReactiveMongoRepository<Message, String>{

}
