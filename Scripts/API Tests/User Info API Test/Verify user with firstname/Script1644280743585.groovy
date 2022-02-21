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

response = WS.sendRequest(findTestObject('API Requests/User Info/get user with fname', [('userToken') : GlobalVariable.token]))

println(response.getResponseBodyContent())

// Verifying API Response here
WS.verifyResponseStatusCode(response, 200)

def slurper = new JsonSlurper()
def result = slurper.parseText(response.getResponseBodyContent())

// Parsing API response and store it here
def id = result.items[0].id
def username = result.items[0].username
def displayName = result.items[0].displayName
def fname = result.items[0].firstName
def lname = result.items[0].lastName
def type = result.items[0].type
def pageNumber = result.paging.pageNumber
def pageSize = result.paging.pageSize
def totalItems = result.paging.totalItems
def pageCount = result.paging.pageCount

// Getting data from API and verify it here
WS.verifyEqual(id, 'b7483db2-43db-4f10-9e87-8a0ab64e362d')
WS.verifyEqual(username, 'bbenick-adm')
WS.verifyEqual(displayName, 'Brad Benick')
WS.verifyEqual(fname, 'Brad')
WS.verifyEqual(lname, 'Benick')
WS.verifyEqual(type, 'Workforce')
WS.verifyEqual(pageNumber, '1')
WS.verifyEqual(pageSize, '50')
WS.verifyEqual(pageCount, '1')