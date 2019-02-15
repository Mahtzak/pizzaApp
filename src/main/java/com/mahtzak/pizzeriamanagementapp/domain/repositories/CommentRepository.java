package com.mahtzak.pizzeriamanagementapp.domain.repositories;

import com.mahtzak.pizzeriamanagementapp.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query("SELECT c FROM Comment c ORDER BY c.created DESC")
    List<Comment> getAllComments();
}
