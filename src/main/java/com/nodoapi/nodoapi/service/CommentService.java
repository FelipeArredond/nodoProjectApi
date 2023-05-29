package com.nodoapi.nodoapi.service;

import com.nodoapi.nodoapi.persistence.entity.Comment;
import com.nodoapi.nodoapi.persistence.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public List<Comment> getAll(){
        return (List<Comment>) commentRepository.findAll();
    }
    public Optional<Comment> getCommentById(Long id){
        return commentRepository.findById(id);
    }
    public List<Comment> getCommentByUserId(Long id){
        return commentRepository.findAllByIdPerson(id);
    }
    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }
    public boolean deleteById(Long id){
        if(commentRepository.findById(id).map(comment -> true).orElse(false)){
            commentRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
