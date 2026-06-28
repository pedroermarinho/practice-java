package mx.florinda.notafiscal;

import java.math.BigDecimal;

public class PagamentoConfirmadoEvent {

    public Long pagamentoId;
    public Long pedidoId;
    public BigDecimal valor;

    @Override
    public String toString() {
        return "PagamentoConfirmadoEvent{" +
                "pagamentoId=" + pagamentoId +
                ", pedidoId=" + pedidoId +
                ", valor=" + valor +
                '}';
    }

}
