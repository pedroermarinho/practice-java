package dev.ia;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/travel")
public class TravelAgentResource {


    @Inject
    PackageExpert expert;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String ask(String question, @HeaderParam("X-User-Name") String userName) {
        if (userName == null || userName.isBlank()) {
            return "Usuário precisa estar autenticado!";
        }
        try {
            SecurityContext.setCurrentUser(userName);
            return  expert.chat(userName,question);
        } finally {
            SecurityContext.clear();
        }
    }
}
