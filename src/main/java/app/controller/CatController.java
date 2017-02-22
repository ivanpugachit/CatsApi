package app.controller;

/**
 * Created by Иван on 20.02.2017.
 */

import app.model.Cat;
import app.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cat")
public class CatController {

    @Autowired
    private CatRepository catRepository;

    @RequestMapping (method = RequestMethod.POST)
    public ResponseEntity<Cat> createCat(@RequestBody Cat cat) {
        if (cat.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(catRepository.save(cat));
    }

    @RequestMapping (method = RequestMethod.GET, value = "{catId}")
    public ResponseEntity<Cat> getCat(@PathVariable("catId") String сatId) {
        Cat cat = catRepository.findOne(сatId);
        return cat == null ? ResponseEntity.notFound().<Cat>build() : ResponseEntity.ok(cat);
    }

    @RequestMapping (method = RequestMethod.PUT)
    public ResponseEntity<Cat> editCat(@RequestBody Cat cat) {
        if (!catRepository.exists(cat.getId())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().body(catRepository.save(cat));
    }


    @RequestMapping (method = RequestMethod.DELETE, value = "{catId}")
    public ResponseEntity<Cat> deleteCat(@PathVariable("catId") String catId) {
        if (!catRepository.exists(catId)) {
            return ResponseEntity.noContent().build();
        }
        catRepository.delete(catId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping (method = RequestMethod.GET)
    public ResponseEntity<List<Cat>> getAllCats() {
        return ResponseEntity.ok(catRepository.findAll());
    }
}