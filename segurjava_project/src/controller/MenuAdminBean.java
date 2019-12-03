package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "menuAdminBean")
@RequestScoped
public class MenuAdminBean {
	
	
	
	public String altaCliente() {
		mensaje("Gesti�n Clientes", "Alta Cliente");
		return "altacliente";
	}
	
	public String modificarCliente() {
		mensaje("Gesti�n Clientes", "Modificar Cliente");
		return "modificarcliente";
	}
 
	public String bajaCliente() {
		mensaje("Gesti�n Clientes", "Baja Cliente");
		return "bajacliente";
	}

	public String altaContrato() {
		mensaje("Gesti�n Contratos", "Alta Contrato");
		return "altacontrato";
	}

	public String modificarContrato() {
		mensaje("Gesti�n Contratos", "Modificar Contrato");
		return "modificarcontrato";
	}
	
	public String bajaContrato() {
		mensaje("Gesti�n Contratos", "Baja Contrato");
		return "bajacontrato";
	}
	
	public String altaSensor() {
		mensaje("Gesti�n Sensores", "Alta Sensor");
		return "altasensor";
	}

	public String modificarSensor() {
		mensaje("Gesti�n Sensores", "Modificar Sensor");
		return "modificarsensor";
	}

	public String bajaSensor() {
		mensaje("Gesti�n Sensores", "Baja Sensor");
		return "bajasensor";
	}

	public String infoAlertasCliente() {
		mensaje("Informes", "Informe Alertas Cliente");
		return "infoalertascliente";
	}
	
	public String infoAlertasFechas() {
		mensaje("Informes", "Informe Alertas Fechas");
		return "infoalertasfechas";
	}
	
	private void mensaje (String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
