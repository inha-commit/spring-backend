package com.example.project.domain.entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Present")
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "UPDATE Present SET deletedAt = CURRENT_TIMESTAMP where id = ?")
public class PresentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 생일 식별 Id
    private Long id;

    // 생일 선물 제품 이름
    @Column(length = 30)
    private String name;
    // 제품 링크
    @Column private String productLink;
    // 펀딩 완료 여부
    @Column private Boolean complete;
    // 펀딩 완료 여부

    @Column private int goal;
    // 펀딩 최종 금액

    @Column private int money;
    // 현재 쌓인 펀딩 금액

    @Lob private String representImage;
    // 대표 이미지
    @Lob private String shortComment;
    // 짧은 한 마디
    @Column private String longComment;
    // 긴 한 마디

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private UserEntity user;

    @OneToMany(mappedBy = "present")
    private List<FundingEntity> fundings;

    /*@OneToMany(mappedBy = "present")
    private List<PresentImageEntity> presentImages;*/
}
