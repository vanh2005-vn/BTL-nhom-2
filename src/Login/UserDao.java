package Login;

public class UserDao {
    public boolean checkUser(User user) {
        if (user != null) {
            if ("Nhom2".equals(user.getUserName()) 
                    && "Nhom2".equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
