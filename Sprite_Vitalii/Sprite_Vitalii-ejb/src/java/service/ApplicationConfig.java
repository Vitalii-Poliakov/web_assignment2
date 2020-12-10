/****************************************************************************************************
 * File name: ApplicationConfig.java
 * Author: Vitalii Poliakov (040941169)
 * Course: CST8218 - Web Enterprise Application, Section: 302
 * Assignment: 2
 * Date: 2020 December 9
 * Professor: Todd Kelley
 * Purpose: 
 ****************************************************************************************************/


package service;

import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;

/**
 *
 * @author vital
 */
// checks appuser table for groupname and password
@DatabaseIdentityStoreDefinition (
    dataSourceLookup = "${'java:comp/DefaultDataSource'}",
    callerQuery = "#{'select password from app.appuser where userid = ?'}",
    groupsQuery = "select groupname from app.appuser where userid = ?",
    hashAlgorithm = PasswordHash.class,
    priority = 10
)
// Asks for userid and passowrd input when app opens
@BasicAuthenticationMechanismDefinition
//@FormAuthenticationMechanismDefinition(
//        loginToContinue = @LoginToContinue(
//                loginPage = "/index.xhtml",
//                errorPage = "/index.xhtml"))
@Named
@ApplicationScoped
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.SpriteFacadeREST.class);
    }
    
}
