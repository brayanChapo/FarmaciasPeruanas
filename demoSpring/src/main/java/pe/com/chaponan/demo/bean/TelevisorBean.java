package pe.com.chaponan.demo.bean;

import java.io.Serializable;

public class TelevisorBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String marca;
	private String descripcion;
	private double precio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
