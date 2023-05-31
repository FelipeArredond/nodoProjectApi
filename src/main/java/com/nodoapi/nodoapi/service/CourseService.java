package com.nodoapi.nodoapi.service;

import com.nodoapi.nodoapi.persistence.entity.Course;
import com.nodoapi.nodoapi.persistence.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAll(){
        return (List<Course>) courseRepository.findAll();
    }

    public Optional<Course> getById(Long id){
        return courseRepository.findById(id);
    }

    public Course save(Course course){
        return courseRepository.save(course);
    }

    public boolean deleteById(Long id){
        return courseRepository.findById(id).map(course -> {
            courseRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    public List<Course> getBySchool(Long id) {
        return courseRepository.findAllByIdSchool(id);
    }
}
