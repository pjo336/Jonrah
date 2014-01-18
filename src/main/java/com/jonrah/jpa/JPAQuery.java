package com.jonrah.jpa;

import com.jonrah.entity.JonrahEntity;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Peter Johnston on 1/17/14
 * Jonrah
 */

@Component
public class JPAQuery {

    public String query(TypedQuery typedQuery, Class clazz) {
        return "";
    }
    public static String equals(String column, Object itemToCompare, JonrahEntity entity) {
       // String tableName = entity.getTableName();
        return "";
    }

    public String createSelectStatement(List<String> selects) {
        if(selects.size() == 0) {
            return null;
        }
        StringBuffer selectStatement = new StringBuffer();
        selectStatement.append("SELECT ");
        for(String s: selects) {
            selectStatement.append(s);
            if( (selects.size() > 1) && !(selects.indexOf(s) == (selects.size() - 1) )) {
                selectStatement.append(", ");
            }
        }
        return selectStatement.toString();
    }

    public String createFromStatement(String selectStatment, List<String> froms) {
        if(froms.size() == 0) {
            return null;
        }
        StringBuffer fromStatement = new StringBuffer();
        fromStatement.append(selectStatment + " ");
        fromStatement.append("FROM ");
        for(String s: froms) {
            fromStatement.append(s);
            if( (froms.size() > 1) && !(froms.indexOf(s) == (froms.size() - 1) )) {
                fromStatement.append(", ");
            }
        }
        return fromStatement.toString();
    }

    public String createWhereStatement(String fromStatment, List<String> wheres) {
        return "WHERE ? ! ?";
    }
}
