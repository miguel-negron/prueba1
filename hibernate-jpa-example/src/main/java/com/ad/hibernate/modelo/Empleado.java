package com.ad.hibernate.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADO")
public class Empleado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "codigo")
	private long codigo;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_Nacimiento")
	private GregorianCalendar fechaNacimiento;
	
	public Empleado() {}

	public Empleado(long codigo, String apellidos, String nombre, GregorianCalendar fechaNacimiento) {
		this.codigo = codigo;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", apellidos=" + apellidos + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
	
}
