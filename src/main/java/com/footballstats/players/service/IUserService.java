
package com.footballstats.players.service;

import com.footballstats.players.model.Player;
import com.footballstats.players.model.User;
import java.util.List;


public interface IUserService {
    
     public List<User> getUsers();
     
     public void createUser(User user);
}
