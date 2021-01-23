package com.denizhal.site.repositories;

import com.denizhal.site.model.HalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HalUserRepository extends JpaRepository<HalUser,Integer> {
}
