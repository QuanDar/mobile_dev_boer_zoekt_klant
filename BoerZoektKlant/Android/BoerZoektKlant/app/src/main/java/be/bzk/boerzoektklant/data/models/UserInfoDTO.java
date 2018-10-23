package be.bzk.boerzoektklant.data.models;

import java.io.Serializable;

/**
 * Created by Jerry on 3/5/2018.
 */

public class UserInfoDTO implements Serializable {

    // Map to json string field user.
    private String user = "";

    // Map to json string field email.
    private String email = "";

    // Map to json string field title.
    private String title = "";

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
