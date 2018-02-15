package attendance.application.exception;

import org.springframework.http.HttpStatus;

/**
 * 画面系エラー
 */
public enum ApplicationErrors implements HttpErrors {

    UNEXPECTED("ERR-999", HttpStatus.INTERNAL_SERVER_ERROR, "予期せぬエラーが発生しました。");

    private String code;

    private HttpStatus status;

    private String message;

    ApplicationErrors(String code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    @Override
    public String getErrorCode() {
        return code;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
