class UrlMappings {

	static mappings = {
		
		"/api/v1/create-user"(controller:'queue',action:'sendMessageToCreateUser',method:"POST")
		
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

	}
}
