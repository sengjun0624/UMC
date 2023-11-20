package com.example.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {}
