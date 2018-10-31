package com.tasly.user.core;

import com.tasly.user.api.UserService;
import com.tasly.user.db.domain.User;
import com.tasly.user.db.reposity.UserReposity;
import com.tasly.user.dto.UserDTO;
import com.tasly.user.dto.UsernameAndPasswordDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.tasly.commons.utils.Beans.transfrom;


/**
 * Created by dulei on 18/1/8.
 */
@RefreshScope
@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    private UserReposity userReposity;


    @Override
    public UserDTO getByUsernameAndPasswordDTO(UsernameAndPasswordDTO usernameAndPasswordDTO) {

        User user = new User();
        user.setAge(24);
        user.setName("张三");
        user.setPassword("admin");
        user.setUsername("admin" );

        return transfrom(UserDTO.class,userReposity.save(user));
    }

    @Override
    public UserDTO get(@PathVariable("uid") Long uid) {

        User user = new User();
        user.setId(uid);
        user.setAge(24);
        user.setName("张三");
        user.setPassword("admin");
        user.setUsername("admin");

        return transfrom(UserDTO.class,userReposity.save(user));
    }
}
