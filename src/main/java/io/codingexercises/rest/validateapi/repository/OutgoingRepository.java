package io.codingexercises.rest.validateapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.codingexercises.rest.validateapi.model.Outgoing;

@Repository
public interface OutgoingRepository extends MongoRepository<Outgoing, Long>{

}
