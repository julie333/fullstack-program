package user.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import user.domain.User;

@Repository
public class JPAUserRepository implements UserRepository {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public long count() {

		String query = "select count(*) from User";
		long count = entityManager.createQuery(query, Long.class).getSingleResult();
		return count;
	}

	@Override
	public void save(User user) {

		entityManager.persist(user);

	}

	@Override
	public List<User> findAll() {

		List<User> users = entityManager.createQuery("from User", User.class).getResultList();
		return users;
	}

	@Override
	public User findById(Long id) {
		User u = entityManager.find(User.class, id);
		return u;

	}

	@Override
	public User findByFirstNameAndLastName(String firstName, String lastName) {
		String sql = "from User u where u.firstName= :firstName and u.lastName= :lastName";

		User user = entityManager.createQuery(sql, User.class).setParameter("firstName", firstName)
				.setParameter("lastName", lastName).getSingleResult();
		return user;

	}

	@Override
	public void deleteAll() {

		entityManager.createQuery("delete from User").executeUpdate();
	}

	@Override
	public void deleteById(Long id) {

		String deleteQuery = "delete from User where id = :id";

		entityManager.createQuery(deleteQuery).setParameter("id", id).executeUpdate();

	}

}

