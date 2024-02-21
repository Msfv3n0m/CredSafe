package com.example.credsafe;

public class LoginModal {

    // variables for our siteName,
    // description, tracks and duration, id.
    private String siteName;
    private String username;
    private String password;
    private int id;

    // creating getter and setter methods
    public String getsiteName() { return siteName; }

    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void
    setPassword(String password)
    {
        this.password = password;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public LoginModal(String siteName,
                       String username,
                       String password)
    {
        this.siteName = siteName;
        this.username = username;
        this.password = password;
    }
}
