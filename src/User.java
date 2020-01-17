import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class User {

    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    private final ArrayList<Project> projects = new ArrayList<Project>();

    public User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "username: " + username + '\n' +
                "email: " + email + '\n' +
                "phoneNumber='" + phoneNumber
                ;
    }
}
