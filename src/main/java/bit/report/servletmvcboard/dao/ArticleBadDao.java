package bit.report.servletmvcboard.dao;

import bit.report.servletmvcboard.dao.model.ArticleBad;
import bit.report.servletmvcboard.dao.param.UserAndArticleIdParam;
import org.apache.ibatis.annotations.*;

public interface ArticleBadDao {

    @Results(id = "articleBad", value = {
            @Result(property = "num", column = "num", id = true),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "articleId", column = "article_id")
    })
    @Select("select num, user_id, article_id " +
            "from bad " +
            "where user_id = #{userId} and article_id = #{articleId}")
    ArticleBad selectArticleBad(UserAndArticleIdParam param);

    @Delete("delete from bad where num = #{articleBadId}")
    void deleteArticleBad(Long articleBadId);

    @Options(useGeneratedKeys = true, keyProperty = "num", keyColumn = "num")
    @Insert("insert into bad (user_id, article_id) " +
            "values (#{userId}, #{articleId})")
    void insertArticleBad(ArticleBad articleBad);
}
