package com.pjo.jonrah.trustt.type.service;

import com.pjo.jonrah.trustt.type.IssueType;

import java.util.List;

/**
 * User: Peter Johnston
 * Date: 12/28/13
 */

public interface IssueTypeService {

    public void addIssueType(IssueType issueType);

    public void saveOrUpdateIssueType(IssueType issueType);

    public List<IssueType> findAllIssueTypes();

    public List<IssueType> findIssueByName(String name);
}
