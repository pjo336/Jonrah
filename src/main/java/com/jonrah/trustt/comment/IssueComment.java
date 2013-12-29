package com.jonrah.trustt.comment;

import com.jonrah.entity.EntityInterface;
import com.jonrah.trustt.issue.Issue;
import com.jonrah.user.User;

import javax.persistence.*;

/**
 * Created by pjo336 on 12/26/13
 * biggertime
 */

@Entity
@Table(name = "JONRAH_ISSUE_COMMENT")
public class IssueComment implements EntityInterface {

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
}
