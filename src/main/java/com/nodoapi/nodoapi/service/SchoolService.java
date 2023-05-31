package com.nodoapi.nodoapi.service;

import com.nodoapi.nodoapi.persistence.entity.School;
import com.nodoapi.nodoapi.persistence.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getAll(){
        return (List<School>) schoolRepository.findAll();
    }

    public Optional<School> getById(Long id){
        return schoolRepository.findById(id);
    }

    public School save(School school){
        return schoolRepository.save(school);
    }

    public boolean deleteById(Long id){
        return schoolRepository.findById(id).map(school -> {
            schoolRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
