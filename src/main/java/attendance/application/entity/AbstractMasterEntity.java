package attendance.application.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * マスター共通エンティティ
 */
@Data
public class AbstractMasterEntity implements Serializable {
    public LocalDateTime registDate;
    public Integer registUserId;
    public String registFuncCd;
    public LocalDateTime updateDate;
    public Integer updateUserId;
    public String updateFuncCd;
    public String delFlg;
}
