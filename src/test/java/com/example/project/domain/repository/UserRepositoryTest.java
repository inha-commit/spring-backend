package com.example.project.domain.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.project.domain.entity.UserEntity;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @Test
    @DisplayName("Auditing 기능 적용")
    void findUser() {
        // given
        UserEntity user =
                UserEntity.builder()
                        .nickname("user")
                        .snsId("sengjun0624")
                        .birthday("20000624")
                        .build();

        // when
        UserEntity savedUser = userRepository.save(user);

        // then
        assertNotNull(savedUser.getCreatedAt());
        assertNotNull(savedUser.getUpdatedAt());
    }
}
