/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTFUL;

import General.Patch;
import General.PatchValidate;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author irshed-pt2884
 */
@Path("InsertAPI")
public class InsertPatchResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of InsertPatchResource
     */
    public InsertPatchResource() {
    }

    /**
     * Retrieves representation of an instance of RESTFUL.InsertPatchResource
     *
     * @param obj
     * @return an instance of java.lang.String
     * @throws org.json.simple.parser.ParseException
     */
    @POST
    @Path("/Insert")
    @Consumes("application/json")
    @Produces({"application/json;charset=UTF-8"})
    public Patch insertPatch(@Valid @PatchValidate Patch obj)throws ValidationException {
        String result = Patch.insertPatch(obj);
        return obj;
    }

    /**
     * PUT method for updating or creating an instance of InsertPatchResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
