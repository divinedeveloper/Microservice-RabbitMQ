package com.aerod.messaging

import grails.plugins.rest.client.RestBuilder


class EmailModuleReceiverService {
	
	static rabbitSubscribe = 'user.created'
	public static final String CONTENT_TYPE = "application/json"
	def grailsApplication
	
	def rest = new RestBuilder(/*connectTimeout:1000, readTimeout:20000, proxy:['aerod-staging.rkgtechllc.com':8080]*/)
	// This method gets called by the plugin whenever there is any new message in the queue.
	// We can configure n number of parallel handlers
	void handleMessage(message){
		log.debug "Message Received in Email worker ${message}"
		// We have recieved the message from the rabbitmq server's queue
		/*def resp =rest.post(grailsApplication.config.myapp.aerodBaseUrl+grailsApplication.config.myapp.createSocialUser){
			contentType  CONTENT_TYPE
			json "${message}"					
			}
		println "response from rest call is "+resp.body*/
	}
}
