import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable

//*************************** Empty credentials field **********************************************************************************
response = WS.sendRequest(findTestObject('API Requests/User Info/InValid - blank credentials', [('userToken') : GlobalVariable.token]))
println(response.getResponseBodyContent())

// Verifying API Response here
WS.verifyResponseStatusCode(response, 400)

def slurper = new JsonSlurper()
def result = slurper.parseText(response.getResponseBodyContent())

// Parsing API response and store it here
def userName = result.Username
def password = result.Password

// Getting data from API and verify it here
WS.verifyMatch(userName.toString(), '[Username is missing.]', false, FailureHandling.STOP_ON_FAILURE)
WS.verifyMatch(password.toString(), '[\'Password\' must not be empty.]', false, FailureHandling.STOP_ON_FAILURE)

//*************************** Empty password field **********************************************************************************
response1 = WS.sendRequest(findTestObject('API Requests/User Info/InValid - Empty pwd', [('userToken') : GlobalVariable.token]))
println(response1.getResponseBodyContent())

// Verifying API Response here
WS.verifyResponseStatusCode(response1, 400)

def slurper1 = new JsonSlurper()
def result1 = slurper1.parseText(response1.getResponseBodyContent())

// Parsing API response and store it here
def password1 = result1.Password

// Getting data from API and verify it here
WS.verifyMatch(password1.toString(), '[\'Password\' must not be empty.]', false, FailureHandling.STOP_ON_FAILURE)

//*************************** Empty Username field **********************************************************************************
response2 = WS.sendRequest(findTestObject('API Requests/User Info/InValid - Empty username', [('userToken') : GlobalVariable.token]))
println(response2.getResponseBodyContent())

// Verifying API Response here
WS.verifyResponseStatusCode(response2, 400)

def slurper2 = new JsonSlurper()
def result2 = slurper2.parseText(response2.getResponseBodyContent())

// Parsing API response and store it here
def userName2 = result2.Username

// Getting data from API and verify it here
WS.verifyMatch(userName2.toString(), '[Username is missing.]', false, FailureHandling.STOP_ON_FAILURE)

//*************************** Validate correct api login **********************************************************************************
 response3 = WS.sendRequest(findTestObject('API Requests/User Info/get valid credentials', [('userToken') : GlobalVariable.token]))
 println(response3.getResponseBodyContent())
 
 // Verifying API Response here
 WS.verifyResponseStatusCode(response3, 200)
 
 def slurper3 = new JsonSlurper()
 def result3 = slurper3.parseText(response3.getResponseBodyContent())
 
 // Parsing API response and store it here
 def userName3 = result3.valid
 
 // Getting data from API and verify it here
 WS.verifyMatch(userName3.toString(), 'true', false, FailureHandling.STOP_ON_FAILURE)
