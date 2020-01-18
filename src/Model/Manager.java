package Model;

import java.util.Objects;

public class Manager extends User {

    private int managerId;

    public Manager(int managerId, User user) {
        super(user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getPhoneNumber()
        );
        this.managerId = managerId;
    }

    public int getManagerId() {
        return managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return managerId == manager.managerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), managerId);
    }
}
