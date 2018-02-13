package attendance.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import attendance.application.dao.MUserDao;
import attendance.application.entity.MUser;

@Service
@Transactional
public class UserService {

	@Autowired
	MUserDao muserDao;

	public Optional<MUser> getUserByMail(String mail) {
		return muserDao.selectByMail(mail);
	}

	public void registerLineId(Long userId, String lineId) {
	    muserDao.selectByPk(userId).ifPresent(muser -> {
	        MUser entity = new MUser();
	        entity.userId = userId;
	        entity.lineId = lineId;
	        muserDao.update(entity);
	    });
	}

}
