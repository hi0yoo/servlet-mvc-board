package bit.report.servletmvcboard.dao;

import bit.report.servletmvcboard.dao.model.Article;
import bit.report.servletmvcboard.dao.param.ArticleListParam;
import bit.report.servletmvcboard.dao.param.UpdateArticleParam;
import bit.report.servletmvcboard.dao.param.UserAndArticleIdParam;
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

    ArticleDetailsDto selectArticleDetails(UserAndArticleIdParam param);

    List<ArticleSummary> selectArticleSummaryList(ArticleListParam param);

    int selectArticleSummaryCount(String keyword);

    @Update("update article set title = #{title}, content = #{content}, last_modified_at = now() " +
            "where article_id = #{articleId}")
    void updateArticle(UpdateArticleParam param);

    @Delete("delete from article where article_id = #{articleId}")
    void deleteArticle(Long articleId);

    List<ArticleSummary> selectArticleSummaryListByScrapUserId(Long userId);
}
