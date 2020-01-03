package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
    /**
     * 最新
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem,tb_pl where id = problemid and labelid = ? order by replytime desc ",nativeQuery = true)//nativeQuery = true开启sql
    public Page<Problem> newlist(String labelid, Pageable pageable);

    /**
     * 热门
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem,tb_pl where id = problemid and labelid = ? order by reply desc ",nativeQuery = true)
	public Page<Problem> hotlist(String labelid, Pageable pageable);

    /**
     * 等待
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem,tb_pl where id = problemid and labelid = ? and reply = 0 order by createtima desc ",nativeQuery = true)
    public Page<Problem> waitlist(String labelid, Pageable pageable);
}
