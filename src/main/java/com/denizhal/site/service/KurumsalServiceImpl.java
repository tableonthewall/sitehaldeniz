package com.denizhal.site.service;

import com.denizhal.site.model.Kurumsal;
import com.denizhal.site.repositories.KurumsalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KurumsalServiceImpl implements KurumsalService {

    private final KurumsalRepository kurumsalRepository;

    public KurumsalServiceImpl(KurumsalRepository kurumsalRepository) {
        this.kurumsalRepository = kurumsalRepository;
    }

    @Override
    public Kurumsal getKurumsal() {
        return kurumsalRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Kurumsal getKurumsalById(Integer id) {
        return kurumsalRepository.findById(id).get();
    }

    @Override
    public void save(Kurumsal kurumsal) {
        kurumsalRepository.save(kurumsal);
    }
}
