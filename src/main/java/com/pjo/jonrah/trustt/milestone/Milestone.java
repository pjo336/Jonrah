package com.pjo.jonrah.trustt.milestone;

import com.pjo.jonrah.entity.JonrahEntity;
import com.pjo.jonrah.trustt.issue.Issue;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Peter Johnston on 12/26/13
 * Jonrah
 */

@Entity
@Table(name = "JONRAH_MILESTONE")
public class Milestone implements JonrahEntity {

    public Milestone(){}

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name="milestone_title")
    private String title;

    @Column(name = "due_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;

    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    /**
     * Ids referenced in Issues
     */
    @OneToMany(mappedBy="milestoneId")
    private Set<Issue> referencedIssueMilestones;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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

    public Set<Issue> getReferencedIssueMilestones() {
        return referencedIssueMilestones;
    }

    public void setReferencedIssueMilestones(Set<Issue> referencedIssueMilestones) {
        this.referencedIssueMilestones = referencedIssueMilestones;
    }
}
