package com.jonrah.user.dao;

import com.jonrah.genericdao.GenericDao;
import com.jonrah.user.User;
import javassist.NotFoundException;
import org.hibernate.Criteria;

import java.util.List;

public interface UserDao extends GenericDao<User, Long> {

    /**
     * Create and return a Criteria object. Can be used in the service layer to create custom criteria queries
     * @return
     */
    public Criteria createCrit();

    /**
     * Returns the user based on the given Id
     * @param id
     * @return
     */
    public User restoreUserById(long id) throws NotFoundException;


    public List<User> findCritList(Criteria crit);

}
