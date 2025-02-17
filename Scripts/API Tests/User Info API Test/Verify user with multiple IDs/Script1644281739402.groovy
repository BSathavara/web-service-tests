import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable

// Calling get access token API to collect new token
WebUI.callTestCase(findTestCase('API Tests/Verify Token/API access token'), [:], FailureHandling.STOP_ON_FAILURE)

response = WS.sendRequest(findTestObject('API Requests/User Info/get user with IDs', [('userToken') : GlobalVariable.token]))

println(response.getResponseBodyContent())

// Verifying API Response here
WS.verifyResponseStatusCode(response, 200)

def slurper = new JsonSlurper()
def result = slurper.parseText(response.getResponseBodyContent())

// Parsing API response and store it here
def id = result.id[0]
def username = result.username[0]
def displayName = result.displayName[0]
def fname = result.firstName[0]
def lname = result.lastName[0]
def type = result.type[0]

// Getting data from API and verify it here
WS.verifyEqual(id, 'b7483db2-43db-4f10-9e87-8a0ab64e362d')
WS.verifyEqual(username, 'bbenick-adm')
WS.verifyEqual(displayName, 'Brad Benick')
WS.verifyEqual(fname, 'Brad')
WS.verifyEqual(lname, 'Benick')
WS.verifyEqual(type, 'Workforce')

// Parsing API response and store it here
def id1 = result.id[1]
def username1 = result.username[1]
def displayName1 = result.displayName[1]
def fname1 = result.firstName[1]
def lname1 = result.lastName[1]
def type1 = result.type[1]

// Getting data from API and verify it here
WS.verifyEqual(id1, 'a5d72f28-13e4-48b8-a699-8ef6ce0783a3')
WS.verifyEqual(username1, 'BENICKB')
WS.verifyEqual(displayName1, 'Brad Benick')
WS.verifyEqual(fname1, 'Brad')
WS.verifyEqual(lname1, 'Benick')
WS.verifyEqual(type1, 'Workforce')