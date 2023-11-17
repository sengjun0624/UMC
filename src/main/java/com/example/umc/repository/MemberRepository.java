package com.example.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {}
