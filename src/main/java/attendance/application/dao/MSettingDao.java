package attendance.application.dao;

import attendance.application.entity.MSetting;
import ninja.cero.sqltemplate.core.SqlTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 設定マスタDAO
 */
@Component
public class MSettingDao {

    @Autowired
    private SqlTemplate sqlTemplate;

    /**
     * 設定マスタ情報を取得する
     *
     * @return 設定マスタエンティティ
     */
    public Optional<MSetting> select() {
        return Optional.ofNullable(sqlTemplate.forObject("sql/MSettingDao/select.sql", MSetting.class));
    }

    /**
     * 設定マスタ情報を追加する
     *
     * @param entity 設定マスタエンティティ
     * @return 更新件数
     */
    public Integer insert(MSetting entity) {
        return sqlTemplate.update("sql/MSettingDao/insert.sql", entity);
    }

    /**
     * 設定マスタ情報を更新する
     *
     * @param entity 設定マスタエンティティ
     * @return 更新件数
     */
    public Integer update(MSetting entity) {
        return sqlTemplate.update("sql/MSettingDao/update.sql", entity);
    }
}
