package com.mindia.almacen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.manager.PedidoManager;
import com.mindia.almacen.model.Pedido;
import com.mindia.almacen.pojo.CreatePedidoRequest;
import com.mindia.almacen.pojo.PedidoDetalleView;
import com.mindia.almacen.pojo.PedidoView;

@RestController
public class PedidosController {

	@GetMapping("/pedido")
	public List<PedidoView> getAllPedidos() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		@SuppressWarnings("unchecked")
		String rol = ((List<SimpleGrantedAuthority>) authentication.getAuthorities()).get(0).getAuthority();

		List<Pedido> pedidos = null;

		if (rol.equals("SuperAdmin") || rol.equals("Administrador")) {
			pedidos = PedidoManager.getAllPedidos();
		} else {
			pedidos = PedidoManager.getPedidosUser(authentication.getPrincipal().toString());
		}

		List<PedidoView> views = new ArrayList<PedidoView>();

		for (Pedido pedido : pedidos) {
			PedidoView view = new PedidoView();
			view.setViewId(pedido.getPedidoId().toString());
			view.setEstadoPedido(pedido.getEstadopedido().getNombreEstado());
			view.setFecha(pedido.getFecha().toString());
			view.setObservaciones(pedido.getObservaciones());
			view.setUsuario(pedido.getUsuario().getNombreUsuario());

			views.add(view);
		}

		return views;
	}

	@PostMapping("/pedido")
	public void createPedido(@RequestBody CreatePedidoRequest body) {
		PedidoManager.createPedido(body.getObservaciones(), body.getNombreUsuario(), body.getNombresArticulos(),
				body.getCantidadesArticulos());
	}

	@GetMapping("/pedido/detalle")
	public PedidoDetalleView getAllDetallePedido(@RequestParam("id") int id) {
		return PedidoManager.getPedidoDetalle(id);
	}

	@GetMapping("/pedido/entregar")
	public boolean entregarPedido(@RequestParam("id") String id) {
		return PedidoManager.entregarPedido(id);
	}

	@GetMapping("/pedido/eliminar")
	public void eliminarPedido(@RequestParam("id") String id) {
		PedidoManager.eliminarPedido(id);
	}
}
