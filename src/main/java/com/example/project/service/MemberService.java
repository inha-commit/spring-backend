package com.example.project.service;

import org.springframework.stereotype.Service;

import com.example.project.dto.MemberDto;
import com.example.project.entity.MemberEntity;
import com.example.project.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final int id = 1;

    public void save(MemberDto memberDto) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDto);
        memberRepository.save(memberEntity);
    }
}
