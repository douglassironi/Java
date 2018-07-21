package com.douglassironi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoModel {
    private Integer codigo;
    private Integer condicoesPagamentosCodigo;
    private Integer pessoasCodigo;
    private LocalDate dataPedido;
    private String numeroDocumento;
    private String tipoPedido;
    private String status;
}
