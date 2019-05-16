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
	
	public User userLogin(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String queryString = "from User where username=:username and password=:password";
		Query q = session.createQuery(queryString);
		q.setParameter("username", user.getUsername());
		q.setParameter("password", user.getPassword());
		List<User> users = q.list();
		tx.commit();
		session.close();
		if(users.size()>0)
			return users.get(0);
		else 
			return null;
	}

	public User updatePassword(User user,String newPassword) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String queryString = "from User where user_id=:user_id";
		Query q = session.createQuery(queryString);
		q.setParameter("user_id", user.getUser_id());
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
		String queryString = "from User where user_id=:user_id";
		Query q = session.createQuery(queryString);
		q.setParameter("user_id", user.getUser_id());
		List<User> users = q.list();
		user = users.get(0);
		user.setEmail(newEmail);
		session.update(user);
		tx.commit();
		session.close();
		return user;
	}

	public int deleteUser(User user) {
		return 0;
	}

	public User setUpUser(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		session.close();
		return user;
	}

}
