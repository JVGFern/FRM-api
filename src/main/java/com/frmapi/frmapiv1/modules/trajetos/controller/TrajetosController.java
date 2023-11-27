package  com.frmapi.frmapiv1.modules.trajetos.controller;

import  com.frmapi.frmapiv1.modules.trajetos.dto.TrajetoDistanciaResponse;
import  com.frmapi.frmapiv1.modules.trajetos.dto.TrajetosPageResponse;
import  com.frmapi.frmapiv1.modules.trajetos.dto.TrajetosVelocidadePageResponse;
import  com.frmapi.frmapiv1.modules.trajetos.service.TrajetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trajetos")
public class TrajetosController {

    @Autowired
    private TrajetoService trajetoService;

    @GetMapping
    public TrajetosPageResponse buscarPorOrigensDestinos(@RequestParam("page") Integer page,
                                                         @RequestParam("size") Integer size) {
        return trajetoService.buscarTodosOsTrajetos(page, size);
    }

    @GetMapping("velocidades")
    public TrajetosVelocidadePageResponse buscarPorVelocidades(@RequestParam("page") Integer page,
                                                               @RequestParam("size") Integer size) {
        return trajetoService.buscarVelocidadesMediasDosTrajetos(page, size);
    }

    @GetMapping("{id}/distancia")
    public TrajetoDistanciaResponse buscarDistanciaPorTrajeto(@PathVariable Integer id) {
        return trajetoService.buscarDistanciaPeloTrajeto(id);
    }
}
