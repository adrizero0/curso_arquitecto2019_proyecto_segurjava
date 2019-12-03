package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "menuAdminBean")
@RequestScoped
public class MenuAdminBean {
	
	
	public String altaCliente() {
		mensaje("Gestión Clientes", "Alta Cliente");
		return "altacliente";
	}
	
	public String modificarCliente() {
		mensaje("Gestión Clientes", "Modificar Cliente");
		return "modificarcliente";
	}
 
	public String bajaCliente() {
		mensaje("Gestión Clientes", "Baja Cliente");
		return "bajacliente";
	}

	public String altaContrato() {
		mensaje("Gestión Contratos", "Alta Contrato");
		return "altacontrato";
	}

	public String modificarContrato() {
		mensaje("Gestión Contratos", "Modificar Contrato");
		return "modificarcontrato";
	}
	
	public String bajaContrato() {
		mensaje("Gestión Contratos", "Baja Contrato");
		return "bajacontrato";
	}
	
	public String altaSensor() {
		mensaje("Gestión Sensores", "Alta Sensor");
		return "altasensor";
	}

	public String modificarSensor() {
		mensaje("Gestión Sensores", "Modificar Sensor");
		return "modificarsensor";
	}

	public String bajaSensor() {
		mensaje("Gestión Sensores", "Baja Sensor");
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
