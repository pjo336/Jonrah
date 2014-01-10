package com.jonrah.user.dao;

import com.jonrah.entity.dao.EntityDaoInterface;
import com.jonrah.user.User;

/**
 * Created by pjo336 on 12/19/13
 * biggertime
 */

public interface UserDao extends EntityDaoInterface<User> {

    public void updateOrCreateUser(User user);

}
