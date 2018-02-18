package attendance.application.emuns;

/**
 * 論理削除フラグ
 */
public enum DelFlg {
    NONE("0"),
    DELETED("1");

    private String val;

    DelFlg(String val) {
        this.val = val;
    }

    public String getVal() {
        return this.val;
    }

}
