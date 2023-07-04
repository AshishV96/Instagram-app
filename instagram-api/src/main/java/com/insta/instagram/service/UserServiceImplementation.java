package com.insta.instagram.service;

import com.insta.instagram.exceptions.UserException;
import com.insta.instagram.model.User;
import com.insta.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User registerUser(User user) throws UserException {

        Optional<User> isEmailExist = userRepository.findByEmail(user.getEmail());

        if(isEmailExist.isPresent())
        {
            throw new UserException("Email Already Exists");
        }

        Optional<User> isUsernameExist = userRepository.findByUsername(user.getUsername());

        if(isUsernameExist.isPresent())
        {
            throw new UserException("Username Already Taken");
        }

        if(user.getEmail()==null || user.getPassword()==null || user.getUsername()==null || user.getName()==null)
        {
            throw new UserException("All fields are required");
        }

        User newUser = new User();

        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        newUser.setName(user.getName());

        return userRepository.save(newUser);
    }

    @Override
    public User findUserById(Integer userId) throws UserException {

        Optional<User> opt = userRepository.findById(userId);

        if(opt.isPresent())
        {
            return opt.get();
        }
        throw new UserException("User not exist with id: "+userId);
    }

    @Override
    public User findUserProfile(String token) throws UserException {
        return null;
    }

    @Override
    public User findUserByUsername(String username) throws UserException {
        return null;
    }

    @Override
    public String followUser(Integer reqUserId, Integer followUserId) throws UserException {
        return null;
    }

    @Override
    public String unFollowUser(Integer reqUserId, Integer followUserId) throws UserException {
        return null;
    }

    @Override
    public List<User> findUserByIds(List<Integer> userIds) throws UserException {
        return null;
    }

    @Override
    public List<User> searchUser(String query) throws UserException {
        return null;
    }

    @Override
    public User updateUserDetails(User updatedUser, User existingUser) throws UserException {
        return null;
    }
}
