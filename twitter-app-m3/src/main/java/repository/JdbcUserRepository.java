package repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.User;

@Repository
public class JdbcUserRepository implements UserRepository {

	private final JdbcTemplate jdbcTemplate;
	private final UserMapper userMapper = new UserMapper();

	@Autowired
	public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from User";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void save(User user) {

		String sql = "insert into User(first_name,last_name,email_address,username,password) values (?,?,?,?,?)";
		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getUsername(),
				user.getPassword());

	}

	@Override
	public List<User> findAll() {
		
		String sql = "select * from User";
		return jdbcTemplate.query(sql, userMapper);

	}
	
	@Override
	public User findById(Integer id) {

		String sql = "select * from User where id = ?";
		return jdbcTemplate.queryForObject(sql, userMapper, id);
	}

	@Override
	public User findByFirstNameAndLastName(String firstName, String lastName) {
	
		String sql = "select * from User where first_name = ? and last_name = ?";
		return jdbcTemplate.queryForObject(sql, userMapper, firstName, lastName);
		
	}

	@Override
	public void deleteAll() {
		
		String sql = "delete from user";
		jdbcTemplate.execute(sql);

	}

	@Override
	public void deleteById(Integer id) {

		String sql = "delete from user where id = ?";
		jdbcTemplate.update(sql, id);

	}



}
