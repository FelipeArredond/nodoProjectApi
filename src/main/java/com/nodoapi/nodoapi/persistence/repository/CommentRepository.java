package com.nodoapi.nodoapi.persistence.repository;

import com.nodoapi.nodoapi.persistence.entity.Comment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByIdPerson(Long id);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM comment WHERE id_comment = ?1", nativeQuery = true)
    void deleteUserById(Long id);
}
