package bit.report.servletmvcboard.dao;

import bit.report.servletmvcboard.dao.model.Article;
import bit.report.servletmvcboard.dao.param.ArticleListParam;
import bit.report.servletmvcboard.dao.param.UpdateArticleParam;
import bit.report.servletmvcboard.dto.ArticleDetailsDto;
import bit.report.servletmvcboard.dto.ArticleSummary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleDao {

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "article_id")
    @Insert("insert into article(writer_id, title, content, created_at, last_modified_at) " +
            "values (#{writerId}, #{title}, #{content}, #{createdAt}, #{lastModifiedAt})")
    void insertArticle(Article article);

    @Results(id = "articleDetails", value = {
            @Result(property = "articleId", column = "article_id", id = true),
            @Result(property = "userInfo.userId", column = "writer_id"),
            @Result(property = "userInfo.nickname", column = "writer_nickname"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "lastModifiedAt", column = "last_modified_at")
    })
    @Select("select a.article_id as article_id, " +
            "       a.writer_id as writer_id, " +
            "       u.nickname as writer_nickname, " +
            "       a.title as title, " +
            "       a.content as content, " +
            "       a.created_at as created_at, " +
            "       a.last_modified_at as last_modified_at " +
            "from article a " +
            "left join users u on a.writer_id = u.user_id " +
            "where article_id = ${articleId}")
    ArticleDetailsDto selectArticleDetails(Long articleId);

    List<ArticleSummary> selectArticleSummaryList(ArticleListParam param);

    int selectArticleSummaryCount(String keyword);

    @Update("update article set title = #{title}, content = #{content}, last_modified_at = now() " +
            "where article_id = #{articleId}")
    void updateArticle(UpdateArticleParam param);

    @Delete("delete from article where article_id = #{articleId}")
    void deleteArticle(Long articleId);
}
