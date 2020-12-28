package com.denizhal.site.repositories;

import com.denizhal.site.model.Propose;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProposeRepository extends JpaRepository<Propose,Integer> {
    List<Propose> findAllByProductId(Integer id);
}
