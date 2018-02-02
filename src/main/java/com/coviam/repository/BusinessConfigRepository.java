package com.coviam.repository;

import com.coviam.entity.model.BusinessConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessConfigRepository extends JpaRepository<BusinessConfig,Long> {
}
