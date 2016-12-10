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
public class ClienteController implements Serializable {

	@EJB
	private ClienteService serviceCte;

	public List<ClienteDTO> listItems;

	private String input_new_nomb;
	private String input_new_aPat;
	private String input_new_aMat;
	private String input_new_tel;
	private String input_new_dir;
	private Integer input_new_status;

	private String input_edit_nomb;
	private String input_edit_lastname1;
	private String input_edit_lastname2;
	private String input_edit_tel;
	private String input_edit_dir;

	private ClienteDTO currentItem;

	private void initClientes() {
		listItems = serviceCte.findAll();
	}

	@PostConstruct
	private void postConstruct() {
		initClientes();
	}

	public String addCliente() {
		ClienteDTO dto = new ClienteDTO();
		dto.setApeMatCte(input_new_aMat);
		dto.setApePatCte(input_new_aPat);
		dto.setDirCte(input_new_dir);
		dto.setIdEdoCte(1);
		dto.setNomCte(input_new_nomb);
		dto.setTelCte(input_new_tel);
		boolean added = serviceCte.addCliente(dto);
		if (added) {
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

	public String addCliente2() {
		ClienteDTO dto = new ClienteDTO();
		dto.setApeMatCte(input_new_aMat);
		dto.setApePatCte(input_new_aPat);
		dto.setDirCte(input_new_dir);
		dto.setIdEdoCte(input_new_status);
		dto.setNomCte(input_new_nomb);
		dto.setTelCte(input_new_tel);
		boolean added = serviceCte.addCliente(dto);
		if (added) {
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

	public String addClienteCancel() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Accion cancelada");
		facesContext.addMessage(null, facesMessage);
		return "";
	}

	public void validateEditSelection() {
		if (currentItem == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage("Necesitas seleccionar un elemento");
			facesContext.addMessage(null, facesMessage);
		}
		input_edit_dir = null;
		input_edit_lastname1 = null;
		input_edit_lastname2 = null;
		input_edit_nomb = null;
		input_edit_tel = null;
	}

	public String onEditCliente() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if ((input_edit_dir == null || input_edit_dir.isEmpty())
				&& (input_edit_lastname1 == null || input_edit_lastname1.isEmpty())
				&& (input_edit_lastname2 == null || input_edit_lastname2.isEmpty())
				&& (input_edit_nomb == null || input_edit_nomb.isEmpty())
				&& (input_edit_tel == null || input_edit_tel.isEmpty())) {
			FacesMessage facesMessage = new FacesMessage("No hay cambios a guardar");
			facesContext.addMessage(null, facesMessage);
		} else {
			currentItem.setNomCte(input_edit_nomb == null ? currentItem.getNomCte() : input_edit_nomb);
			currentItem.setApePatCte(input_edit_lastname1 == null ? currentItem.getApePatCte() : input_edit_lastname1);
			currentItem.setApeMatCte(input_edit_lastname2 == null ? currentItem.getApeMatCte() : input_edit_lastname2);
			currentItem.setTelCte(input_edit_tel == null ? currentItem.getTelCte() : input_edit_tel);
			currentItem.setDirCte(input_edit_dir == null ? currentItem.getDirCte() : input_edit_dir);
			boolean success = serviceCte.editCte(currentItem);
			if (success) {
				FacesMessage facesMessage = new FacesMessage("Cambio guardado");
				facesContext.addMessage(null, facesMessage);
				initClientes();
			} else {
				FacesMessage facesMessage = new FacesMessage("Error al guardar cambio");
				facesContext.addMessage(null, facesMessage);
			}
		}
		initClientes();
		return "";
	}

	public String onEditClienteCancel() {
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

	public ClienteDTO getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(ClienteDTO currentItem) {
		this.currentItem = currentItem;
	}

	public String getInput_edit_lastname1() {
		return input_edit_lastname1;
	}

	public void setInput_edit_lastname1(String input_edit_lastname1) {
		this.input_edit_lastname1 = input_edit_lastname1;
	}

	public String getInput_edit_lastname2() {
		return input_edit_lastname2;
	}

	public void setInput_edit_lastname2(String input_edit_lastname2) {
		this.input_edit_lastname2 = input_edit_lastname2;
	}

	public String getInput_edit_tel() {
		return input_edit_tel;
	}

	public void setInput_edit_tel(String input_edit_tel) {
		this.input_edit_tel = input_edit_tel;
	}

	public String getInput_edit_dir() {
		return input_edit_dir;
	}

	public void setInput_edit_dir(String input_edit_dir) {
		this.input_edit_dir = input_edit_dir;
	}

	public String getInput_edit_nomb() {
		return input_edit_nomb;
	}

	public void setInput_edit_nomb(String input_edit_nomb) {
		this.input_edit_nomb = input_edit_nomb;
	}
}
