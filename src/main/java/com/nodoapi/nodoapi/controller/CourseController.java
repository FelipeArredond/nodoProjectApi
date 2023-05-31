package com.nodoapi.nodoapi.controller;

import com.nodoapi.nodoapi.persistence.entity.Course;
import com.nodoapi.nodoapi.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public ResponseEntity<List<Course>> getAll(){
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable("id")Long id){
        return courseService.getById(id).map(course -> {
            return new ResponseEntity<>(course, HttpStatus.FOUND);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/school/{id}")
    public ResponseEntity<List<Course>> getBySchool(@PathVariable("id") Long id){
        return new ResponseEntity<>(courseService.getBySchool(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Course> save(@RequestBody Course course){
        return new ResponseEntity<>(courseService.save(course), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id")Long id){
        if(courseService.deleteById(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
