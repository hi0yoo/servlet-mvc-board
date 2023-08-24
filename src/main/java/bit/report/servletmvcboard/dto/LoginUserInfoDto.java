package bit.report.servletmvcboard.dto;

public class LoginUserInfoDto {

    private Long userId;
    private String username;
    private String nickname;

    public LoginUserInfoDto(Long userId, String username, String nickname) {
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
