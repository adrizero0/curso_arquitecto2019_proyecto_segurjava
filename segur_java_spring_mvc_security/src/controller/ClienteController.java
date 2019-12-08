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
