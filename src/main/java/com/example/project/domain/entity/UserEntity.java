package com.example.project.domain.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "User")
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "UPDATE User SET deletedAt = CURRENT_TIMESTAMP where id = ?")
public class UserEntity extends BaseEntity {

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

    @Builder
    public UserEntity(
            Long id,
            String snsId,
            String nickname,
            String birthday,
            String profileImgSrc,
            String fcmId,
            Boolean alarm) {
        this.id = id;
        this.snsId = snsId;
        this.nickname = nickname;
        this.birthday = birthday;
        this.profileImgSrc = profileImgSrc;
        this.fcmId = fcmId;
        this.alarm = alarm;
    }

    /*
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
