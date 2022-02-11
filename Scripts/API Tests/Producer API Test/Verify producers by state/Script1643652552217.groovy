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

response = WS.sendRequest(findTestObject('API Requests/Produces API/Producer/Get Producer by state', [('token') : GlobalVariable.token]))

// Verifying API Response here
WS.verifyResponseStatusCode(response, 200)

def slurper = new JsonSlurper()
def result = slurper.parseText(response.getResponseBodyContent())

// Parsing API response and store it here
def itemCode = result.items[0].code
def itemName = result.items[0].name
def itemHeadCode = result.items[0].headquarterCode
def itemBranchNumber = result.items[0].branchNumber
def itemCity = result.items[0].city
def itemState = result.items[0].state

// Getting data from API and verify it here
WS.verifyEqual(itemCode, '34400')
WS.verifyEqual(itemName, 'Executive Perils, Inc. - Misc E&O')
WS.verifyEqual(itemHeadCode, '0296  ')
WS.verifyEqual(itemBranchNumber, '00')
WS.verifyEqual(itemCity, 'Los Angeles')
WS.verifyEqual(itemState, 'CA')

// Parsing API response and store it here
def itemCode1 = result.items[1].code
def itemName1 = result.items[1].name
def itemHeadCode1 = result.items[1].headquarterCode
def itemBranchNumber1 = result.items[1].branchNumber
def itemCity1 = result.items[1].city
def itemState1 = result.items[1].state

// Getting data from API and verify it here
WS.verifyEqual(itemCode1, '34401')
WS.verifyEqual(itemName1, 'Partners Specialty Group (Misc. E & O)')
WS.verifyEqual(itemHeadCode1, '0295  ')
WS.verifyEqual(itemBranchNumber1, '00')
WS.verifyEqual(itemCity1, 'Santa Monica')
WS.verifyEqual(itemState1, 'CA')

// Parsing API response and store it here
def itemCode2 = result.items[2].code
def itemName2 = result.items[2].name
def itemHeadCode2 = result.items[2].headquarterCode
def itemBranchNumber2 = result.items[2].branchNumber
def itemCity2 = result.items[2].city
def itemState2 = result.items[2].state

// Getting data from API and verify it here
WS.verifyEqual(itemCode2, '34404')
WS.verifyEqual(itemName2, 'M.J. Hall & Company, Inc. (Napa)')
WS.verifyEqual(itemHeadCode2, '0297  ')
WS.verifyEqual(itemBranchNumber2, '00')
WS.verifyEqual(itemCity2, 'Napa')
WS.verifyEqual(itemState2, 'CA')