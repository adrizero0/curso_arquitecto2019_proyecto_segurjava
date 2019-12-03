package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Cliente;
import service.ServiceCliente;
@Controller
public class LoginController {
		@Autowired
		ServiceCliente sClientes;
		
		@PostMapping(value="/doLogin")
		public String login(@RequestParam("dni") String dni, 
							@RequestParam("password")String password,
							Model model) {
			Cliente cliente=sClientes.validar(dni, password);
			if(cliente!=null) {
				String permiso=sClientes.autorizar(dni, password);
				System.out.println("Estamos en el controller. Permiso del usuario es: "+permiso);
				model.addAttribute("cliente", cliente);
				return "forward:/to"+permiso;
			}else {
				return "errorlogin";
			}
		}
}
