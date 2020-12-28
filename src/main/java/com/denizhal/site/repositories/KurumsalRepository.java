package com.denizhal.site.repositories;

import com.denizhal.site.model.Kurumsal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KurumsalRepository extends JpaRepository<Kurumsal,Integer> {
    Kurumsal findFirstByOrderByIdDesc();
}
