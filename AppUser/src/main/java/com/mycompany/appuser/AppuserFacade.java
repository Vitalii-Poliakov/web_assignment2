/****************************************************************************************************
 * File name: AppuserFacade.java
 * Author: Vitalii Poliakov (040941169)
 * Course: CST8218 - Web Enterprise Application, Section: 302
 * Assignment: 2
 * Date: 2020 December 9
 * Professor: Todd Kelley
 * Purpose: Hides the implementation of the underlying classes it is presenting an interface for
 ****************************************************************************************************/

package com.mycompany.appuser;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Me
 */
@Stateless
public class AppuserFacade extends AbstractFacade<Appuser> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppuserFacade() {
        super(Appuser.class);
    }
    
}
