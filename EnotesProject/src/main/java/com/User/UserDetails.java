package com.User;

/**
 * Description.
 * @author INSERT USERNAME
 */
public class UserDetails
{

    private int id;

    private String name;

    private String email;

    private String password;

    /**
     *
     */
    public UserDetails()
    {
        super();
    }

    /**
     * @param name
     * @param email
     * @param password
     */
    public UserDetails(final String name, final String email, final String password)
    {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * @return the id.
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id
     *            the id to set.
     */
    public void setId(final int id)
    {
        this.id = id;
    }

    /**
     * @return the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set.
     */
    public void setName(final String name)
    {
        this.name = name;
    }

    /**
     * @return the email.
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email
     *            the email to set.
     */
    public void setEmail(final String email)
    {
        this.email = email;
    }

    /**
     * @return the password.
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password
     *            the password to set.
     */
    public void setPassword(final String password)
    {
        this.password = password;
    }

}
