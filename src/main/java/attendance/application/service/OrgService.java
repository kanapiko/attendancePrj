package attendance.application.service;

import attendance.application.dao.MOrgDao;
import attendance.application.entity.MOrg;
import attendance.application.security.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 組織サービス
 */
@Service
@Transactional
public class OrgService {

    @Autowired
    private MOrgDao mOrgDao;

    /**
     * 組織を検索する
     * @return 組織情報リスト
     */
    public List<MOrg> findOrgs() {
        return mOrgDao.findOrgs();
    }

    public void registerOrg(MOrg org) {
        AdminUser principal = (AdminUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.registDate = LocalDateTime.now();
        org.registUserId = principal.getUser().userId;
        org.registFuncCd = "0";

        mOrgDao.insert(org);
    }
}
