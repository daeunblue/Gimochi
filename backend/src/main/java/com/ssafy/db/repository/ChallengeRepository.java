package com.ssafy.db.repository;

import com.ssafy.db.entity.Challenge;
import com.ssafy.db.entity.SessionType;
import com.ssafy.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    Optional<Challenge> findByChallengeId(Long challengeId);
    //Optional<Challenge> findChallengeByChallengeUserId(Long challengeUserId);
    Optional<User> findByChallengeLeaderId(Long challengeLeaderId);



//    Optional<List<Challenge>> findChallengeListByChallengeIdList(List<Long> challengeIdList);

    Optional<String> findChallengeLeaderNameByChallengeId(Long id);

    Optional<String> findChallengeTitleByChallengeId(Long id);
}
