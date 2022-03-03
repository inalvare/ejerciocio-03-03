package com.formacionsprongboot.apirest.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="compras")
public class Compra implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codCliente")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Cliente cliente;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codArticulo")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Articulo articulo;
	
	@Column(name="fecha", unique=true)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="unidades")
	private int unidades;	
	
	@PrePersist
	public void prePersist() {
		if(fecha == null) {
			fecha = new Date();
		}	
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Articulo getArticulo() {
		return articulo;
	}



	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}



	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	/** */
	private static final long serialVersionUID = 1L;
}
