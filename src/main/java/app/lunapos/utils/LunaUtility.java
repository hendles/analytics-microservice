package app.lunapos.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Validator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import app.lunapos.restclients.LunaPosMainClient;

@ApplicationScoped
public class LunaUtility {

    @Inject
    @RestClient
    LunaPosMainClient lunaPosMainClient;

    @Inject
    Validator validator;

    @Inject
    ObjectMapper om;


}
