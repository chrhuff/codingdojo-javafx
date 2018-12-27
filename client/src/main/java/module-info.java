module client {
    requires model;
    requires service;

    requires javafx.controls;
    requires javafx.fxml;
    //requires resteasy.jaxrs;
    //requires resteasy.jaxb.provider;
    //requires resteasy.client;
    //requires resteasy.client.api;
    requires cdi.api;
    requires javax.inject;
    requires java.xml.bind;
    requires java.ws.rs;
    requires weld.core.impl;
    requires java.net.http;
    requires java.activation;
    opens de.cofinpro.codingdojo.client to javafx.graphics, weld.core.impl, javafx.fxml;

    uses de.cofinpro.codingdojo.service.MinesweeperService;
}