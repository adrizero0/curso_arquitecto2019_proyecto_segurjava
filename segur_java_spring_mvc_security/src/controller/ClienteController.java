package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	String url="http://10.2.4.12:8006/alarmas/intruso/";
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/toClienteContratos", method = {RequestMethod.GET,RequestMethod.POST})
	public String obtenerContratos(HttpServletRequest request, @ModelAttribute("cliente")Cliente cliente) {
		System.out.println("Estamos dentro del toClienteContratos");
		
		List<Contrato> contratos=sClientes.obtenerListaContratos(cliente.getDni());
		System.out.println("dni del cliente"+cliente.getDni());
		
		request.setAttribute("contratos", contratos);
		System.out.println("La lista de contratos es: "+contratos);
				
		return "clientecontratos";
	}
	
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
	@PostMapping(value = "/doLogin")
	public String login(@RequestParam("dni") String dni,
						Model model) {
		System.out.println("Entramos al login controller- doLogin");
		Cliente cliente=sClientes.obtenerClienteByDni(dni);
		if(cliente!=null) {
			model.addAttribute("cliente", cliente);
			System.out.println("Entramos if cliente !=null= "+ cliente);
			return "forward:/toClienteContratos";	
		}else {
			return "error";
		}
	}
	
}
