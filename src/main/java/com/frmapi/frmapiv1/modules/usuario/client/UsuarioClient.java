package  com.frmapi.frmapiv1.modules.usuario.client;

import  com.frmapi.frmapiv1.modules.log.dto.LogRequest;
import  com.frmapi.frmapiv1.modules.usuario.dto.UsuarioAutenticado;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    contextId = "usuarioClient",
    name = "usuarioAutenticadoClient",
    url = "${app-config.services.frm-api.url}")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/usuario-autenticado")
    UsuarioAutenticado getUsuarioAutenticado();

    @PostMapping("/api/log")
    void saveLog(@RequestBody LogRequest request);
}