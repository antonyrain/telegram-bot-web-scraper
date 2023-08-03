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

import com.antonyrain.backserver.model.Filter;
import com.antonyrain.backserver.repository.FilterRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="/api")
public class FiltersController {

    @Autowired
    private FilterRepository filterRepository;

    @PostMapping(path="/filters")
    public String newFilter (@RequestBody Filter newFilter) {
        filterRepository.save(newFilter);
        return "Ok";
    };

    @GetMapping(path="/filters/all")
    public List<Filter> getAllFilters() {
        return filterRepository.findAll();
    }

    @GetMapping(path="/filters/all/{id}")
    public List<Filter> getAllFiltersById(@PathVariable Long id) {
        return filterRepository.findAllById(id);
    }

    @DeleteMapping("/filters/delete/{id}")
    void deleteAllFilters(@PathVariable Long id) {
        filterRepository.deleteAllFilters(id);
    }
}
