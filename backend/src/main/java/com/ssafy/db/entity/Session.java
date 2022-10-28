package com.ssafy.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //new 막음
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sessionId;

    private String name;
    @Column(nullable = false, name = "create_time")
    private LocalDateTime createTime;
    @Column(nullable = false, name = "expire_time")
    private LocalDateTime expireTime;
    @Column(nullable = false)
    private LocalDate anniversary;

    /* Session Message */
    @OneToMany(mappedBy = "session")
    private List<SessionMessage> sessionMessagesList = new ArrayList<>();

    /* User */
    @ManyToOne(fetch=LAZY)
    @JoinColumn(name = "userId")
    private User user;

    /* Type */
    @ManyToOne(fetch=LAZY)
    @JoinColumn(name = "sessionTypeId")
    private SessionType sessionType;


    public void setUser(User user){
        this.user =user;
        //무한 루프 주의
        if(!user.getSessionsList().contains(this)){
            user.getSessionsList().add(this);
        }
    }

    public void setSessionType(SessionType sessionType){
        this.sessionType = sessionType;
        //무한 루프 주의
        if(!sessionType.getSessionsList().contains(this)){
            sessionType.getSessionsList().add(this);
        }
    }

    @Builder
    public Session(String name, LocalDateTime createTime, LocalDateTime expireTime, LocalDate anniversary, User user, SessionType sessionType) {
        this.name = name;
        this.createTime = createTime;
        this.expireTime = expireTime;
        this.anniversary = anniversary;
        this.user = user;
        this.sessionType = sessionType;
    }
}
