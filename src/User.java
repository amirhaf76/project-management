import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class User {

    private String userName;
    private String password;
    private String email;
    private String phoneNumber;

    private final ArrayList<Project> projects = new ArrayList<Project>();

    public User(String userName, String password, String email, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
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

    public Iterator getJoinedProjects() {
        return projects.iterator();
    }

    public boolean addNewProject(Project newProject) {
        return projects.add(newProject);
    }

    public boolean removeProject(Project project) {
        return projects.remove(project);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return "userName: " + userName + '\n' +
                "email: " + email + '\n' +
                "phoneNumber='" + phoneNumber
                ;
    }
}
