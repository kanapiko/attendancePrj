package attendance.application.interceptor;

import attendance.application.entity.AbstractMasterEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * DAOインターセプター
 */
@Slf4j
@Aspect
@Component
public class DaoInterceptor {

    @Around("target(attendance.application.dao.AbstractMasterDao) && execution(public Integer insert(attendance.application.entity.AbstractMasterEntity))")
    public Object setCommonFieldsForRegister(ProceedingJoinPoint jp) throws Throwable {

        final User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        AbstractMasterEntity entity = (AbstractMasterEntity) jp.getArgs()[0];
        entity.registUserId = Integer.valueOf(loginUser.getUsername());
        // TODO:リクエストURLパスからregistFuncCdをセット

        return jp.proceed(new Object[] {entity});
    }

    @Around("target(attendance.application.dao.AbstractMasterDao) && execution(public Integer update(..))")
    public Object setCommonFieldsForUpdate(ProceedingJoinPoint jp) throws Throwable {

        log.debug("exec update dao interceptor");

        final User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        AbstractMasterEntity entity = (AbstractMasterEntity) jp.getArgs()[0];
        entity.registUserId = Integer.valueOf(loginUser.getUsername());
        // TODO:リクエストURLパスからupdateFuncCdをセット

        return jp.proceed(new Object[] {entity});
    }

}
