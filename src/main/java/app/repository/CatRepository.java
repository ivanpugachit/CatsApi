package app.repository;

/**
 * Created by Иван on 20.02.2017.
 */
import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Cat;

public interface CatRepository extends MongoRepository<Cat, String>{

}