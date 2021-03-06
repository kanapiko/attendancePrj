package attendance.application.emuns;

/**
 * 権限区分
 */
public enum AuthCd {
    MEMBER("01"), // 一般
    MANAGER("02"), // 上長
    ADMIN("03"); // 管理者

    private String code;

    AuthCd(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
