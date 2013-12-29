package com.jonrah.trustt.type.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Peter Johnston
 * Date: 12/28/13
 */

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class IssueTypeServiceImpl implements IssueTypeService {
}
