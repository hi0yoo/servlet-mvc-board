package bit.report.servletmvcboard.dao;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private Long id;
    private String username;
    private String password;
    private String nickname;

    public boolean passwordEquals(String password) {
        return this.password.equals(password);
    }
}
