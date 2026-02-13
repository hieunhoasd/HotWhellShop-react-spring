package HotWhellShop_Spring_react.service;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import HotWhellShop_Spring_react.domain.User;
import HotWhellShop_Spring_react.domain.DTO.UserDTO.ResGetAllUserDTO;
import HotWhellShop_Spring_react.domain.DTO.UserDTO.ResGetUserByidDTO;
import HotWhellShop_Spring_react.domain.DTO.UserDTO.ResUpdateUserDTO;
import HotWhellShop_Spring_react.domain.DTO.UserDTO.ResUserDTO;
import HotWhellShop_Spring_react.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public User fetchUserByid(long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public List<User> fetchAllUser() {
        return this.userRepository.findAll();
    }

    public User handleUpdateUser(User reqUser) {
        User currentUser = this.fetchUserByid(reqUser.getId());

        if (currentUser != null) {
            currentUser.setEmail(reqUser.getEmail());
            currentUser.setUser_name(reqUser.getUser_name());
            currentUser.setPassword(reqUser.getPassword());

            currentUser = this.userRepository.save(currentUser);
        }
        return currentUser;
    }

    public ResUserDTO handleConvertCreateUserDTO(User user) {
        ResUserDTO res = new ResUserDTO();
        res.setId(user.getId());
        res.setEmail(user.getEmail());
        res.setAvt(user.getAvt());
        res.setPhone(user.getPhone());
        res.setUser_name(user.getUser_name());
        return res;
    }

    public ResUpdateUserDTO handleConvertUpdateUserDTO(User user) {
        ResUpdateUserDTO res = new ResUpdateUserDTO();
        res.setId(user.getId());
        res.setEmail(user.getEmail());
        res.setAvt(user.getAvt());
        res.setPhone(user.getPhone());
        res.setUser_name(user.getUser_name());
        return res;
    }

    public ResGetUserByidDTO handleConvertGetUserByIdDTO(User fetchUser) {
        ResGetUserByidDTO res = new ResGetUserByidDTO();
        res.setId(fetchUser.getId());
        res.setUser_name(fetchUser.getUser_name());
        res.setEmail(fetchUser.getEmail());
        res.setAvt(fetchUser.getAvt());
        res.setPhone(fetchUser.getPhone());

        return res;
    }

    public List<ResGetAllUserDTO> handleConvertGetAllUserDTO() {
        ResGetAllUserDTO res = new ResGetAllUserDTO();
        return this.fetchAllUser()
                .stream()
                .map(user -> {
                    res.setId(user.getId());
                    res.setUser_name(user.getUser_name());
                    res.setEmail(user.getEmail());
                    res.setAvt(user.getAvt());
                    res.setPhone(user.getPhone());
                    return res;
                })
                .toList();
    }

}
