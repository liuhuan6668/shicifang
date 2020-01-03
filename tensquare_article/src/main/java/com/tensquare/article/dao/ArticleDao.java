package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{

    @Modifying//增,删.改都得加.线程问题
    @Query(value = "update tb_articl set state = 1 where id = ?",nativeQuery = true)
    public void updateState(String id);

    @Modifying//增,删.改都得加.线程问题,,
    //thumbup不能为null,,,null做计算=null
    @Query(value = "update tb_articl set thumbup = thumbup+1 where id = ?",nativeQuery = true)
    public void addThumbup(String id);
}
