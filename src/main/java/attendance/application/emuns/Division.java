package attendance.application.emuns;

import lombok.Getter;

/**
 * 汎用区分
 */
public enum Division {
    AUTH(1),
    ATTENDANCE(2),
    MENU(3);

    @Getter
    private int id;

    Division(int id) {
        this.id = id;
    }
}
