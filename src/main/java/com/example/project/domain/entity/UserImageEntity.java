package com.example.project.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserImage")
public class UserImageEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column private String src;

    @OneToOne
    @JoinColumn(name = "UserId", referencedColumnName = "id")
    private UserEntity user;

    public UserImageEntity() {}

    // 생성자, 게터, 세터, 기타 메서드 생략
}
