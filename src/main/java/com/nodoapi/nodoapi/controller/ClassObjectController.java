package com.nodoapi.nodoapi.controller;

import com.nodoapi.nodoapi.persistence.entity.ClassObject;
import com.nodoapi.nodoapi.service.ClassObjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
@CrossOrigin(origins = "*")
@Slf4j
public class ClassObjectController {
    private final ClassObjectService classObjectService;

    public ClassObjectController(ClassObjectService classObjectService) {
        this.classObjectService = classObjectService;
    }

    @GetMapping("")
    public ResponseEntity<List<ClassObject>> getAll(){
        return new ResponseEntity<>(classObjectService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassObject> getById(@PathVariable("id")Long id){
        return classObjectService.getById(id).map(classObject -> new ResponseEntity<>(classObject, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<List<ClassObject>> getByIdCourse(@PathVariable("id")Long id){
        return new ResponseEntity<>(classObjectService.getByCourseId(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ClassObject> save(@RequestBody ClassObject classObject){
        return new ResponseEntity<>(classObjectService.save(classObject), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id")Long id){
        if(classObjectService.deleteById(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
