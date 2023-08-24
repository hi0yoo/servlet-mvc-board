package bit.report.servletmvcboard.dao;

import bit.report.servletmvcboard.dao.model.User;
import bit.report.servletmvcboard.dao.param.UserUpdateParam;
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

    @Results(id = "userM", value = {
            @Result(property = "id", column = "user_id", id = true),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "nickname", column = "nickname")
    })
    @Select("select user_id, username, password, nickname from users where user_id = #{userId}")
    User selectUserByUserId(Long userId);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "user_id")
    @Insert("insert into users(username, password, nickname) values (#{username}, #{password}, #{nickname})")
    void insertUser(User user);

    @Update("update users set nickname = #{nickname} where user_id = #{userId}")
    void updateUser(UserUpdateParam param);
}
