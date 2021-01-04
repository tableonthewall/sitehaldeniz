package com.denizhal.site.service;

import com.denizhal.site.model.Propose;
import com.denizhal.site.repositories.ProposeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProposeServiceImpl implements ProposeService {
    private final ProposeRepository proposeRepository;

    public ProposeServiceImpl(ProposeRepository proposeRepository) {
        this.proposeRepository = proposeRepository;
    }

    @Override
    public List<Propose> getPropose() {
        return proposeRepository.findAll();
    }

    @Override
    public void savePropose(Propose propose) {
        proposeRepository.save(propose);
    }

    @Override
    public List<Propose> getProposesByProductId(Integer id) {
        return proposeRepository.findAllByProductId(id);
    }

    @Override
    public void delete(Integer id) {
        proposeRepository.deleteById(id);
    }
}
