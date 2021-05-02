package com.mindia.almacen.manager;

import java.util.ArrayList;
import java.util.List;

import com.mindia.almacen.model.Categoria;
import com.mindia.almacen.model.Subcategoria;
import com.mindia.almacen.persistence.SubcategoriaDB;
import com.mindia.almacen.pojo.CategoriaView;
import com.mindia.almacen.pojo.SubcategoriaView;

public class CategoriaManager {

	public static List<CategoriaView> getAllCategorias(){
		List<CategoriaView> categoriasView = new ArrayList<CategoriaView>();
		
		
		//Pasamos del model a la vista.
		for(Categoria categoria : SubcategoriaDB.getCategorias()) {
			CategoriaView view = new CategoriaView();
			
			view.setNombre(categoria.getNombre());
			
			List<SubcategoriaView> subcategoriaViews = new ArrayList<SubcategoriaView>();
			for (Subcategoria subcategoria: categoria.getSubcategorias()) {
				SubcategoriaView subcategoriaView = new SubcategoriaView();
				
				subcategoriaView.setNombre(subcategoria.getSubNombre());
				
				subcategoriaViews.add(subcategoriaView);
			}
			view.setSubcategorias(subcategoriaViews);
			
			categoriasView.add(view);
		}
		
		return categoriasView;
	}
}
