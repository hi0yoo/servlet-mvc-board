package bit.report.servletmvcboard.dto;

public class UserInfoDto {

    private Long userId;
    private String nickname;

    public UserInfoDto() {
    }

    public UserInfoDto(Long userId, String nickname) {
        this.userId = userId;
        this.nickname = nickname;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
