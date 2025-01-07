package com.example.mixlive.jpa;

import com.example.mixlive.model.PlatformType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlatformCategoryRepository extends JpaRepository<PlatformCategory, PlatformType> {
    Optional<PlatformCategory> findByPlatformType(PlatformType platformType);

    boolean existsByPlatformType(PlatformType platformType);
}