package br.com.unicarioca.unimail.rmi;

import java.io.Serializable;

/**
 * Created by alessandro.santos on 11/15/16.
 */
public class ResponseDTO implements Serializable {

    private String status;

    private UserDTO userDTO;

    public ResponseDTO(String status, UserDTO userDTO) {
        this.status = status;
        this.userDTO = userDTO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResponseDTO{");
        sb.append("status='").append(status).append('\'');
        sb.append(", userDTO=").append(userDTO);
        sb.append('}');
        return sb.toString();
    }
}
