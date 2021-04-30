package com.mindia.almacen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindia.almacen.manager.ArticuloManager;
import com.mindia.almacen.model.Articulo;
import com.mindia.almacen.pojo.ArticuloView;


@RestController
public class ArticulosController {
	
	@GetMapping("/articulos")
	public List<ArticuloView> getAllArticulos() {
		List<ArticuloView> response = new ArrayList<ArticuloView>();
		
		for(Articulo art : ArticuloManager.getAllArticulos()) {
			ArticuloView articulo = new ArticuloView();
			
			articulo.setEstado(art.getEstadoarticulo().getNombreEstado());
			articulo.setNombre(art.getNombre());
			articulo.setQr(art.getCodigoQr());
			articulo.setStock(art.getStock());
			articulo.setSubcategoria(art.getSubcategoria().getSubNombre());
			response.add(articulo);
		}
		
		return response;
	}
}
