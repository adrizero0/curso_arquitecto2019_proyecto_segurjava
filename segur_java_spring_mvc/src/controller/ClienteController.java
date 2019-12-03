package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Cliente;
import model.Contrato;
import service.ServiceCliente;


@Controller
public class ClienteController {
	@Autowired
	ServiceCliente sClientes;

//	@RequestMapping(value="/doLogin", method = {RequestMethod.GET,RequestMethod.POST})
//	public String login(@RequestParam("dni") String dni, 
//						@RequestParam("password")String password,
//						HttpServletRequest request,
//						Model model) {
//		Cliente cliente=sClientes.validar(dni, password);
//		if(cliente!=null) {
//			String permiso=sClientes.autorizar(dni, password);
//			System.out.println("Estamos en el controller. Permiso del usuario es: "+permiso);
//			model.addAttribute("cliente", cliente);
//			List<Contrato> contratos=sClientes.obtenerListaContratos(cliente.getDni());
//			request.setAttribute("contratos", contratos);
//			System.out.println("La lista de contratos es: "+contratos);
//			return permiso;
//		}else {
//			return "errorlogin";
//		}
//	}
	
	@RequestMapping(value="/tocliente",method = {RequestMethod.GET,RequestMethod.POST})
	public String obtenerContratos(HttpServletRequest request, @ModelAttribute("cliente")Cliente cliente) {
		List<Contrato> contratos=sClientes.obtenerListaContratos(cliente.getDni());
		request.setAttribute("contratos", contratos);
		System.out.println("La lista de contratos es: "+contratos);
		return "cliente";
	}
	
//	@GetMapping(value="/doSensores")
//	public String obtenerSensores(HttpServletRequest request,@RequestParam("idContrato") int idContrato) {
//		SensoresLista listaSensores=template.getForObject(url+idContrato, SensoresLista.class);		
//		request.setAttribute("listaSensores",listaSensores.getSensoresLista());
//		return "forward:/toSensores";
//	}
	
}
