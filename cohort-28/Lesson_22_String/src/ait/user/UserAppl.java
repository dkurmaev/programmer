package ait.user;

import ait.user.model.User;

public class UserAppl {
    public static void main(String[] args) {

        User user = new User("peter@gmail.com", "Ad12@34*");
        System.out.println(user);
        user.setEmail("pe-ter@yahoo.com");
        user.setPassword("1213544648");
        user.setPassword("Ad12@34*");
        System.out.println(user);



    }
}
