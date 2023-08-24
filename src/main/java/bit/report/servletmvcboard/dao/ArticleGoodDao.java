package bit.report.servletmvcboard.dao;

import bit.report.servletmvcboard.dao.model.ArticleGood;
import bit.report.servletmvcboard.dao.param.UserAndArticleIdParam;
import org.apache.ibatis.annotations.*;

public interface ArticleGoodDao {

    @Results(id = "articleGood", value = {
            @Result(property = "num", column = "num", id = true),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "articleId", column = "article_id")
    })
    @Select("select num, user_id, article_id " +
            "from good " +
            "where user_id = #{userId} and article_id = #{articleId}")
    ArticleGood selectArticleGood(UserAndArticleIdParam param);

    @Delete("delete from good where num = #{articleGoodId}")
    void deleteArticleGood(Long articleGoodId);

    @Options(useGeneratedKeys = true, keyProperty = "num", keyColumn = "num")
    @Insert("insert into good (user_id, article_id) " +
            "values (#{userId}, #{articleId})")
    void insertArticleGood(ArticleGood articleGood);
}
