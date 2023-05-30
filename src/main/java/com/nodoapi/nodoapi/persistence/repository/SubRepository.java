package com.nodoapi.nodoapi.persistence.repository;

import com.nodoapi.nodoapi.persistence.entity.Sub;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubRepository  extends CrudRepository<Sub,Long> {
}
