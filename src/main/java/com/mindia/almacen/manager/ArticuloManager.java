package com.mindia.almacen.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mindia.almacen.model.Articulo;
import com.mindia.almacen.model.Proveedor;
import com.mindia.almacen.model.Subcategoria;
import com.mindia.almacen.persistence.ArticuloDB;
import com.mindia.almacen.persistence.EstadoArticuloDB;
import com.mindia.almacen.persistence.ProveedoresDB;
import com.mindia.almacen.persistence.SubcategoriaDB;
import com.mindia.almacen.pojo.ArticuloView;

public class ArticuloManager {

	public static List<Articulo> getAllArticulos() {
		return ArticuloDB.getListadoArticulos();
	}

	public static List<Articulo> getArticulosStock() {
		return ArticuloDB.getArticulosEnStock();
	}

	public static Articulo getArticuloByName(String nombre) {
		return ArticuloDB.getArticuloByNombre(nombre);
	}

	public static List<ArticuloView> getArticulosLikeName(String nombre) {
		if (nombre.length() < 3) {
			return null;
		}

		List<ArticuloView> response = new ArrayList<ArticuloView>();

		for (Articulo art : ArticuloDB.getArticulosLikeNombre(nombre)) {
			ArticuloView articulo = new ArticuloView();

			articulo.setEstado(art.getEstadoarticulo().getNombreEstado());
			articulo.setNombre(art.getNombre());
			articulo.setQr(art.getCodigoQr());
			articulo.setStock(art.getStock());
			articulo.setSubcategoria(art.getSubcategoria().getNombre());
			response.add(articulo);
		}

		return response;
	}

	public static void editArticuloQr(String nombre, String qr) {
		ArticuloDB.editarArticuloQr(nombre, qr);
	}

	public static void editArticuloStock(String id, String cantidad) {
		ArticuloDB.editarArticuloStock(id, cantidad);
	}

	public static void createArticulo(String categoria, String proveedor, String nombre, String stockMinimo,
			String stockMaximo, String costo) {

		if (categoria != null) {
			return;
		}

		Articulo articuloNuevo = new Articulo();

		double costoFloat = -1;
		try {
			costoFloat = Double.parseDouble(costo);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		articuloNuevo.setCosto(costoFloat);

		int stockM = 0;
		try {
			stockM = Integer.parseInt(stockMinimo);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		articuloNuevo.setStockMinimo(stockM);

		int stock = 0;
		try {
			stock = Integer.parseInt(stockMaximo);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		articuloNuevo.setStock(stock);
		Proveedor prov = null;
		if (proveedor.contains("-")) {
			String nombreProv = proveedor.replace("-", "");
			prov = ProveedoresDB.getProveedorByNombre(nombreProv);

		} else {
			prov = ProveedoresDB.getProveedorByStringId(proveedor);

		}
		articuloNuevo.setProveedor(prov);

		articuloNuevo.setNombre(nombre);

		Subcategoria cat = null;
		if (categoria.contains("-")) {
			String input = categoria.replace("-", "");
			cat = SubcategoriaDB.getSubcategoriaByNombre(input);

		} else {
			cat = SubcategoriaDB.getCategoriaById(categoria);
		}

		articuloNuevo.setSubcategoria(cat);

		if (stock > stockM) {
			articuloNuevo.setEstadoarticulo(EstadoArticuloDB.getEstadoById(1));
		} else
			articuloNuevo.setEstadoarticulo(EstadoArticuloDB.getEstadoById(2));

		Date date = new Date();
		articuloNuevo.setFechaAgregado(date);

		String qr = "https://api.qrserver.com/v1/create-qr-code/?data=" + nombre;
		articuloNuevo.setCodigoQr(qr);

		ArticuloDB.agregarArticuloNuevo(articuloNuevo);

	}

	public static void editarArticulo(String ids, String subc, String proveedor, String nombre, String stockMinimoS,
			String stockMaximoS, String costoS) {
		int id = Integer.valueOf(ids);
		double costo = Double.valueOf(costoS);
		int stockMaximo = Integer.valueOf(stockMaximoS);
		int stockMinimo = Integer.valueOf(stockMinimoS);
		if (proveedor.contains("-")) {
			proveedor = proveedor.substring(1);
		}
		if (subc.contains("-")) {
			subc = subc.substring(1);
		}
		ArticuloDB.editarArticulo(id, subc, proveedor, nombre, stockMinimo, stockMaximo, costo);

	}

	public static ArticuloView editArticuloStockByNombre(String nombre, String cantidad) {

		Articulo articulo = ArticuloManager.getArticuloByName(nombre);
		String id = articulo.getArticuloId().toString();
		editArticuloStock(id, cantidad);
		ArticuloView view = new ArticuloView();
		view.setEstado(articulo.getEstadoarticulo().getNombreEstado());
		view.setNombre(articulo.getNombre());
		view.setQr(articulo.getCodigoQr());
		view.setStock(articulo.getStock() + Integer.valueOf(cantidad));
		view.setSubcategoria(articulo.getSubcategoria().getNombre());

		return view;
	}
}
