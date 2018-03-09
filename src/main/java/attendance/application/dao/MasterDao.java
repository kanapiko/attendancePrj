package attendance.application.dao;

import attendance.application.entity.AbstractMasterEntity;

public interface MasterDao<T extends AbstractMasterEntity> {
    int insert(T entity);
    int update(T entity);
}
