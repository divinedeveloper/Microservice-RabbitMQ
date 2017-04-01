package aerod.backend.messaging

import grails.rest.RestfulController

import org.codehaus.groovy.grails.web.json.JSONObject


class QueueController  extends RestfulController{
	
	def rabbitMQSenderService;

	def index() {
		render "test"
	}

	def sendmessage(){
		//render rabbitMQService.serviceMethod(socialBean)
		JSONObject jsonBody =   request.getJSON()
		
		boolean flag = rabbitMQSenderService.serviceMethod(jsonBody)
		
		render flag
	}
	
		
}
