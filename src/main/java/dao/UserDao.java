package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import dto.User;

public class UserDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("shubham").createEntityManager();
	}
	public void saveUser(User user)
	{
		EntityManager entityManager=getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}
	public User getUser(String emailId)
	{
		EntityManager entityManager=getEntityManager();
		User user=entityManager.find(User.class, emailId);
		return user;
	}
	public boolean  deleteUser(String emailId)
	{
		EntityManager entityManager=getEntityManager();
		User dbUser=entityManager.find(User.class,emailId);
		if(dbUser!=null)
		{
			entityManager.getTransaction().begin();
			entityManager.remove(dbUser);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
		
	}
	public boolean updateUser(String emailId, User user)
	{
		EntityManager entityManager=getEntityManager();
		User dbUser=entityManager.find(User.class, emailId);
		if(dbUser!=null)
		{
			entityManager.getTransaction().begin();
			user.setEmail(emailId);
			entityManager.merge(user);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
	}

	
}
