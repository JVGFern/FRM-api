package  com.frmapi.frmapiv1.modules.radar.service;

import  com.frmapi.frmapiv1.config.exception.ValidacaoException;
import  com.frmapi.frmapiv1.modules.acidentes.enums.ETipoVeiculo;
import  com.frmapi.frmapiv1.modules.radar.dto.RadaresVelocidadeResponse;
import  com.frmapi.frmapiv1.modules.radar.dto.TiposPorRadarResponse;
import  com.frmapi.frmapiv1.modules.radar.dto.TiposRadarTotais;
import  com.frmapi.frmapiv1.modules.radar.model.BaseRadares;
import  com.frmapi.frmapiv1.modules.radar.model.Contagens;
import  com.frmapi.frmapiv1.modules.radar.repository.BaseRadaresRepository;
import  com.frmapi.frmapiv1.modules.radar.repository.ContagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static  com.frmapi.frmapiv1.modules.acidentes.enums.ETipoVeiculo.*;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class RadarService {

    private static final Integer TIPO_0 = 0;
    private static final Integer TIPO_1 = 1;
    private static final Integer TIPO_2 = 2;
    private static final Integer TIPO_3 = 3;
    private static final  ValidacaoException RADAR_NAO_ENCONTRADO =
        new ValidacaoException("O radar não foi encontrado");

    @Autowired
    private BaseRadaresRepository baseRadaresRepository;
    @Autowired
    private ContagensRepository contagensRepository;

    public BaseRadares buscarPorId(Integer id) {
        return baseRadaresRepository.findById(id)
            .orElseThrow(() -> RADAR_NAO_ENCONTRADO);
    }

    public BaseRadares buscarPorCodigo(String codigo) {
        return baseRadaresRepository.findByCodigoIgnoreCaseContaining(codigo)
            .orElseThrow(() -> RADAR_NAO_ENCONTRADO);
    }

    public Page<BaseRadares> buscarPorTipos(ETipoVeiculo tipoVeiculo, Integer page, Integer size) {
        var tiposEncontrados = contagensRepository.findByTipo(getTipoVeiculo(tipoVeiculo));
        var codigos = tiposEncontrados
            .stream()
            .map(Contagens::getLocalidade)
            .collect(Collectors.toList());
        var lista = new HashSet<String>();
        codigos.forEach(item -> lista.add(item.toString()));
        return baseRadaresRepository.findByCodigoIn(lista, PageRequest.of(page, size));
    }

    private Integer getTipoVeiculo(ETipoVeiculo tipoVeiculo) {
        if (isEmpty(tipoVeiculo)) {
            throw new ValidacaoException("O tipo de veículo não pode ser vazio");
        }
        return tipoVeiculo.equals(AVIAO)
            ? TIPO_0 : tipoVeiculo.equals(HELICOPTERO)
            ? TIPO_1 : tipoVeiculo.equals(DRONE)
            ? TIPO_2 : TIPO_3;
    }

    public List<TiposPorRadarResponse> buscarTiposPorRadar(Integer codigoRadar) {
        return contagensRepository.findTiposPorRadar(codigoRadar);
    }

    public Page<TiposPorRadarResponse> buscarTiposPorRadarPaginado(Integer page, Integer size) {
        var pageRequest = PageRequest.of(page, size);
        return contagensRepository.findTiposPorRadaresGroupBy(pageRequest);
    }

    public List<TiposRadarTotais> buscarTiposTotais() {
        return contagensRepository.findTipos();
    }

    public List<String> buscarTodasVelocidades() {
        return baseRadaresRepository.findVelocidadeDistinct();
    }

    public Page<BaseRadares> buscarTodosOsRadaresPorVelocidade(Integer velocidade, Integer page, Integer size) {
        var pageRequest = PageRequest.of(page, size);
        return baseRadaresRepository.findByVelocidadeContainingIgnoreCaseOrderByVelocidadeAsc(velocidade.toString(),
            pageRequest);
    }

    public List<RadaresVelocidadeResponse> buscarTodasVelocidadesPorRadares() {
        return  baseRadaresRepository.findTotalRadaresByVelocidade();
    }

    public Page<BaseRadares> buscarRadaresPaginados(Integer page, Integer size) {
        return baseRadaresRepository.findAll(PageRequest.of(page, size));
    }
}