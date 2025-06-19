package com.PruebaLP2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
/*models*/
import com.PruebaLP2.Models.*;
import com.PruebaLP2.Repositories.*;

@Controller
public class ControllerNarazas {

	
	@Autowired
	IProductoRepository _prod;
	
	@Autowired
	IInventarioRepository _inve;
	
	@Autowired
	ICategoriaRepository _cate;
	
	
	
	@GetMapping("/ListadoNarazasGarcia")
	public String Listado(Model model) {
		List<Producto> lstProducto = _prod.findAll();
		List<Inventario> lstInventario = _inve.findAll();
		List<Categoria> lstCategoria = _cate.findAll();
		
		model.addAttribute("lstInventario", lstInventario);
		model.addAttribute("lstProducto", lstProducto);
		model.addAttribute("lstCategoria", lstCategoria);
		
		return("Inventarios/ListadoNarazasGarcia");
	}
	
}
