package com.nodoapi.nodoapi.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComment;
    private String comment;
    private LocalDateTime date;
    @Column(name = "id_person")
    private Long idPerson;
    @ManyToOne()
    @JoinColumn(name = "id_person", insertable = false, updatable = false)
    private User user;
    @ManyToOne()
    @JoinColumn(name = "id_class", insertable = false, updatable = false)
    private ClassObject classObject;
}
