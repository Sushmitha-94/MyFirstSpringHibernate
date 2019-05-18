package com.sush.first.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sush.first.model.User;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	 public UserDAOImpl(SessionFactory sessionFactory) {
		 this.sessionFactory=sessionFactory;
	 }
/*	

	public User updatePassword(User user,String newPassword) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String queryString = "from User where username=:username";
		Query q = session.createQuery(queryString);
		q.setParameter("username", user.getUsername());
		List<User> users = q.list();
		user = users.get(0);
		user.setPassword(newPassword);
		session.update(user);
		tx.commit();
		session.close();
		return user;
	}

	public User updateEmail(User user,String newEmail) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String queryString = "from User where username=:username";
		Query q = session.createQuery(queryString);
		q.setParameter("username", user.getUsername());
		List<User> users = q.list();
		user = users.get(0);
		user.setEmail(newEmail);
		session.update(user);
		tx.commit();
		session.close();
		return user;
	}*/

	public void deleteUser(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
	}
	
	public User insertUser(User user) {		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		session.close();
		return user;
	}
	
	public User getUserDetails(String username) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String queryString = "from User where username=:username";
		Query q = session.createQuery(queryString);
		q.setParameter("username", username);
		List<User> users = q.list();
		tx.commit();
		session.close();
		if(users.size()>0)
			return users.get(0);
		else 
			return null;
	}

	public User updateUser(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
		return user;
	}
}
