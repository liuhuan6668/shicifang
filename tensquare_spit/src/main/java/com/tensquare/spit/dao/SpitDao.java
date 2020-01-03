package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spli;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author liuhuan
 * @date
 * @描述
 */
public interface SpitDao extends MongoRepository<Spli,String> {
}
