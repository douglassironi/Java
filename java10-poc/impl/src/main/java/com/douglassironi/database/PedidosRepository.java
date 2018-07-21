package com.douglassironi.database;


import com.douglassironi.model.PedidoModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PedidosRepository {
    @Select("Select * from pedidos")
    @Results(value = {
            @Result(property = "codigo",column = "codigo"),
            @Result(property = "condicoesPagamentosCodigo",column = "condicoes_pagamentos_codigo"),
            @Result(property = "pessoasCodigo",column = "pessoas_codigo"),
            @Result(property = "dataPedido",column = "data_pedido"),
            @Result(property = "numeroDocumento",column = "numero_documento"),
            @Result(property = "tipoPedido",column = "tipo_pedido"),
            @Result(property = "status",column = "status")

    })
    List<PedidoModel> getPedidos();

    @Select({"Select * from pedidos where codigo = #{codigo, jdbcType=NUMERIC}"})
    @Results(value = {
            @Result(property = "codigo",column = "codigo"),
            @Result(property = "condicoesPagamentosCodigo",column = "condicoes_pagamentos_codigo"),
            @Result(property = "pessoasCodigo",column = "pessoas_codigo"),
            @Result(property = "dataPedido",column = "data_pedido"),
            @Result(property = "numeroDocumento",column = "numero_documento"),
            @Result(property = "tipoPedido",column = "tipo_pedido"),
            @Result(property = "status",column = "status")

    })
    List<PedidoModel> getPedido(Integer codigo);

}


