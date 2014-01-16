package com.jonrah.user.dao;

import com.jonrah.entity.dao.EntityDao;
import com.jonrah.user.User;

/**
 * Created by Peter Johnston on 12/19/13
 * Jonrah
 */

public interface UserDao extends EntityDao<User> {

    public void updateOrCreateUser(User user);

}
