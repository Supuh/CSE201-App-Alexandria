

import java.util.ArrayList;


public class UserDaoImpl implements UserDao {

    ArrayList<UserBean> arrList = new ArrayList<UserBean>();

    @Override
    public boolean isLognUser(UserBean user) {
        boolean flag = false;

        for (UserBean userBean : arrList) {
            if (userBean != null) {
                if(userBean.getUsername().equals(user.getUsername()) && userBean.getPassword().equals(user.getPassword())){
                    flag = true;
                }
            }
        }

        return flag;
    }

    @Override
    public boolean registerUser(UserBean user) {
        boolean flag = true;

        arrList.add(user);

        return true;
    }

}
