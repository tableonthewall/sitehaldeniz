package com.denizhal.site.service;

import com.denizhal.site.model.Propose;

import java.util.List;

public interface ProposeService {
    List<Propose> getPropose();
    void savePropose(Propose propose);
    List<Propose> getProposesByProductId(Integer id);
    void delete(Integer id);
}
