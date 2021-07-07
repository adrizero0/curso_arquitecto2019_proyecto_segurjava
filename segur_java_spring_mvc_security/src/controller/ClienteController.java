package controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import model.Cliente;
import model.Contrato;
import model.Sensor;
import service.ServiceCliente;

@CrossOrigin(origins = "*")
@Controller
public class ClienteController {
	@Autowired
	ServiceCliente sClientes;
	
	@Autowired
	RestTemplate template;
	
	String url="http://localhost:8006/alarmas/intruso/";
	
	@CrossOrigin(origins = "*")
	@PostMapping(value="/doLista")
	public String obtenerListaSensores(@RequestParam("idContrato") int idContrato, HttpServletRequest request) {
		System.out.println("Estamos dentro del doLista");

		request.setAttribute("idContrato", idContrato);
		System.out.println("idContrato es: "+idContrato);
		
		List<Sensor> sensores= sClientes.obtenerListaSensores(idContrato);
		request.setAttribute("sensores", sensores);
		
		return "cliente";
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value="/doAlerta")
	public String obtenerLista(@RequestParam("idSensor") int idSensor, HttpServletRequest request) {
		System.out.println("Estamos dentro del doAlerta");
		
		template.put(url+idSensor, null);
		
		return "aviso";
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/doEntrar", method = {RequestMethod.GET,RequestMethod.POST})
	public String entrar(Model model, HttpServletRequest request) {
		
		if(request.isUserInRole("ROLE_USER")) {
			Principal p= request.getUserPrincipal();
			String dni= p.getName();
			Cliente cliente=sClientes.obtenerClienteByDni(dni);
			model.addAttribute("cliente", cliente);
			
			List<Contrato> contratos=sClientes.obtenerListaContratos(cliente.getDni());
			System.out.println("dni del cliente: "+dni);
			
			request.setAttribute("contratos", contratos);
			return "clientecontratos";
		}else {
			return "menuadmin";
		}		
	}
	
}
