package com.jonrah.trustt.type;

import com.jonrah.trustt.issue.Issue;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by pjo336 on 12/26/13
 * biggertime
 */

@Entity
@Table(name = "JONRAH_ISSUE_TYPE")
public class IssueType {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name="issue_type_name")
    private String name;

    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    /**
     * Ids referenced in Issues
     */
    @OneToMany(mappedBy="type")
    private Set<Issue> referencedIssueTypes;

    public IssueType() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Issue> getReferencedIssueTypes() {
        return referencedIssueTypes;
    }

    public void setReferencedIssueTypes(Set<Issue> referencedIssueTypes) {
        this.referencedIssueTypes = referencedIssueTypes;
    }

//    public enum IssueTypes {
//        Bug("0", "Bug");
//
//
//
//
//    }
}
