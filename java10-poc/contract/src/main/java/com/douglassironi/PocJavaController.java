package com.douglassironi;


import com.douglassironi.model.PedidoModel;
import com.douglassironi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("poc-java")
public class PocJavaController {
    @Autowired
    PedidoService pedidoService;

    @GetMapping(path = "/pedido", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PedidoModel> getPedido() {
        return pedidoService.getPedidos();
    }


    @GetMapping(path = "/pedido/{codigo}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PedidoModel> getPedido(@PathVariable("codigo") Integer codigo) {
        return pedidoService.getPedido(codigo);
    }

    @GetMapping(path = "/busca",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String buscar() {
        return  "Hello World";
    }
}
