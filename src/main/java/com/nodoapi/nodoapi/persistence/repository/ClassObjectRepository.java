package com.nodoapi.nodoapi.persistence.repository;

import com.nodoapi.nodoapi.persistence.entity.ClassObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassObjectRepository extends CrudRepository<ClassObject, Long> {
    List<ClassObject> findAllByIdCourse(Long id);
}
