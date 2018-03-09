package attendance.application.dao;

import attendance.application.dto.UserInfo;
import attendance.application.entity.MUser;
import ninja.cero.sqltemplate.core.SqlTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * ユーザマスタDAO
 */
@Component
public class MUserDao extends AbstractMasterDao<MUser> {

	private static final Logger logger = LoggerFactory.getLogger(MUserDao.class);

	@Autowired
	private SqlTemplate sqlTemplate;

	public Optional<MUser> selectByPk(Integer userId) {
		return Optional.ofNullable(sqlTemplate.forObject("sql/MUserDao/selectByPk.sql", MUser.class, userId));
	}

	public Optional<MUser> selectByMail(String mail) {
		return Optional.ofNullable(sqlTemplate.forObject("sql/MUserDao/selectByMail.sql", MUser.class, mail));
	}

	public List<UserInfo> findUsers(String orgCd, String name) {

		Map<String, Object> cond = new HashMap<>();

		cond.put("orgCd", orgCd);

		if(!StringUtils.isEmpty(name)) {
			cond.put("likeName", "%" + name + "%");
		}

		return sqlTemplate.forList("sql/MUserDao/findUsers.sql", UserInfo.class, cond);
	}

	public int insert(MUser entity) {
		return sqlTemplate.update("sql/MUserDao/insert.sql", entity);
	}

	public int update(MUser entity) {
		return sqlTemplate.update("sql/MUserDao/update.sql", entity);
	}
}
