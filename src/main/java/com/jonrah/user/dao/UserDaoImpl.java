package com.jonrah.user.dao;

import com.jonrah.entity.dao.EntityDaoImpl;
import com.jonrah.user.User;
import org.springframework.stereotype.Component;

/**
 * Created by pjo336 on 12/19/13
 * biggertime
 */

@Component
public class UserDaoImpl extends EntityDaoImpl<User> implements UserDao {

    @Override
    public void updateOrCreateUser(User user) {
        entityManager.merge(user);
    }
}
