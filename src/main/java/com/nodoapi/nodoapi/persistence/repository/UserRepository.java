package com.nodoapi.nodoapi.persistence.repository;

import com.nodoapi.nodoapi.persistence.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM person WHERE id_person = ?1", nativeQuery = true)
    void deleteUserById(Long id);
}
