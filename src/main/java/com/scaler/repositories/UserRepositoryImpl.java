package com.scaler.repositories;

import com.scaler.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository{
    Map<Long, User> userMap = new HashMap<>();
    @Override
    public Optional<User> findById(long id) {
        User user = userMap.get(id);
        if(user != null){
           return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        userMap.put(user.getId(), user);
        return user;
    }
}
