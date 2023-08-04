package ait.user;

import ait.user.model.User;

public class UserAppl {
    public static void main(String[] args) {
        User user = new User("peter@gmail.com", "F1234@Nk");
        System.out.println(user);
        user.setEmail("peter@yahoo.com");
        user.setPassword("F1234Nk");
        System.out.println(user);
        user.setEmail("mark@gmx.de");
        user.setPassword("D@1234567");
        System.out.println(user);
    }
}