class User1 extends Users {
    String[] user_info;
    public void infom() {
        String[] user_info = new String[4];
        user_info = user_create();
        user_print(user_info);
    }


}
