package com.nodoapi.nodoapi.persistence.repository;

import com.nodoapi.nodoapi.persistence.entity.Course;
import com.nodoapi.nodoapi.persistence.entity.School;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository testRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    @AfterEach
    void tearDown(){
        this.testRepository.deleteAll();
        this.schoolRepository.deleteAll();
    }

    @Test
    void canFindAllByIdSchool(){
        // given
        Long id = 1L;
        List<Course> testList = new ArrayList<>();
        this.schoolRepository.save(School.builder().idSchool(1L).name("Test").build());
        Course itemToAdd1 = Course.builder().name("Test").idSchool(1L).build();
        Course itemToAdd2 = Course.builder().name("Test").idSchool(1L).build();
        Course itemToAdd3 = Course.builder().name("Test").idSchool(1L).build();
        testList.add(itemToAdd1);
        testList.add(itemToAdd2);
        testList.add(itemToAdd3);
        this.testRepository.saveAll(testList);
        // when
        List<Course> result =  this.testRepository.findAllByIdSchool(id);
        // then
        assertThat(result).isEqualTo(testList);
    }

}