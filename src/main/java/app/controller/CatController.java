package app.controller;

/**
 * Created by Иван on 20.02.2017.
 */

import app.model.Cat;
import app.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController

public class CatController {

    @Autowired
    private CatRepository сatRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/cat/")
    public Map<String, Object> createCat(@RequestBody Cat cat) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "сat created successfully");
        response.put("сat", сatRepository.save(cat));
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cat/{сatId}")
    public ResponseEntity<Cat> getCatDetails(@PathVariable("сatId") String сatId) {
        Cat cat = сatRepository.findOne(сatId);
        return cat == null ? ResponseEntity.notFound().<Cat>build() : ResponseEntity.ok(cat);
    }

    @RequestMapping( method = RequestMethod.PUT,value = "/cat/{catID}")
    public Map<String, Object> editCat(@PathVariable("сatId") String сatId,
                                       @RequestBody Map<String, Object> сatMap) {
        Cat сat = new Cat(сatMap.get("name").toString(),
                сatMap.get("sex").toString(),
                сatMap.get("birthday").toString());
        сat.setId(сatId);

        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Cat Updated successfully");
        response.put("Cat", сatRepository.save(сat));
        return response;
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/cat/{catId}" )
    public Map<String, String> deleteCat(@PathVariable("сatId") String сatId) {
        сatRepository.delete(сatId);
        Map<String, String> response = new HashMap<String, String>();
        response.put("message", "Cat deleted successfully");

        return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getAllCats() {
        List<Cat> сats = сatRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("totalCats", сats.size());
        response.put("Cats", сats);
        return response;
    }
}
