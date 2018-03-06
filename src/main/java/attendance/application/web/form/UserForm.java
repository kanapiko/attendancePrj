package attendance.application.web.form;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * ユーザ情報登録フォーム
 */
@Data
public class UserForm {
    public Integer userId;

    @Length(min = 8, max=64)
    @Pattern(regexp = "^[a-zA-Z0-9!-/:-@\\[-`{-~]+$", message = "パスワードは半角英数字記号で入力してください。")
    public String password;

    @NotBlank
    public String name;

    @NotBlank
    @Email
    public String mail;

    @NotBlank
    public String orgCd;

    @NotBlank
    public Integer managerId;

    @NotBlank
    public String authCd;

}

