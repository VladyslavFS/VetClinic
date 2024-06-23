package org.MagicVet.component;

import org.MagicVet.Main;
import org.MagicVet.model.Client;
import org.MagicVet.model.Pet;
import org.MagicVet.service.ClientService;
import org.MagicVet.service.PetService;

public class ApplicationRunner {

    private final EntityRegister register = new EntityRegister();

    public void run() {
        if (Authenticator.auth()) {
            register.registerClients();
        }
    }
}
