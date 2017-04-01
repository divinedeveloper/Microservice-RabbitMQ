package aerod.backend.messaging

import grails.plugins.rest.client.RestBuilder


class RabbitMQReceiverService {
	static rabbitQueue = 'queueSocial'
	def rest = new RestBuilder(connectTimeout:1000, readTimeout:20000, proxy:['aerod-staging.rkgtechllc.com':8080])
	// This method gets called by the plugin whenever there is any new message in the queue.
	// We can configure n number of parallel handlers
	void handleMessage(message){
		System.out.println("Message Received ${message}")
		// We have recieved the message from the rabbitmq server's queue
		def resp =rest.post("http://aerod-staging.rkgtechllc.com/socialapis/v1/activity?action=create"){
			contentType  "application/json"
			json "${message}"					
			}
		System.out.println(resp.body);	
	}
}
