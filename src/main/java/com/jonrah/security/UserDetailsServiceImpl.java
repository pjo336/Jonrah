package com.jonrah.security;

import com.jonrah.user.User;
import com.jonrah.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by pjo336 on 12/21/13
 * biggertime
 */
@Service
@Transactional(readOnly=true)
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserDao userDAO;

    private User user;

    /**
     * Find the user with this login, and convert it to a UserDetails User, which is then used to authenticate
     * a login. Right now this is performed with magic "trues" for 4 fields. We may want to look into these and
     * further alter the jonrah.User schema
     * @param login
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        // Find the user
        List<User> userList = userDAO.findUserByLogin(login);
        // If the list is empty, throw an exception
        if(userList.size() == 0) {
            throw new UsernameNotFoundException("User was not found");
        } else {
            user = userDAO.findUserByLogin(login).get(0);
        }

        // We have our user, so lets get his role and send him on to be authenticated
        Collection<? extends GrantedAuthority> blah = getRole(user);
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                blah);
    };

    /**
     * This returns the role assigned to the user given. Right now each user can only have one role,
     * but since this returns a collection, it would be easy to implement multiple roles
     * @param user
     * @return
     */
    public Collection<? extends GrantedAuthority> getRole(User user) {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        for(Authority auth: Authority.values()) {
            if(auth.value().equals(user.getUserType().value())) {
                list.add(new SimpleGrantedAuthority(auth.name()));
            }
        }
        return list;
    }

    /**
     * Right now these have to match the value of the correct UserType values. This needs to be fixed before it causes
     * any problems.
     */
    public enum Authority {
        ROLE_ADMIN("0"),
        ROLE_AUTHORITY("1"),
        ROLE_USER("2"),
        ROLE_ANONYMOUS("3");

        public String userTypeValue;

        private Authority(String type) {
            this.userTypeValue = type;
        }

        public String value() {
            return String.valueOf(ordinal());
        }
    }
}