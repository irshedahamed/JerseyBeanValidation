/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTFUL;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

/**
 *
 * @author irshed-pt2884
 */
@javax.ws.rs.ApplicationPath("REST")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        ResourceConfig r = new ResourceConfig();
        r.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
      
        
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(General.ValidationException.class);
        resources.add(RESTFUL.InsertPatchResource.class);
        resources.add(com.irshed.patchjersey.InsertPatchResource.class);
     }
    

}
