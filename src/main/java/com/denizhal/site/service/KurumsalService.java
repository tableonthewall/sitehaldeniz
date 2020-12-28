package com.denizhal.site.service;

import com.denizhal.site.model.Kurumsal;

public interface KurumsalService {
    Kurumsal getKurumsal();
    Kurumsal getKurumsalById(Integer id);
    void save(Kurumsal kurumsal);
}
