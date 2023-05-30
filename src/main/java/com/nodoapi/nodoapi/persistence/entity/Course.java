package com.nodoapi.nodoapi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long idCourse;
    private String name;
    private String description;
    private String duration;
    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<ClassObject> classes;
}
