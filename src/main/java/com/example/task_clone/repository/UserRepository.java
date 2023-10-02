package com.example.task_clone.repository;

import com.example.task_clone.model.entity.Position;
import com.example.task_clone.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT p FROM User u JOIN u.positionList p WHERE p.id = :posid")
    List<Position> findPositionById(@Param("posid") Long posid);


    boolean existsByUsername(String email);

    User findByUuid(UUID uuid);

}
