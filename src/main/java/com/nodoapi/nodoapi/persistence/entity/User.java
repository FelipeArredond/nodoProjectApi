package com.nodoapi.nodoapi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Data
@Entity
@Table(name = "person")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person", nullable = false, unique = true)
    private Long idPerson;
    @Column(name = "id_rol")
    private Long idRol;
    private String name;
    private Integer age;
    private String email;
    private String password;
    @OneToOne
    @JoinColumn(name = "id_rol", insertable = false, updatable = false)
    private Rol rol;
    @OneToOne
    @JoinColumn(name = "id_sub", insertable = false, updatable = false)
    private Sub sub;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Comment> comments;
}
