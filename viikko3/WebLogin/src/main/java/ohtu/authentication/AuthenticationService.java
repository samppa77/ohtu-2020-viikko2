package ohtu.authentication;

import static java.lang.Character.isLetter;
import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }

        if (username.length()<3 ) {
            status.addError("username should have at least 3 characters");
        }

        // Oma lisäys (tehtävä 10)
        if (password.length()<8 ) {
            status.addError("password should have at least 8 characters");
        }
        if (!password.equals(passwordConfirmation)){
            status.addError("password and password confirmation do not match");
        }
        
        // onko password ei saa koostua vain kirjaimista
       boolean vainkirjamia = true;
        for (int i = 0; i < password.length(); i++){
            // uname[i] = username.charAt(i);
            if (!isLetter(password.charAt(i))){
                vainkirjamia = false;
            }
        }
        if (vainkirjamia == true){
            status.addError("password must not contain only characters");
        }

        
        
        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }

}
