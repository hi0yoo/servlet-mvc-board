package bit.report.servletmvcboard.dao;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    @Results(id = "user", value = {
            @Result(property = "id", column = "user_id", id = true),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "nickname", column = "nickname")
    })
    @Select("select user_id, username, password, nickname from users where username = #{username}")
    User selectUserByUsername(String username);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "user_id")
    @Insert("insert into users(username, password, nickname) values (#{username}, #{password}, #{nickname})")
    void insertUser(User user);
}
