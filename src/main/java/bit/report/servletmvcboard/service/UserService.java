package bit.report.servletmvcboard.service;

import bit.report.servletmvcboard.config.MybatisManager;
import bit.report.servletmvcboard.dao.User;
import bit.report.servletmvcboard.dao.UserDao;
import bit.report.servletmvcboard.dto.LoginUserInfo;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    private UserService() {
        this.userDao = MybatisManager.getMapper(UserDao.class);
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    private final UserDao userDao;

    public void signUp(String username, String password, String nickname) {
        // TODO 로그인 아이디 중복 체크
        // TODO 데이터 null 체크
        User user = User.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .build();

        userDao.insertUser(user);
    }

    public LoginUserInfo login(String username, String password) {
        User user = userDao.selectUserByUsername(username);
        if (user == null) {
            throw new RuntimeException("로그인 아이디 오류");
        }

        if (!user.passwordEquals(password)) {
            throw new RuntimeException("비밀번호 오류");
        }

        return new LoginUserInfo(user.getId(), user.getUsername(), user.getNickname());
    }
}