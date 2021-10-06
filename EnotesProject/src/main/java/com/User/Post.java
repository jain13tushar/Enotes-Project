package com.User;

import java.util.Date;

/**
 * Description.
 * @author INSERT USERNAME
 */
public class Post
{
    private int nId;

    private String title;

    private String content;

    private Date notesDate;

    private UserDetails userDetails;

    /**
     * @param nId
     * @param title
     * @param content
     * @param notesDate
     * @param userDetails
     */
    public Post(final int nId, final String title, final String content, final Date notesDate, final UserDetails userDetails)
    {
        super();
        this.nId = nId;
        this.title = title;
        this.content = content;
        this.notesDate = notesDate;
        this.userDetails = userDetails;
    }

    /**
     *
     */
    public Post()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the nId.
     */
    public int getnId()
    {
        return nId;
    }

    /**
     * @param nId
     *            the nId to set.
     */
    public void setnId(final int nId)
    {
        this.nId = nId;
    }

    /**
     * @return the title.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title
     *            the title to set.
     */
    public void setTitle(final String title)
    {
        this.title = title;
    }

    /**
     * @return the content.
     */
    public String getContent()
    {
        return content;
    }

    /**
     * @param content
     *            the content to set.
     */
    public void setContent(final String content)
    {
        this.content = content;
    }

    /**
     * @return the notesDate.
     */
    public Date getNotesDate()
    {
        return notesDate;
    }

    /**
     * @param notesDate
     *            the notesDate to set.
     */
    public void setNotesDate(final Date notesDate)
    {
        this.notesDate = notesDate;
    }

    /**
     * @return the userDetails.
     */
    public UserDetails getUserDetails()
    {
        return userDetails;
    }

    /**
     * @param userDetails
     *            the userDetails to set.
     */
    public void setUserDetails(final UserDetails userDetails)
    {
        this.userDetails = userDetails;
    }

}
