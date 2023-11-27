package  com.frmapi.frmapiv1.modules.radar.service;

import  com.frmapi.frmapiv1.modules.radar.model.BaseRadares;
import  com.frmapi.frmapiv1.modules.radar.repository.BaseRadaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcessaoService {

    @Autowired
    private BaseRadaresRepository baseRadaresRepository;

    public Page<BaseRadares> buscarPorLote(Integer lote, Integer page, Integer size) {
        return baseRadaresRepository.findByLote(lote, PageRequest.of(page, size));
    }

    public List<Integer> buscarLotes() {
        return baseRadaresRepository.findLoteDistict();
    }
}
