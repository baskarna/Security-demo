package com.bk.SecuDemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecRepo extends  JpaRepository<Users,Long> {
    Users findByUsername(String username);
}
