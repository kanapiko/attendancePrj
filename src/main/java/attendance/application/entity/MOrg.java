package attendance.application.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 組織マスタエンティティ
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MOrg extends AbstractMasterEntity {
    public String orgCd;
    public String orgName;
    public String location;
    public Integer dispSeq;
}
