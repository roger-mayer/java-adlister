package models;

class Config {

    private String url = "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    private String username = "exercise-user";
    private String password = "password";

    public String getUrl() {
        return this.url;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
}