package com.nodoapi.nodoapi.persistence.repository;

import com.nodoapi.nodoapi.persistence.entity.Sub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubRepository  extends JpaRepository<Sub,Long> {
}
