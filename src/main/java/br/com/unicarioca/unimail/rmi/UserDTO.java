package br.com.unicarioca.unimail.rmi;

import java.io.Serializable;

/**
 * Created by alessandro.santos on 11/15/16.
 */
public class UserDTO implements Serializable {

    private Long id;

    private String email;

    private String name;

    public UserDTO(String email, String name, Long id) {
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserDTO{");
        sb.append("email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
