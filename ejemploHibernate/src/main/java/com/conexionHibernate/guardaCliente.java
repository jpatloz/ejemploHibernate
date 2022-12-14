package com.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class guardaCliente {

	public static void main(String[] args) {

		SessionFactory miFactory = new Configuration().configure("context.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			Clientes cliente1 = new Clientes("Jesús", "Patricio Lozano", "Calle Igueldo");
			
			miSession.beginTransaction();	
			
			miSession.save(cliente1);
			
			miSession.getTransaction().commit();
			
			System.out.println("Registro ingresado correctamente en BBDD");
			
			miSession.close();
		}finally {
			
			miFactory.close();
		}
	}

}
