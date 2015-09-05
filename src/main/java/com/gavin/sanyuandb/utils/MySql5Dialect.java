package com.gavin.sanyuandb.utils;

/**
 * MySQL数据库方言
 * 
 * @author StarZou
 * @since 2014年5月18日 下午1:32:52
 **/
public class MySql5Dialect {

    protected static final String SQL_END_DELIMITER = ";";

    public String getLimitString(String sql, int offset, int limit) {
        return MySql5PageHepler.getLimitString(sql, offset, limit);
    }

    public String getCountString(String sql) {
        return MySql5PageHepler.getCountString(sql);
    }
}
