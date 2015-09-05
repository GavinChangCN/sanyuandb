package com.gavin.sanyuandb.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Gavin
 * Mail: gavinchangcn@163.com
 * Date: 2015/8/28 0028
 * Time: 23:44
 */
@Repository
public interface IUsersDao {

    boolean getByAccount(@Param("name")String name);

    String selectPwdByAccount(@Param("name")String name);
}
