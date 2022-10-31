package com.ssafy.db.repository;

import com.ssafy.db.entity.Challenge;
import com.ssafy.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    //Optional<User> findByChallengeId();
}