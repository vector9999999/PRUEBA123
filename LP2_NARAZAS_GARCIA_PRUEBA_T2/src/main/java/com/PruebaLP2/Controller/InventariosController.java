package com.PruebaLP2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.PruebaLP2.Models.Categoria;
import com.PruebaLP2.Models.Inventario;
import com.PruebaLP2.Models.Producto;
import com.PruebaLP2.Repositories.ICategoriaRepository;
import com.PruebaLP2.Repositories.IInventarioRepository;
import com.PruebaLP2.Repositories.IProductoRepository;
import com.PruebaLP2.utils.Alert;


@Controller
@RequestMapping("/Inventarios")
public class InventariosController {
	@Autowired
	IProductoRepository _prod;
	
	@Autowired
	IInventarioRepository _inve;
	
	@Autowired
	ICategoriaRepository _cate;
	
	
	
	@GetMapping("/ListadoNarazasVictor")
	public String Listado(Model model) {
		
		List<Inventario> lstInventario = _inve.listaInventario();
		model.addAttribute("lstInventario",lstInventario);
		
		return("Inventarios/ListadoNarazasVictor");
	}
	
	
	@GetMapping("/nuevoNarazas")
	public String nuevoProducto(Model model) {
		model.addAttribute("lstProducto", _prod.findAll());
		model.addAttribute("lstCategoria", _cate.findAll());
		model.addAttribute("inventario", new Inventario());
		
		return("Inventarios/nuevoNarazas");
	}
	
	
	@PostMapping("/registroNarazas")
	public String nuevoProductoConfirmacion(@ModelAttribute  Inventario inven,Model model, RedirectAttributes flash) {
		Inventario invGuardado = _inve.save(inven); 
		model.addAttribute("lstProducto", _prod.findAll());
		model.addAttribute("lstCategoria", _cate.findAll());
		
		String mensaje = Alert.sweetAlertSuccess("El producto con codigo " + invGuardado.getNumero() +"fue guardo exitossamente");
		flash.addFlashAttribute("alert",mensaje);
		return ("redirect:/Inventarios/ListadoNarazasVictor");
	}
	
	
}
