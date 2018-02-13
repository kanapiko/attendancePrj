package attendance.application.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import attendance.application.entity.MUser;
import ninja.cero.sqltemplate.core.SqlTemplate;

@Component
public class MUserDao {

	@Autowired
	private SqlTemplate sqlTemplate;

	public Optional<MUser> selectByPk(Long userId) {
	    return Optional.ofNullable(sqlTemplate.forObject("sql/MUserDao/selectByPk.sql", MUser.class, userId));
	}

	public Optional<MUser> selectByMail(String mail) {
		return Optional.ofNullable(sqlTemplate.forObject("sql/MUserDao/selectByMail.sql", MUser.class, mail));
	}

	public List<MUser> find(MUser cond) {
		return sqlTemplate.forList("sql/MUserDao/find.sql", MUser.class, cond);
	}

	public int insert(MUser entity) {
		return sqlTemplate.update("sql/MUserDao/insert.sql", entity);
	}

	public int update(MUser entity) {
	    entity.updateDate = LocalDateTime.now();
		return sqlTemplate.update("sql/MUserDao/update.sql", entity);
	}
}