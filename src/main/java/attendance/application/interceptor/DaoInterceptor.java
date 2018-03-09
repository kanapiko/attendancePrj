package attendance.application.interceptor;

import attendance.application.entity.AbstractMasterEntity;
import attendance.application.exception.ApplicationErrors;
import attendance.application.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * DAOインターセプター
 * 共通項目の設定と更新日時による楽観的ロック制御を行う。
 */
@Slf4j
@Aspect
@Component
public class DaoInterceptor {

    @Around("target(attendance.application.dao.AbstractMasterDao) && execution(public int insert(attendance.application.entity.AbstractMasterEntity))")
    public Object setCommonFieldsForRegister(ProceedingJoinPoint jp) throws Throwable {

        final User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        AbstractMasterEntity entity = (AbstractMasterEntity) jp.getArgs()[0];
        entity.registUserId = Integer.valueOf(loginUser.getUsername());
        // TODO:リクエストURLパスからregistFuncCdをセット
        entity.registFuncCd = "0";

        return jp.proceed(new Object[] {entity});
    }

    @Around("target(attendance.application.dao.AbstractMasterDao) && execution(public int update(attendance.application.entity.AbstractMasterEntity))")
    public Object setCommonFieldsForUpdate(ProceedingJoinPoint jp) throws Throwable {

        log.debug("exec update dao interceptor");

        final User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        AbstractMasterEntity entity = (AbstractMasterEntity) jp.getArgs()[0];
        entity.updateUserId = Integer.valueOf(loginUser.getUsername());
        // TODO:リクエストURLパスからupdateFuncCdをセット
        entity.updateFuncCd = "0";
        Integer upCount = (Integer ) jp.proceed(new Object[] {entity});

        if(upCount == 0) {
            throw new ApplicationException(ApplicationErrors.ALREADY_UPDATED);
        }

        return upCount;
    }

}
