package com.jonrah.user.dao;

import com.jonrah.genericdao.GenericDaoImpl;
import com.jonrah.user.User;
import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {


    @Override
    public Criteria createCrit() {
        return super.currentSession().getSessionFactory().openSession().createCriteria(User.class);
    }

    @Override
    public User restoreUserById(long id) throws NotFoundException{
        return super.restore(id);
    }

    @Override
    public List<User> findCritList(Criteria crit) {
        return crit.list();
    }
}
