package  com.frmapi.frmapiv1.modules.log.enums;

import lombok.Getter;

public enum ETipoOperacao {

    CONSULTANDO("CONSULTANDO"),
    SALVANDO("SALVANDO"),
    ALTERANDO("ALTERANDO"),
    REMOVENDO("REMOVENDO");

    @Getter
    private String operacao;

    ETipoOperacao(String operacao) {
        this.operacao = operacao;
    }
}
