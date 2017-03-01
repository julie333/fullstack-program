package user.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import user.domain.User;

//@Repository
public class JdbcUserRepository implements UserRepository {

	private final UserMapper userMapper = new UserMapper();

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public long count() {
		return jdbcTemplate.queryForObject("select count(*) from users", Long.class);
	}

	@Override
	public void save(User user) {
		String sql = "insert into users(first_name, last_name, age) values(?,?,?)";
		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getAge());
	}

	@Override
	public List<User> findAll() {
		return jdbcTemplate.query("select * from users", userMapper);
	}

	@Override
	public User findById(Long id) {
		String sql = "select * from users where id=?";
		return jdbcTemplate.queryForObject(sql, userMapper, id);
	}

	@Override
	public User findByFirstNameAndLastName(String firstName, String lastName) {
		String sql = "select * from users where first_name=? and last_name=?";
		return jdbcTemplate.queryForObject(sql, userMapper, firstName, lastName);
	}

	@Override
	public void deleteAll() {
		jdbcTemplate.update("delete from users");
	}

	@Override
	public void deleteById(Long id) {
		jdbcTemplate.update("delete from users where id=?", id);
	}

	private static class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(
				rs.getLong("id"),
				rs.getString("first_name"),
				rs.getString("last_name"),
				rs.getInt("age")
			);
		}
	}

}
