package com.kaspaza.booklibrary.service;

import com.kaspaza.booklibrary.domain.User;
import com.kaspaza.booklibrary.dto.UserDto;
import com.kaspaza.booklibrary.mapper.UserMapper;
import com.kaspaza.booklibrary.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(a -> users.add(a));
        return userMapper.usersToUsersDto(users);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    public void saveOrUpdate(Set<User> users) {
        userRepository.saveAll(users);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public void update(User user, int userId) {
        userRepository.save(user);
    }
}
