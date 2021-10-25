public class LoginTester {

    public static void main(String[] args) {

        UserDao ud = new UserDaoImpl();

        UserBean user = new UserBean("pizza");

        String name = "Jack";
        String password = "abc123";


        user.setUsername(name);
        user.setPassword(password);


        UserBean user1 = new UserBean("Jack","abc123");

        //method of register
        if(ud.registerUser(user)){
            System.out.println("sign up success");

            //method of login
            boolean result = ud.isLognUser(user1);
            if(result){
                System.out.println("login success");
            }else{
                System.out.println("Username and passport don't match");
            }
        }else{
            System.out.println("sign up fail");
        }


    }

}
