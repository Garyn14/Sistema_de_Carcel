
package modelos;

public class Admin {
    // atributos
    private final String user;
    private final String password;

    public Admin(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
