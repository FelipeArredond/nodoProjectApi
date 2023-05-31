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
    @Column(name = "id_school")
    private Long idSchool;
    private String name;
    private String image;
    private String description;
    private String duration;
    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<ClassObject> classes;
    @ManyToOne
    @JoinColumn(name = "id_school", insertable = false, updatable = false)
    private School school;
}
