package com.pjo.jonrah.util;

import com.pjo.jonrah.user.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 */
public class SecurityUtils {

    /**
     * Returns the currently logged in user, or returns anonymousUser if not logged in
     * @return user
     */
    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * Returns the currently logged in users name, or returns anonymousUser if not logged in
     * @return users name
     */
    public static String getCurrentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
