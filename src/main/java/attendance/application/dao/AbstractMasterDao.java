package attendance.application.dao;

import attendance.application.emuns.Flag;
import attendance.application.entity.AbstractMasterEntity;

/**
 * DAO共通抽象クラス
 */
abstract class AbstractMasterDao<T extends AbstractMasterEntity> {
    abstract int insert(T entity);
    abstract int update(T entity);

    int delete(T entity) {
        entity.delFlg = Flag.ON.getVal();
        return update(entity);
    }
}
