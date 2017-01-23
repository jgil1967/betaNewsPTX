/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.tweet;

import java.io.Serializable;
import mx.com.paquetexpress.user.UserDTO;

/**
 *
 * @author jonathangil
 */
public class TweetDTO implements Serializable {
    UserDTO user;
    String text;

    public TweetDTO() {
        user = new UserDTO();
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
