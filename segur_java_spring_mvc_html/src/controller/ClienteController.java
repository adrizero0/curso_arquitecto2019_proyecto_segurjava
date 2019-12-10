package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ServiceCliente;

@CrossOrigin(origins = "*")
@Controller
public class ClienteController {
	@Autowired
	ServiceCliente sClientes;
	
		
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/doEntrar", method = {RequestMethod.GET,RequestMethod.POST})
	public String entrar() {
			return "cliente";
				
	}
	
}
