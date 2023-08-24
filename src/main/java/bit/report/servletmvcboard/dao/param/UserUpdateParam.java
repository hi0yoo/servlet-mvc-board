package bit.report.servletmvcboard.dao.param;

public class UserUpdateParam {

    private Long userId;
    private String nickname;

    public UserUpdateParam(Long userId, String nickname) {
        this.userId = userId;
        this.nickname = nickname;
    }

    public Long getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }
}
