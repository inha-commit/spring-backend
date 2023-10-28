package com.example.project.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String snsId;

    @Column(length = 30, unique = true)
    private String nickname;

    @Column(length = 8)
    private String birthday;

    private String profileImgSrc;

    @Column(unique = true)
    private String fcmId;

    private Boolean alarm = true;

    /*@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at")
    private Date deletedAt;

    @ManyToMany
    @JoinTable(
    	name = "Follow",
    	joinColumns = @JoinColumn(name = "FollowingId", referencedColumnName = "id"),
    	inverseJoinColumns = @JoinColumn(name = "FollwerId", referencedColumnName = "id")
    )
    private List<UserEntity> followers;

    @ManyToMany(mappedBy = "followers")
    private List<UserEntity> followings;

    @OneToMany(mappedBy = "user")
    private List<PresentEntity> presents;

    @OneToMany(mappedBy = "sender")
    private List<FundingEntity> funding;

    @OneToMany(mappedBy = "receiver")
    private List<FundingEntity> funded;*/

}
