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

response = WS.sendRequest(findTestObject('API Requests/Produces API/Producer/Get Producer list', [('token') : GlobalVariable.token]))

// Verifying API Response here
WS.verifyResponseStatusCode(response, 200)

def slurper = new JsonSlurper()
def result = slurper.parseText(response.getResponseBodyContent())

int noOfProducer = result.paging.totalItems

for (int i = 1; i <= noOfProducer; i++) {
	
    // Parsing API response and store it here	
    def itemCode = result.items[i].code
    def itemName = result.items[i].name
    def itemHeadCode = result.items[i].headquarterCode
    def itemBranchNumber = result.items[i].branchNumber
    def itemCity = result.items[i].city
    def itemState = result.items[i].state
	
	// Find expected result from table
	def expectedItemCode = findTestData('Data Files/Producer List').getValue(1, i + 1)
	def expectedItemName = findTestData('Data Files/Producer List').getValue(2, i + 1)
	def expectedItemHeadCode = findTestData('Data Files/Producer List').getValue(3, i + 1)
	def expectedItemBranchNumber = findTestData('Data Files/Producer List').getValue(4, i + 1)
	def expectedItemCity = findTestData('Data Files/Producer List').getValue(5, i + 1)
	def expectedItemState = findTestData('Data Files/Producer List').getValue(6, i + 1)

    println(itemCode)

    // Getting data from API and verify it here
    WS.verifyEqual(itemCode, expectedItemCode)
    WS.verifyEqual(itemName, expectedItemName)
    WS.verifyEqual(itemHeadCode, expectedItemHeadCode) 
	WS.verifyEqual(itemBranchNumber, expectedItemBranchNumber)	
    WS.verifyEqual(itemCity, expectedItemCity)	
    WS.verifyEqual(itemState, expectedItemState)
}

