package com.douglassironi.service;


import com.douglassironi.model.PedidoModel;
import com.douglassironi.database.PedidosRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PedidoService {
    private PedidosRepository pedidosRepository;

    public List<PedidoModel> getPedidos() {
        return pedidosRepository.getPedidos();
    }

    public List<PedidoModel> getPedido(Integer codigo){
        return  pedidosRepository.getPedido(codigo);
    }


}
