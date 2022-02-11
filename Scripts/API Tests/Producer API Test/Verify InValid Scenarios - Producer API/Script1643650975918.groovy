import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

// Calling get access token API to collect new token
WebUI.callTestCase(findTestCase('API Tests/Verify Token/API access token'), [:], FailureHandling.STOP_ON_FAILURE)

// Verify inValid http method - Length required
res = WS.sendRequest(findTestObject('API Requests/Produces API/Producer/Invalid producer method', [('token') : GlobalVariable.token]))
WS.verifyResponseStatusCode(res, 411)

// Verify inValid API URI - page not found
res = WS.sendRequest(findTestObject('API Requests/Produces API/Producer/Invalid producer URI', [('token') : GlobalVariable.token]))
WS.verifyResponseStatusCode(res, 404)

// Verify inValid API token - unauthorized
res = WS.sendRequest(findTestObject('API Requests/Produces API/Producer/Invalid producer API token', [('token') : GlobalVariable.token]))
WS.verifyResponseStatusCode(res, 401)

// Verify inValid API token - Bad request
res = WS.sendRequest(findTestObject('API Requests/Produces API/Producer/Invalid producer api bad request', [('token') : GlobalVariable.token]))
WS.verifyResponseStatusCode(res, 400)