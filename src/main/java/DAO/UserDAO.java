package DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import HibernateUtil.HibernateUtil;
import Model.User;

public class UserDAO implements InterfaceDAO<User> {
	@Override
	public int add(User t) {
		// TODO Auto-generated method stub
		int result = 0;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.close();
		sessionFactory.close();
		return result;
	}

	@Override
	public int remove(User t) {
		// TODO Auto-generated method stub
		int result = 0;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.remove(t);
			transaction.commit();
			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.close();
		sessionFactory.close();
		return result;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		int result = 0;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(t);
			transaction.commit();
			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.close();
		sessionFactory.close();
		return result;
	}

	@Override
	public User selectById(User t) {
		// TODO Auto-generated method stub
		User user = new User();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		user = session.find(User.class, t.getUserId());
		sessionFactory.close();
		return user;
	}

	public int selectByEmail(User t) {
		// TODO Auto-generated method stub
		int result = 0;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where email = :email");
		query.setParameter("email", t.getEmail());
		result = query.getResultList().size();
		sessionFactory.close();
		return result;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
