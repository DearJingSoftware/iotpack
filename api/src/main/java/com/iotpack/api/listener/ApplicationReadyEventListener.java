package com.iotpack.api.listener;

import com.iotpack.api.entity.user.UserEntity;
import com.iotpack.api.entity.user.UserRepository;
import com.iotpack.api.utils.PasswordUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    UserRepository userRepository;

    @Value("${iotpack.admin.username}")
    String username;
    @Value("${iotpack.admin.password}")
    String password;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        if (!userRepository.findFirstByAccount(username).isPresent()) {
            UserEntity userEntity = new UserEntity();
            userEntity.setAccount(username);
            userEntity.setPassword(username);
            userEntity.setPassword(PasswordUtils.getMd5(PasswordUtils.getMd5(password)));
            log.info("!!! init super admin");
            userRepository.save(userEntity);
        }
    }
}
