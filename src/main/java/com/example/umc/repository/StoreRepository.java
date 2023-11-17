package com.example.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {}
