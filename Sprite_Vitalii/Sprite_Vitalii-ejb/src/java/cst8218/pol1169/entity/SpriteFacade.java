/****************************************************************************************************
 * File name: SpriteFacade.java
 * Author: Todd Kelley, Vitalii Poliakov (040941169)
 * Course: CST8218 - Web Enterprise Application, Section: 302
 * Assignment: 2
 * Date: 2020 November 21
 * Professor: Todd Kelley
 * Purpose: Hides the implementation of the underlying classes it is presenting an interface for
 ****************************************************************************************************/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.pol1169.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tgk
 */
@Stateless
public class SpriteFacade extends AbstractFacade<Sprite> {
    @PersistenceContext(unitName = "Sprite_Vitalii-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SpriteFacade() {
        super(Sprite.class);
    }
    
}
