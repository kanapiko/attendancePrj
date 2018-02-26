package attendance.application.service;

import attendance.application.dao.MDivDao;
import attendance.application.emuns.Division;
import attendance.application.entity.MDivDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 区分サービス
 */
@Service
@Transactional
public class DivisionService {
    @Autowired
    private MDivDao mDivDao;

    /**
     * 権限コード区分明細を取得する
     *
     * @return 区分明細情報リスト
     */
    public List<MDivDetail> getAuthList() {
        return mDivDao.findDetailById(Division.AUTH.getId());
    }
}
