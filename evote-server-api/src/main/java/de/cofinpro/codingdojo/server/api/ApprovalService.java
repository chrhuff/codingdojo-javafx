package de.cofinpro.codingdojo.server.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by tahmed on 20.09.2014.
 */
@Path("/approval")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public interface ApprovalService  {
    /**
     * @return election
     */
    @GET
    @Path("/requests/{electionId}")
    List<Approval> getRequests(@PathParam("electionId")Long electionId);

    @GET
    @Path("/approve/{approvalId}")
    void approve(@PathParam("approvalId")Long approvalId);

    @GET
    @Path("/reject/{approvalId}")
    void reject(@PathParam("approvalId")Long approvalId);
}

