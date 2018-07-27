package com.example.demo.controllor;

import com.example.demo.entity.User;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class UserControllor {

    private UserRepository userRepository;
    private GroupRepository groupRepository;
    @Autowired
    public  UserControllor (UserRepository userRepository,GroupRepository groupRepository){
        this.userRepository=userRepository;
        this.groupRepository=groupRepository;
    }

    @Transactional
    @GetMapping("/user")
    public List<User> getUsers(){
        return  userRepository.findAll();
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        if(user.getGroupList()!=null){
            groupRepository.saveAll(user.getGroupList());
        }
      return   userRepository.save(user);
    }

    @PostMapping("/user/{id}")
    public User updateUser(@PathVariable Long id){
        User user=userRepository.findById(id).get();
        if(user.getGroupList()!=null){
            groupRepository.saveAll(user.getGroupList());
        }
        return   userRepository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public  boolean deleteUser(@PathVariable Long id)
    {    if(userRepository.findById(id).get()!=null)
              { userRepository.delete(userRepository.findById(id).get());
                 return  true;
              }

              return false;
    }
}
