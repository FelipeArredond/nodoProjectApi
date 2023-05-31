package com.nodoapi.nodoapi.controller;

import com.nodoapi.nodoapi.persistence.entity.Comment;
import com.nodoapi.nodoapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "*")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }
    @GetMapping("")
    public ResponseEntity<List<Comment>> getAll(){
        return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") Long id){
        return commentService.getCommentById(id).map(comment -> new ResponseEntity<>(comment, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Comment>> getByUserId(@PathVariable("id")Long id){
        return new ResponseEntity<>(commentService.getCommentByUserId(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Comment> save(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.save(comment), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id")Long id){
        if(commentService.deleteById(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
