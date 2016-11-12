package net.tecgurus.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.tecgurus.common.dto.ClienteDTO;
import net.tecgurus.core.ejb.business.inter.ClienteService;

@ManagedBean(name = "cteCtrl")
@ViewScoped
public class ClienteController implements Serializable{

	@EJB
	private ClienteService serviceCte;

	public List<ClienteDTO> listItems;
	
	private String input_new_nomb;
	private String input_new_aPat;
	private String input_new_aMat;
	private String input_new_tel;
	private String input_new_dir;
	private Integer input_new_status;
	
	private void initClientes(){
		listItems = serviceCte.findAll();
	}
	
	@PostConstruct
	private void postConstruct(){
		initClientes();
	}

	public String addCliente(){
		ClienteDTO dto = new ClienteDTO();
		dto.setApeMatCte(input_new_aMat);
		dto.setApePatCte(input_new_aPat);
		dto.setDirCte(input_new_dir);
		dto.setIdEdoCte(1);
		dto.setNomCte(input_new_nomb);
		dto.setTelCte(input_new_tel);
		boolean added = serviceCte.addCliente(dto);
		if(added){
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage("Cliente guardado");
			facesContext.addMessage(null, facesMessage);
			return "clientes";
		}
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Error al guardar cliente");
		facesContext.addMessage(null, facesMessage);
		return "";
	}
	
	public String addCliente2(){
		ClienteDTO dto = new ClienteDTO();
		dto.setApeMatCte(input_new_aMat);
		dto.setApePatCte(input_new_aPat);
		dto.setDirCte(input_new_dir);
		dto.setIdEdoCte(input_new_status);
		dto.setNomCte(input_new_nomb);
		dto.setTelCte(input_new_tel);
		boolean added = serviceCte.addCliente(dto);
		if(added){
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage("Cliente guardado");
			facesContext.addMessage(null, facesMessage);
			return "clientes";
		}
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Error al guardar cliente");
		facesContext.addMessage(null, facesMessage);
		return "";
	}
	
	public String addClienteCancel(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Accion cancelada");
		facesContext.addMessage(null, facesMessage);
		return "";
	}
	
	
	
	public List<ClienteDTO> getListItems() {
		return listItems;
	}

	public void setListItems(List<ClienteDTO> listItems) {
		this.listItems = listItems;
	}

	public ClienteService getServiceCte() {
		return serviceCte;
	}

	public void setServiceCte(ClienteService serviceCte) {
		this.serviceCte = serviceCte;
	}

	public String getInput_new_nomb() {
		return input_new_nomb;
	}

	public void setInput_new_nomb(String input_new_nomb) {
		this.input_new_nomb = input_new_nomb;
	}

	public String getInput_new_aPat() {
		return input_new_aPat;
	}

	public void setInput_new_aPat(String input_new_aPat) {
		this.input_new_aPat = input_new_aPat;
	}

	public String getInput_new_aMat() {
		return input_new_aMat;
	}

	public void setInput_new_aMat(String input_new_aMat) {
		this.input_new_aMat = input_new_aMat;
	}

	public String getInput_new_tel() {
		return input_new_tel;
	}

	public void setInput_new_tel(String input_new_tel) {
		this.input_new_tel = input_new_tel;
	}

	public String getInput_new_dir() {
		return input_new_dir;
	}

	public void setInput_new_dir(String input_new_dir) {
		this.input_new_dir = input_new_dir;
	}

	public Integer getInput_new_status() {
		return input_new_status;
	}

	public void setInput_new_status(Integer input_new_status) {
		this.input_new_status = input_new_status;
	}
	
}
