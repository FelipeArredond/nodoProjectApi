package com.nodoapi.nodoapi.controller;

import com.nodoapi.nodoapi.persistence.entity.School;
import com.nodoapi.nodoapi.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
@CrossOrigin(origins = "*")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("")
    public ResponseEntity<List<School>> getAll(){
        return new ResponseEntity<>(schoolService.getAll(), HttpStatus.OK);
    }
}
