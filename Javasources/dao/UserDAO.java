package dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import model.User;

public class UserDAO {

	Session session;

	private void initializeConnection() {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernates.cfg.xml").build();
		Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		this.session = sessionFactory.openSession();
		System.out.println("Hibernate Session opened!");
		session.beginTransaction();
	}

	public User retrieveUserDetails(long userId) {
		initializeConnection();
		String hql = "Select p from User p where p.userId=:userId";
		Query query = session.createQuery(hql);
		query.setParameter("userId", userId);
		User user = null;
		try {
			user = (User) query.getSingleResult();
		} catch (NoResultException nre) {
			System.out.println("There is no user with the given user Id");
		}
		closeSession();
		return user;
	}

	public int update(User user) {
		initializeConnection();
		String qryString = "update User s set s.userName=:userName, s.city=:city, s.country=:country where s.userId=:userId";
		Query query = session.createQuery(qryString);
		query.setParameter("userId", user.getUserId());
		query.setParameter("userName", user.getUserName());
		query.setParameter("city", user.getCity());
		query.setParameter("country", user.getCountry());

		int count = query.executeUpdate();
		closeSession();
		return count;
	}
	public void closeSession() {
		System.out.println("Hibernate Session closed!");
		session.close();
	}



}
