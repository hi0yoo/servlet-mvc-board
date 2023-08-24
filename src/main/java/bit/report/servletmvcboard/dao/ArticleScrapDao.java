package bit.report.servletmvcboard.dao;

import bit.report.servletmvcboard.dao.model.ArticleScrap;
import bit.report.servletmvcboard.dao.param.UserAndArticleIdParam;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ArticleScrapDao {

    @Results(id = "articleScrap", value = {
            @Result(property = "id", column = "article_scrap_id", id = true),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "articleId", column = "article_id")
    })
    @Select("select article_scrap_id, user_id, article_id " +
            "from article_scrap " +
            "where user_id = #{userId} and article_id = #{articleId}")
    ArticleScrap selectArticleScrap(UserAndArticleIdParam param);

    @Delete("delete from article_scrap where article_scrap_id = #{articleScrapId}")
    void deleteArticleScrap(Long articleScrapId);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "article_scrap_id")
    @Insert("insert into article_scrap (user_id, article_id) " +
            "values (#{userId}, #{articleId})")
    void insertArticleScrap(ArticleScrap articleScrap);
}
