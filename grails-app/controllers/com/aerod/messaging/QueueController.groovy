package com.aerod.messaging

import grails.converters.JSON
import grails.rest.RestfulController

import org.codehaus.groovy.grails.web.json.JSONObject

/**
 * 
 * @author Nilesh
 * This queue controller takes Json body from request
 * which will be sent on a messaging queue
 *
 */
class QueueController  extends RestfulController{
	
	def rabbitMQSenderService;

	/**
	 * api to send message on social queue to create user and send emails
	 * @return responseJson
	 */
	def sendMessageToCreateUser(){
		try{
			JSONObject jsonBody = request.getJSON()
			Map responseJson = [:]
			boolean isMessageSentOnQueue = rabbitMQSenderService.sendMessageToQueue(jsonBody)
			responseJson.error = false
			responseJson.isMessageSentOnQueue = isMessageSentOnQueue

			render responseJson as JSON
		}catch(IOException | InterruptedException e){
			log.error e.message
		}
	}
	
		
}
