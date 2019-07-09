package com.auxo.resources;


import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;


@Path("/auxo/files")
@Produces(MediaType.APPLICATION_JSON)
public class FileResources {


    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {

        String location = "E:\\Txt\\" + fileDetail.getFileName();

        System.out.println("location "+location);
Producer producer=new Producer();


        return Response.ok(producer.parseThis(location)).build();
    }

}