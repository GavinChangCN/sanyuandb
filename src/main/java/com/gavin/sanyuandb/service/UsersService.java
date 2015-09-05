package com.gavin.sanyuandb.service;

import com.gavin.sanyuandb.dao.IUsersDao;
import com.gavin.sanyuandb.model.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Gavin
 * Mail: gavinchangcn@163.com
 * Date: 2015/8/28 0028
 * Time: 23:44
 */
@Service
public class UsersService {


    @Resource
    IUsersDao iuDao;
    public static enum LOGIN_RESULT {
        SUCCESS {
            public int getKey() {
                return 0;
            }
        },
        WRONG_PWD {
            public int getKey() {
                return 1;
            }
        },
        NO_ACCOUNT {
            public int getKey() {
                return 2;
            }
        },
        FAILED {
            public int getKey() {
                return 3;
            }
        };

        public abstract int getKey();
    }

    /**
     * 验证登录
     */
    public int login(Users user) {
        if ( iuDao.getByAccount(user.getName()) ){
            if ( iuDao.selectPwdByAccount(user.getName()).equals(user.getPwd())) {
                return LOGIN_RESULT.SUCCESS.getKey();
            } else {
                return LOGIN_RESULT.WRONG_PWD.getKey();
            }
        } else {
            return LOGIN_RESULT.NO_ACCOUNT.getKey();
        }
    }
}
