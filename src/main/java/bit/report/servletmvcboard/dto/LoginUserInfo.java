package bit.report.servletmvcboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class LoginUserInfo {

    private Long userId;
    private String username;
    private String nickname;
}
