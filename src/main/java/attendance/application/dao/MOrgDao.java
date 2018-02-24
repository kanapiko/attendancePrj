package attendance.application.dao;

import attendance.application.entity.MOrg;
import attendance.application.utils.SqlUtil;
import ninja.cero.sqltemplate.core.SqlTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 組織マスタDAO
 */
@Component
public class MOrgDao {

    @Autowired
    private SqlTemplate sqlTemplate;

    /**
     * 指定条件で組織名を検索する。
     * @return エンティティリスト
     */
    public List<MOrg> findOrgs() {
        return sqlTemplate.forList("sql/MOrgDao/findOrgs.sql", MOrg.class);
    }
}
