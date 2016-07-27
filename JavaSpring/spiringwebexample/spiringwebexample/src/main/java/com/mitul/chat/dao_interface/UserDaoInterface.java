package com.mitul.chat.dao_interface;

import com.mitul.chat.model.User;

/**
 * Created by Mitul Kapoor on 7/27/2016.
 */
public interface UserDaoInterface {
    public void insert(User user);
    public User verifyUserCredentials(User user);
}
