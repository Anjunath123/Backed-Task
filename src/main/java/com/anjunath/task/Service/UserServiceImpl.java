package com.anjunath.task.Service;

import com.anjunath.task.Exception.UserNotFoundException;
import com.anjunath.task.Model.User;
import com.anjunath.task.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl  implements UserService{


    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        if(id==null)
        {
            throw new UserNotFoundException("user not found");
        }
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

   @Override
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            user.setId(user.getId());
            user.setUserName(user.getUserName());
            user.setPassword(user.getPassword());
            user.setEmail(user.getEmail());
            user.setMobileNo(user.getMobileNo());
            user.setJobRole(user.getJobRole());
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
