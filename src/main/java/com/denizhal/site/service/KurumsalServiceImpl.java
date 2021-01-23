package com.denizhal.site.service;

import com.denizhal.site.model.Kurumsal;
import com.denizhal.site.repositories.KurumsalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
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
        Optional<Kurumsal> optionalKurumsal=kurumsalRepository.findById(id);
        if(!optionalKurumsal.isPresent()){
            log.error("Kurumsal bilgileri bulunamadı : "+id);
        }
        Kurumsal kurumsal=optionalKurumsal.get();
        return kurumsal;
    }

    @Override
    public void save(Kurumsal kurumsal) {
        kurumsalRepository.save(kurumsal);
    }
}
