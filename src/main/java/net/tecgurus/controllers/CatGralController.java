package net.tecgurus.controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import net.tecgurus.common.dto.CatalogoGeneralDTO;
import net.tecgurus.core.ejb.business.interf.CatalogoGeneralService;

@ManagedBean(name = "catCtrl")
public class CatGralController implements Serializable {

	@EJB
	private transient CatalogoGeneralService serviceCatGral;
	
	private List<CatalogoGeneralDTO> itemsList;
	private String input_new_desCortCata;
	private String input_new_desCompCata;
	private String input_new_idEstCata;
	private Date input_new_fcCrea;
	
	private void initItemsList(){
		itemsList = serviceCatGral.findAll();
	}
	
	@PostConstruct
	private void postConstruct(){
		initItemsList();
	}
	
	
	public String saveCata(){
		//TODO bajar a bd
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Catalogo guardado");
		facesContext.addMessage(null, facesMessage);
		return "catalogo";
	}
	
	public String saveCataCancel(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Accion cancelada");
		facesContext.addMessage(null, facesMessage);
		return "";
	}
	
	
	
	//--------------------- Getters & Setters ---------------------------//

	public List<CatalogoGeneralDTO> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<CatalogoGeneralDTO> itemsList) {
		this.itemsList = itemsList;
	}

	public String getInput_new_desCortCata() {
		return input_new_desCortCata;
	}

	public void setInput_new_desCortCata(String input_new_desCortCata) {
		this.input_new_desCortCata = input_new_desCortCata;
	}

	public String getInput_new_desCompCata() {
		return input_new_desCompCata;
	}

	public void setInput_new_desCompCata(String input_new_desCompCata) {
		this.input_new_desCompCata = input_new_desCompCata;
	}

	public String getInput_new_idEstCata() {
		return input_new_idEstCata;
	}

	public void setInput_new_idEstCata(String input_new_idEstCata) {
		this.input_new_idEstCata = input_new_idEstCata;
	}

	public Date getInput_new_fcCrea() {
		return input_new_fcCrea;
	}

	public void setInput_new_fcCrea(Date input_new_fcCrea) {
		this.input_new_fcCrea = input_new_fcCrea;
	}
	
	
	
	
}
