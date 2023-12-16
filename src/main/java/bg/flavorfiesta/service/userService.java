package bg.flavorfiesta.service;

import bg.flavorfiesta.model.dto.UserRegisterDto;
import bg.flavorfiesta.model.entity.UserEntity;
import bg.flavorfiesta.repository.userRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userService {
    private final bg.flavorfiesta.repository.userRepository userRepository;

    public userService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createNewUser(UserRegisterDto regModelDto) {

       Optional<UserEntity> optionalUser = userRepository.findByUsername(regModelDto.getUsername());
        Optional<UserEntity> optionalEmail = userRepository.findByEmail(regModelDto.getEmail());

        if(optionalUser.isPresent()) {
            return false;
        }

        if(optionalEmail.isPresent()) {
            return false;
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(regModelDto.getPassword());
        UserEntity newUser = new UserEntity();
        newUser.setUsername(regModelDto.getUsername());
        newUser.setEmail(regModelDto.getEmail());
        newUser.setPassword(encode);

        userRepository.save(newUser);

        return true;
    }
}
