package attendance.application.entity;

import java.time.LocalDateTime;

/**
 * マスター共通エンティティ
 */
public class AbstractMasterEntity {
    public LocalDateTime registDate;
    public String registUserId;
    public String registFuncCd;
    public LocalDateTime updateDate;
    public String updateUserId;
    public String updateFuncCd;
    public String delFlg;
}
