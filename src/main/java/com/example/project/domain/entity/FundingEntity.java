package com.example.project.domain.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Funding")
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "UPDATE Funding SET deleted_at = CURRENT_TIMESTAMP where id = ?")
public class FundingEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column private int cost;

    @Column(columnDefinition = "text")
    private String comment;

    //	@ManyToOne
    //	@JoinColumn(name = "PresentId", referencedColumnName = "id")
    //	private PresentEntity present;
    //
    //	@ManyToOne
    //	@JoinColumn(name = "SenderId", referencedColumnName = "id")
    //	private UserEntity sender;
    //
    //	@ManyToOne
    //	@JoinColumn(name = "ReceiverId", referencedColumnName = "id")
    //	private UserEntity receiver;
    //
    //	// 생성자, 게터, 세터, 그리고 다른 메서드는 생략하였습니다.
}
