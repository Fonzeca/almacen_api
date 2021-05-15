package com.mindia.almacen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.manager.ArticuloManager;
import com.mindia.almacen.model.Articulo;
import com.mindia.almacen.pojo.ArticuloView;

@RestController
public class ArticulosController {

	@GetMapping("/articulo")
	public List<ArticuloView> getAllArticulos() {
		List<ArticuloView> response = new ArrayList<ArticuloView>();

		for (Articulo art : ArticuloManager.getAllArticulos()) {
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

	@GetMapping("/articulo/{nombre}")
	public ArticuloView getArticuloByName(@PathVariable("nombre") String nombre) {
		ArticuloView articuloView = new ArticuloView();

		Articulo articulo = ArticuloManager.getArticuloByName(nombre);
		articuloView.setEstado(articulo.getEstadoarticulo().getNombreEstado());
		articuloView.setNombre(articulo.getNombre());
		articuloView.setQr(articulo.getCodigoQr());
		articuloView.setStock(articulo.getStock());
		articuloView.setSubcategoria(articulo.getSubcategoria().getNombre());

		return articuloView;
	}

	@GetMapping("/articulo/like/{nombre}")
	public List<ArticuloView> getArticuloLikeName(@PathVariable("nombre") String nombre) {
		return ArticuloManager.getArticulosLikeName(nombre);
	}

	@GetMapping("/articulo/stock")
	public ArticuloView agregarStockArticulo(@RequestParam("nombre") String nombre,
			@RequestParam("cantidad") String cantidad) {
		return ArticuloManager.editArticuloStockByNombre(nombre, cantidad);
	}
}
