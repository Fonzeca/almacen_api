package com.mindia.almacen.manager;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.mindia.almacen.model.Pedido;
import com.mindia.almacen.persistence.ArticuloPedidoDB;
import com.mindia.almacen.persistence.EstadoPedidoDB;
import com.mindia.almacen.persistence.PedidoDB;
import com.mindia.almacen.persistence.UsuarioDB;
import com.mindia.almacen.pojo.ActualizarStockAxP;
import com.mindia.almacen.pojo.ArticuloPedidoView;
import com.mindia.almacen.pojo.PedidoDetalleView;

public class PedidoManager {

	public static List<Pedido> getAllPedidos() {
		return PedidoDB.getPedidosCompleto();
	}

	public static List<Pedido> getPedidosUser(String username) {
		return PedidoDB.getPedidosIndividual(username);
	}

	public static PedidoDetalleView getPedidoDetalle(int pedidoId) {
		PedidoDetalleView view = new PedidoDetalleView();

		var detalles = ArticuloPedidoDB.getArticulosPedidosByPedido(pedidoId);

		var pedido = PedidoDB.getPedidoByID(pedidoId);

		view.setPedidoId(pedidoId);
		view.setObservaciones(pedido.getObservaciones());
		view.setUsuario(pedido.getUsuario().getNombreUsuario());
		view.setEstadopedido(pedido.getEstadopedido().getNombreEstado());

		var detallesView = detalles.stream().map(x -> {
			ArticuloPedidoView detalleView = new ArticuloPedidoView();

			detalleView.setArticuloId(x.getArticulo().getArticuloId());
			detalleView.setCantidad(x.getCantidad());
			detalleView.setNombre(x.getArticulo().getNombre());

			return detalleView;
		}).collect(Collectors.toList());

		view.setPedidos(detallesView);

		return view;
	}

	public static int createPedido(String obser, String user, String arts, String cants) {
		Pedido pedido = new Pedido();
		pedido.setObservaciones(obser);
		pedido.setFecha(new Date());

//		int idU = Integer.parseInt(user);
		pedido.setUsuario(UsuarioDB.getUsuarioByNombreUsuario(user));

		int idEstado = 1;
		pedido.setEstadopedido(EstadoPedidoDB.getEstadoById(idEstado));

		Serializable id = PedidoDB.crearPedido(pedido);

		int idP = (int) id;

		String[] articulos = arts.split(" - ");
		String[] cantidades = cants.split(" - ");
		for (int i = 0; i < articulos.length; i++) {
			ArticuloPedidoDB.crearArticuloPedido(cantidades[i], articulos[i], idP);
		}
		return idP;

	}

	public static ActualizarStockAxP entregarPedido(String id) {

		return PedidoDB.entregaPedido(toInt(id));
	}

	public static void eliminarPedido(String id) {
		PedidoDB.eliminarPedidoById(toInt(id));
	}

	private static int toInt(String id) {
		int ids = Integer.parseInt(id);
		return ids;
	}

	public static void editarPedido(String id, String estado, String cantidades, String nombres, String observaciones) {
		String[] cantidad = cantidades.split(",");
		String[] nombre = nombres.split(",");
		int idP = toInt(id);
		ArticuloPedidoDB.editarArticulosPedidos(idP, cantidad, nombre);
		PedidoDB.editarPedido(idP, estado, observaciones);
	}

}
