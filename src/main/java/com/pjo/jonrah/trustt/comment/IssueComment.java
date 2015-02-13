package com.pjo.jonrah.trustt.comment;

import com.pjo.jonrah.entity.JonrahEntity;
import com.pjo.jonrah.trustt.issue.Issue;
import com.pjo.jonrah.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Peter Johnston on 12/26/13
 * Jonrah
 */

@Entity
@Table(name = "JONRAH_ISSUE_COMMENT")
public class IssueComment implements JonrahEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name="bug_id")
    private Issue bug;

    @ManyToOne
    @JoinColumn(name="commenter_id")
    private User commenter;

    @Column(name="comment")
    private String comment;

    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Issue getBugId() {
        return bug;
    }

    public void setBugId(Issue bugId) {
        this.bug = bugId;
    }

    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}
