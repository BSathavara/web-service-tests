import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// Calling get access token API to collect new token
WebUI.callTestCase(findTestCase('API Tests/Verify Token/API access token'), [:], FailureHandling.STOP_ON_FAILURE)

// Verifying 400 Page not found response
response = WS.sendRequest(findTestObject('API Requests/User Info/InValid - 400 Bad Request', [('token') : GlobalVariable.token]))
WS.verifyResponseStatusCode(response, 400)

// Verifying 404 Page not found response
response = WS.sendRequest(findTestObject('API Requests/User Info/InValid - URI 404 Not Found', [('token') : GlobalVariable.token]))
WS.verifyResponseStatusCode(response, 404)

// Verifying wrong Authentication 401 Unauthorized response
response = WS.sendRequest(findTestObject('API Requests/User Info/InValid - wrong Authentication 401 Unauthorized', [('token') : GlobalVariable.token]))
WS.verifyResponseStatusCode(response, 401)

// Verifying Wrong firstName response
response = WS.sendRequest(findTestObject('API Requests/User Info/InValid - Wrong firstName 200 Ok No items found', [('token') : GlobalVariable.token]))
WS.verifyResponseStatusCode(response, 200)

// Verifying Wrong firstName response
response = WS.sendRequest(findTestObject('API Requests/User Info/InValid - wrong Method 411 Length required', [('token') : GlobalVariable.token]))
WS.verifyResponseStatusCode(response, 411)