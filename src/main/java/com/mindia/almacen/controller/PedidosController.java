package com.mindia.almacen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.manager.PedidoManager;
import com.mindia.almacen.model.Pedido;
import com.mindia.almacen.pojo.PedidoView;

@RestController
public class PedidosController {

	@GetMapping("/pedidos")
	public List<PedidoView> getAllPedidos() {
		List<PedidoView> views = new ArrayList<PedidoView>();
		
		for(Pedido pedido : PedidoManager.getAllPedidos()) {
			PedidoView view = new PedidoView();
			view.setEstadoPedido(pedido.getEstadopedido().getNombreEstado());
			view.setFecha(pedido.getFecha().toString());
			view.setObservaciones(pedido.getObservaciones());
			view.setUsuario(pedido.getUsuario().getNombreUsuario());
			
			views.add(view);
		}
		
		return views;
	}
}
