package attendance.application.entity;

/**
 * ユーザマスタエンティティ
 */
public class MUser extends AbstractMasterEntity {
	public Long userId;
	public String password;
	public String name;
	public String mail;
	public String authCd;
	public String orgCd;
	public String managerId;
	public String lineId;
}
