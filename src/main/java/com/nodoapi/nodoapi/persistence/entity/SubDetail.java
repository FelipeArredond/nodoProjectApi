package com.nodoapi.nodoapi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "sub_detail")
public class SubDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_detail")
    private Long idSubDetail;
    @Column(name = "id_sub")
    private Long idSub;
    @Column(name = "id_person")
    private Long idPerson;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @OneToOne
    @JoinColumn(name = "id_person", insertable = false, updatable = false)
    private User user;
    @OneToOne
    @JoinColumn(name = "id_sub", insertable = false, updatable = false)
    private Sub sub;
}
