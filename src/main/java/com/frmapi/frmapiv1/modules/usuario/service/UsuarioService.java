package  com.frmapi.frmapiv1.modules.usuario.service;

import  com.frmapi.frmapiv1.modules.log.dto.LogRequest;
import  com.frmapi.frmapiv1.modules.usuario.client.UsuarioClient;
import  com.frmapi.frmapiv1.modules.usuario.dto.UsuarioAutenticado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioClient usuarioClient;

    public UsuarioAutenticado getUsuarioAutenticado() {
        return usuarioClient.getUsuarioAutenticado();
    }

    public void enviarLogUsuario(LogRequest request) {
        usuarioClient.saveLog(request);
    }
}
