package ToDo;

import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;

import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageToDo {
	
	private static SessionFactory factory;
	public ManageToDo() {
		try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }

	 
	}
	

	public void addToDo(String s) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      Integer ID = null;
	      
	      if (s != null && s.length() > 0) {
	      
	    	  try {
	    		  tx = session.beginTransaction();
	    		  ToDoItem todo = new ToDoItem(s);
	    		  ID = (Integer) session.save(todo); 
	    		  tx.commit();
	    	  } catch (HibernateException e) {
	    		  if (tx!=null) tx.rollback();
	    		  e.printStackTrace(); 
	    	  } finally {
	    		  session.close(); 
	    	  }
	    
	      }

			
	}
//	public void addToDo(String s, int i) {
//		ToDoItem newToDo = new ToDoItem(s, i);
//		myList.add(newToDo);
//			
//	}
	
	public List<String> viewToDos() {
		Session session = factory.openSession();
	      Transaction tx = null;
	      List<String> myList = new ArrayList();
	      
	      try {
	         tx = session.beginTransaction();
	         List todo = session.createQuery("from ToDoItem").list(); 
	         for (Iterator iterator = todo.iterator(); iterator.hasNext();){
	            ToDoItem todoitem = (ToDoItem) iterator.next(); 
	            myList.add(todoitem.getItem());
	            

	         }
	         tx.commit();
	         
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	 
	         session.close();
	         
	         
	      }
	      return myList;
	      
	}
	
	public void deleteToDo(int ID) {
		
		Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         ToDoItem todo = (ToDoItem)session.get(ToDoItem.class,ID); 
	         session.delete(todo); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
	 @Transactional
	public void deleteToDo(String todo) {
		Session session = factory.openSession();
		
		 Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         StringBuilder s = new StringBuilder("delete from ToDoItem where item= '");
	 		 s.append(todo);
	 		 s.append("'");
	 		String hql = s.toString();
	 		session.createQuery(hql).executeUpdate();
	 		System.out.println(hql);
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }

	}
	

	
}

