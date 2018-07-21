package com.douglassironi.service;

import com.douglassironi.database.PedidosRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    public PedidoService pedidoService(PedidosRepository pedidosRepository) {
        return new PedidoService(pedidosRepository);
    }
}
