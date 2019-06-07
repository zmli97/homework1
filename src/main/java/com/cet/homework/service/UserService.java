package com.cet.homework.service;

import com.cet.homework.entity.User;
import com.cet.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//王嘉奇
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUser(int number) {
        return userRepository.find(number);
    }
}
