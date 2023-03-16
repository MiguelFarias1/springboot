package com.rest.aprendizado.resource;

import com.rest.aprendizado.entities.Category;
import com.rest.aprendizado.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    @Autowired
    private CategoryRepository categoryRepository;

    /*public CategoryResource(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }*/

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {

        List<Category> categoryList = categoryRepository.findAll();

        return ResponseEntity.ok().body(categoryList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(categoryRepository.findById(id));
    }
}
