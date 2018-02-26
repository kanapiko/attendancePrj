package attendance.application.web.form;

import lombok.Data;

import java.io.Serializable;

/**
 * 組織情報登録フォーム
 */
@Data
public class OrgForm implements Serializable {
    public String orgCd;
    public String orgName;
    public String location;
    public Integer dispSeq;
}
