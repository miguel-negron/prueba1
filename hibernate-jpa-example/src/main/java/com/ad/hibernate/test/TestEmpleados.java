package com.ad.hibernate.test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ad.hibernate.modelo.Empleado;

import com.ad.hibernate.modelo.Empleado;

public class TestEmpleados {
	
	private static EntityManager manager;
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		
		//	Creacion del gestor de persistencia
		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
		
		
		insertInicial();
		
		manager.getTransaction().begin();
		
		Empleado e = manager.find(Empleado.class, 1L);
		e.setNombre("LMAO");
		
		manager.merge(e);
		
		manager.getTransaction().commit();
////		List<Empleado> lista = manager.createQuery("From Empleado").getResultList();
//int a = 1 + 1;																							//		
////		System.out.println("En esta:\n" + lista.size());
		
		imprimirTodo();
		
		manager.close();
		
	}

	private static void insertInicial() {
		Empleado e = new Empleado(0L, "Lopez", "Paco", new GregorianCalendar(1999, 10, 10));
		Empleado e2 = new Empleado(1L, "Lopez", "Paco", new GregorianCalendar());
		
		manager.getTransaction().begin();
		manager.persist(e);
		e.setApellidos("Manolo");
		manager.persist(e2);
		manager.getTransaction().commit();
	}
	
	public static void imprimirTodo() {
		List<Empleado> lista = (List<Empleado>) manager.createQuery("From Empleado").getResultList();
		System.out.println("Hay " + lista.size() + " empleados.\n");

		for(Empleado emp : lista) {
			System.out.println((emp.getCodigo() + 1) + ". " + emp.toString());
		}
	}
	
	
}
