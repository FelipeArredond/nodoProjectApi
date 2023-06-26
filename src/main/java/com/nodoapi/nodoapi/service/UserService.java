package com.nodoapi.nodoapi.service;

import com.nodoapi.nodoapi.persistence.entity.User;
import com.nodoapi.nodoapi.persistence.repository.CommentRepository;
import com.nodoapi.nodoapi.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return (List<User>) userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
    public boolean deleteById(Long id){
        return userRepository.findById(id).map(user -> {
            userRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
