package bit.report.servletmvcboard.dto;

public class LoginUserInfo {

    private Long userId;
    private String username;
    private String nickname;

    public LoginUserInfo(Long userId, String username, String nickname) {
        this.userId = userId;
        this.username = username;
        this.nickname = nickname;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }
}
