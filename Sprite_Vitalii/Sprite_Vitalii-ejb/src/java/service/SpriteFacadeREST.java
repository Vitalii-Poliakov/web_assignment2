/****************************************************************************************************
 * File name: SpriteFacadeREST.java
 * Author: Vitalii Poliakov (040941169)
 * Course: CST8218 - Web Enterprise Application, Section: 302
 * Assignment: 2
 * Date: 2020 December 9
 * Professor: Todd Kelley
 * Purpose: Sets persistence context and defines endpoints.
 ****************************************************************************************************/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cst8218.pol1169.entity.Sprite;
import cst8218.pol1169.entity.AbstractFacade;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vital
 */
@Stateless
@DeclareRoles({"Admin", "RestGroup"})
@RolesAllowed({"Admin", "RestGroup"})
@Path("cst8218.pol1169.entity.sprite")
public class SpriteFacadeREST extends AbstractFacade<Sprite> {

    @PersistenceContext(unitName = "Sprite_Vitalii-ejbPU")
    private EntityManager em;

    public SpriteFacadeREST() {
        super(Sprite.class);
    }
    /** REST Method to create a Sprite.
     * POST <base-url>/resources/cst8218.pol1169.entity.sprite
     * @param entity The Sprite to create
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Sprite entity) {
        super.create(entity);
    }
    /** REST Method to update a Sprite by Id.
     * PUT <base-url>/resources/cst8218.pol1169.entity.sprite/<id>
     * @param id The Id of the Sprite to update
     * @param entity The updated Sprite entity
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Sprite entity) {
        super.edit(entity);
    }
    /** REST Method to delete a Sprite.
     * DELETE <base-url>/resources/cst8218.pol1169.entity.sprite/<id>
     * @param id The Id of the Sprite to delete
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }
    /** REST Method to get a Sprite by Id.
     * GET <base-url>/resources/cst8218.pol1169.entity.sprite/<id>
     * @param id The Id of the Sprite to get
     * @return A Sprite object matching the Id
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sprite find(@PathParam("id") Long id) {
        return super.find(id);
    }
    /** REST Method to get a list of all Sprites.
     * GET <base-url>/resources/cst8218.pol1169.entity.sprite
     * @return a List of all Sprite objects
     */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findAll() {
        return super.findAll();
    }
     /** REST Method to get a list of Sprites in a range of Ids
     * GET <base-url>/resources/cst8218.pol1169.entity.sprite/<from>/<to>
     * @param from The first Id in the range of Sprites
     * @param to The last Id in the range of Sprites
     * @return a List of Sprite objects matching the range of provided Ids 
     */
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
     /** REST Method to get the count of Sprites
     * GET <base-url>/resources/cst8218.pol1169.entity.sprite/count
     * @return a String representing the count of Sprites
     */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
