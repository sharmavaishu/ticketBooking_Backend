package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {

    private User user;

    private static final String Users_PATH = "app/src/main/java/ticket.booking/localDb/users.json";

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<User> userList;

    //constructor
    public UserBookingService(User user1) throws IOException {
        this.user = user1;

        //read plain text
        File users = new File(Users_PATH);

        //map json data to userList
        userList = objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }

    //Login user
    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    //SignUp User
    public Boolean signUp(User user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }
}
