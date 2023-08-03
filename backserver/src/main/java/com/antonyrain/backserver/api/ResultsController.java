package com.antonyrain.backserver.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.antonyrain.backserver.model.Result;
import com.antonyrain.backserver.repository.ResultRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class ResultsController {

    @Autowired
    private ResultRepository resultRepository;

    @PostMapping(path="/results")
    public String newFilter (@RequestBody Result newResult) {
        List<Result> existEntity = resultRepository.findByIDandURL(
            newResult.getTelegramUserId(),
            newResult.getUrl()
            );
        if (existEntity.size() == 0){
            resultRepository.save(newResult);
            return "Saved";
        } else {
            return "Database record exists";
        }
    };

    @GetMapping(path="/results/{id}")
    List<Result> findAllByUserId(@PathVariable Long id) {
        return resultRepository.findAllByUserId(id);
    }

    @DeleteMapping("/results/delete/{id}")
    void deleteAllFilters(@PathVariable Long id) {
        resultRepository.deleteAllResults(id);
    }
}
