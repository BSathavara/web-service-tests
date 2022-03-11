import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

// Calling get access token API to collect new token
WebUI.callTestCase(findTestCase('API Tests/Verify Token/API access token'), [:], FailureHandling.STOP_ON_FAILURE)

file = 'C:\\Users\\bsathavara\\Katalon Studio\\userInfoData\\userdata.xlsx'

//file = "Data Files\\userdata.xlsx";
allData = findTestData('Data Files/UserInfo Ids').getAllData()
lastRow = allData.size()

for (int i = 0; i <= lastRow; i++) {
    // Find expected result from table
    def getUserNameFromTable = findTestData('Data Files/UserInfo Ids').getValue(1, i + 1)
    def expectedDisplayName = findTestData('Data Files/UserInfo Ids').getValue(2, i + 1)

    response = WS.sendRequest(findTestObject('API Requests/User Info/get user with IDs From Test Data', [('token') : GlobalVariable.token
                , ('url') : GlobalVariable.TestEnv, ('id') : getUserNameFromTable]))

    String stringRes = response.getResponseBodyContent()
    JsonSlurper slurper = new JsonSlurper()
    Map parsedJson = slurper.parseText(stringRes)
	print(parsedJson)
	String res = parsedJson.getAt("displayName").toString()
	String rem = res.replaceAll("\\[", "").trim()
	String idValue = rem.replaceAll("\\]", "").trim()
	print(idValue)

    if (idValue != null) {
        result = WS.verifyEqual(idValue, expectedDisplayName, FailureHandling.CONTINUE_ON_FAILURE)

        if (result == true) {
            CustomKeywords.'excel.WriteExcel.demoKey'(file, expectedDisplayName, 'Expected Result', i)
            CustomKeywords.'excel.WriteExcel.demoKey'(file, idValue, 'Actual Result', i)
            CustomKeywords.'excel.WriteExcel.demoKey'(file, 'Pass', 'Status', i)
        } else {
            CustomKeywords.'excel.WriteExcel.demoKey'(file, expectedDisplayName, 'Expected Result', i)
            CustomKeywords.'excel.WriteExcel.demoKey'(file, idValue, 'Actual Result', i)
            CustomKeywords.'excel.WriteExcel.demoKey'(file, 'Fail', 'Status', i)
        }
    } else {
        CustomKeywords.'excel.WriteExcel.demoKey'(file, expectedDisplayName, 'Expected Result', i)
        CustomKeywords.'excel.WriteExcel.demoKey'(file, '', 'Actual Result', i)
        CustomKeywords.'excel.WriteExcel.demoKey'(file, 'Fail', 'Status', i)
    }
}