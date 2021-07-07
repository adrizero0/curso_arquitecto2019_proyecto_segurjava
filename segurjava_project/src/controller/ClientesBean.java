package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.web.client.RestTemplate;

import model.Contrato;
import model.Sensor;
import model.SensorPojo;
import model.SensoresLista;
import service.ServiceAdministracion;
import service.ServiceCliente;

@ManagedBean
public class ClientesBean {
	private List<Sensor> listaSensores;
	private List<Contrato> listaContratos;
	private int idSensor;
	private int idContratoSel;
	
	@ManagedProperty("#{loginBean}")
	LoginBean login;
	
	@ManagedProperty("#{serviceAdmin}")
	ServiceAdministracion sAdmin;
	
	@ManagedProperty("#{serviceCliente}")
	ServiceCliente sCliente;
	
	public List<Contrato> getListaContratos() {
		String dni= login.getDni();
		listaContratos=sCliente.obtenerListaContratos(dni);
		return listaContratos;
	}
	public void setListaContratos(List<Contrato> listaContratos) {
		this.listaContratos = listaContratos;
	}
	public int getIdSensor() {
		return idSensor;
	}
	public void setIdSensor(int idSensor) {
		this.idSensor = idSensor;
	}
	public int getIdContratoSel() {
		return idContratoSel;
	}
	public void setIdContratoSel(int idContratoSel) {
		this.idContratoSel = idContratoSel;
	}
	public LoginBean getLogin() {
		return login;
	}
	public void setLogin(LoginBean login) {
		this.login = login;
	}
	public ServiceAdministracion getsAdmin() {
		return sAdmin;
	}
	public void setsAdmin(ServiceAdministracion sAdmin) {
		this.sAdmin = sAdmin;
	}
	public ServiceCliente getsCliente() {
		return sCliente;
	}
	public void setsCliente(ServiceCliente sCliente) {
		this.sCliente = sCliente;
	}
	public List<SensorPojo> getListaSensores() {
		String url="http://zuulalarmas:7000/alarmas/lista/"+idSensor;
		RestTemplate template=new RestTemplate();
		SensoresLista listaSensores=template.getForObject(url, SensoresLista.class);	
		return listaSensores.getSensoresLista();
	}
	public void setListaSensores(List<Sensor> listaSensores) {
		this.listaSensores = listaSensores;
	}
	
	
}
