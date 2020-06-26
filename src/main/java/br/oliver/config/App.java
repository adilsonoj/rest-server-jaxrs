package br.oliver.config;

import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig{
	public App() {
	       packages("br.oliver");
	       register(new ApplicationBinder());  
	    }
}
