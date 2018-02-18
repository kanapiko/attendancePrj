package attendance.application.dto;

import attendance.application.entity.MUser;

import java.io.Serializable;

/**
 * ユーザ情報DTO
 */
public class UserInfo extends MUser implements Serializable {
    public String authName;

    public String orgName;
}
