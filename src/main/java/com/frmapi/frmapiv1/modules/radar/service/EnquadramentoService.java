package  com.frmapi.frmapiv1.modules.radar.service;

import  com.frmapi.frmapiv1.modules.radar.model.BaseRadares;
import  com.frmapi.frmapiv1.modules.radar.repository.BaseRadaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquadramentoService {

    @Autowired
    private BaseRadaresRepository baseRadaresRepository;

    public List<String> buscarEnquadramentos() {
        return baseRadaresRepository.findEnquadramentoDistict();
    }

    public Page<BaseRadares> buscarPorEnquadramento(String enquadramento, Integer page, Integer size) {
        return baseRadaresRepository.findByEnquadrame(enquadramento, PageRequest.of(page, size));
    }
}
