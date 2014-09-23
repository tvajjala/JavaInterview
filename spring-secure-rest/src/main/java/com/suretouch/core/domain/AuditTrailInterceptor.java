package com.suretouch.core.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/**
 * 
 * @author tvajjala
 *
 */
public class AuditTrailInterceptor extends EmptyInterceptor {

    /**
     * 
     */
    private static final long serialVersionUID = -637636936313273122L;

    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        setValue(currentState, propertyNames, "updatedBy", "");
        setValue(currentState, propertyNames, "updatedOn", new Date());
        return true;
    }

    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        setValue(state, propertyNames, "createdBy", "");
        setValue(state, propertyNames, "createdOn", new Date());
        return true;
    }

    private void setValue(Object[] currentState, String[] propertyNames, String propertyToSet, Object value) {

        int index = Arrays.asList(propertyNames).indexOf(propertyToSet);

        if (index >= 0) {
            currentState[index] = value;
        }
    }
}