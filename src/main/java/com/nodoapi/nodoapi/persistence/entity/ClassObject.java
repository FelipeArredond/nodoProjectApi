package com.nodoapi.nodoapi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "class")
public class ClassObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class")
    private Long idClass;
    private String title;
    private String video;
    @Column(name = "id_course")
    private Long idCourse;
    @ManyToOne()
    @JoinColumn(name = "id_course", insertable = false, updatable = false)
    private Course course;
    @OneToMany(mappedBy = "classObject")
    @JsonIgnore
    private List<Comment> comments;
}
