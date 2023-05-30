package com.nodoapi.nodoapi.service;

import com.nodoapi.nodoapi.persistence.entity.ClassObject;
import com.nodoapi.nodoapi.persistence.repository.ClassObjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassObjectService {
    private final ClassObjectRepository classObjectRepository;

    public ClassObjectService(ClassObjectRepository classObjectRepository) {
        this.classObjectRepository = classObjectRepository;
    }

    public List<ClassObject> getAll(){
        return (List<ClassObject>) classObjectRepository.findAll();
    }

    public Optional<ClassObject> getById(Long id){
        return classObjectRepository.findById(id);
    }

    public List<ClassObject> getByCourseId(Long id){
        return classObjectRepository.findAllByIdCourse(id);
    }

    public ClassObject save(ClassObject classObject){
        return classObjectRepository.save(classObject);
    }

    public boolean deleteById(Long id){
        return classObjectRepository.findById(id).map(classObject -> {
            classObjectRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
