import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

response = WS.sendRequest(findTestObject('API Requests/User Info/get user with ID', [('userToken') : GlobalVariable.token]))

println(response.getResponseBodyContent())

// Verifying API Response here
WS.verifyResponseStatusCode(response, 200)

def slurper = new JsonSlurper()
def result = slurper.parseText(response.getResponseBodyContent())

// Parsing API response and store it here
def id = result.id
def username = result.username
def displayName = result.displayName
def fname = result.firstName
def lname = result.lastName
def type = result.type
def emailAddress = result.emailAddress

// Getting data from API and verify it here
WS.verifyEqual(id, 'b7483db2-43db-4f10-9e87-8a0ab64e362d')
WS.verifyEqual(username, 'bbenick-adm')
WS.verifyEqual(displayName, 'Brad Benick')
WS.verifyEqual(fname, 'Brad')
WS.verifyEqual(lname, 'Benick')
WS.verifyEqual(type, 'Workforce')
WS.verifyEqual(emailAddress, 'bbenick-adm@ga.afginc.com')