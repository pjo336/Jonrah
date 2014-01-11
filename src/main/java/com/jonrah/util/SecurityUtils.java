package com.jonrah.util;

import com.jonrah.user.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 */
public class SecurityUtils {

    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
