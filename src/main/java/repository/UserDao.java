package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import model.User;


public class UserDao {
	@SuppressWarnings("deprecation")
	public static int save(User u){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(u);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;

	}

	@SuppressWarnings("deprecation")
	public static int update(User u){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.update(u);
			transaction.commit();
			return 1;
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;

	}

	@SuppressWarnings("deprecation")
	public static int delete(User u){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.delete(u);
			transaction.commit();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}


	public static List<User> getAllRecords(){
		List<User> list=new ArrayList<User>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
		transaction = session.beginTransaction();
		Query<User> query = session.createQuery("FROM User", User.class);
		list = query.getResultList();
		transaction.commit();
			}catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}

		return list;
	}
	public static User getRecordById(int id){
		User u=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			Query<User> query = session.createQuery("FROM User WHERE id = :id", User.class);
			query.setParameter("id", id);
			u= (User) query.getSingleResult();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return u;
	}
}