package com.ltts.TestHibernate;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = factory.openSession();
    	org.hibernate.Transaction t = session.beginTransaction();
    	
    	Employee e = new Employee();
    	e.setEmpId(101);
    	e.setEmpName("roshi");
    	e.setEmpAddress("guntur");
    	session.save(e);
    	t.commit();
    	factory.close();
    	session.close();
    }
}
