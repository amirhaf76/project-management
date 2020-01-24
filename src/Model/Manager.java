package Model;

import java.util.Objects;

public class Manager extends User {

    private static int baseManagerId = 1;

    private final int managerId;

    public Manager(User user) {
        super(user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getPhoneNumber()
        );
        this.managerId = baseManagerId;

        baseManagerId++;
    }

    public int getManagerId() {
        return managerId;
    }

    public static int getBaseManagerId() {
        return baseManagerId;
    }

    public static void setBaseManagerId(int baseManagerId) {
        Manager.baseManagerId = baseManagerId;
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
