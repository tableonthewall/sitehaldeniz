package com.denizhal.site.service;

import com.denizhal.site.model.GenelBilgiler;
import com.denizhal.site.repositories.GenelBilgilerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class GenelBilgilerServiceImpl implements GenelBilgilerService {
    private final GenelBilgilerRepository genelBilgilerRepository;

    public GenelBilgilerServiceImpl(GenelBilgilerRepository genelBilgilerRepository) {
        this.genelBilgilerRepository = genelBilgilerRepository;
    }

    @Override
    public GenelBilgiler getGenelBilgiler(Integer id) {
        Optional<GenelBilgiler> genelBilgilerOptional=genelBilgilerRepository.findById(id);
        if(!genelBilgilerOptional.isPresent()){
            log.error("Genel bilgileri bulunmamaktadır. :"+id);
        }
        GenelBilgiler genelBilgiler=genelBilgilerOptional.get();
        return genelBilgiler;
    }
}
