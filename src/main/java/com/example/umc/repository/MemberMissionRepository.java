package com.example.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {}
