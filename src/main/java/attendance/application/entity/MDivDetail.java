package attendance.application.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 汎用区分明細マスタエンティティ
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MDivDetail extends AbstractMasterEntity {
    public String divId;
    public String divCd;
    public String divCdContent;
}
