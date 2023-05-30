package com.nodoapi.nodoapi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sub")
public class Sub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub")
    private Long idSub;
    private String state;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @OneToOne(mappedBy = "sub")
    @JsonIgnore
    private User user;
    private String type;
}
