import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

// Open Browser
WebUI.openBrowser('')

// Navigate to Clearance URL
WebUI.navigateToUrl(GlobalVariable.url)

// Verify Clearance Headers, company Logo
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Page Header/companyLogo'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Page Header/txtClearance'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Page Header/btnHome'), 2)

// Verify Login Page and fields appears
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Login Page/txtLogin'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Login Page/tbUserID'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Login Page/tbPassword'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Login Page/cbRememberPwd'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Login Page/btnSubmit'), 2)

// Verify with in-valid credentials
WebUI.click(findTestObject('Object Repository/UI/Clearance/Login Page/btnSubmit'))
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Login Page/wrong Username'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Login Page/wrong Password'), 2)

// Verify with in-valid password
WebUI.setText(findTestObject('Object Repository/UI/Clearance/Login Page/tbUserID'), 'gaci123')
WebUI.click(findTestObject('Object Repository/UI/Clearance/Login Page/btnSubmit'))
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Login Page/wrong Password'), 2)
WebUI.delay(1)

// Verify with in-valid username and authentication failed
WebUI.setText(findTestObject('Object Repository/UI/Clearance/Login Page/tbUserID'), '')
WebUI.setEncryptedText(findTestObject('Object Repository/UI/Clearance/Login Page/tbPassword'), GlobalVariable.webPassword)
WebUI.click(findTestObject('Object Repository/UI/Clearance/Login Page/btnSubmit'))
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Login Page/wrong Password'), 2)
WebUI.delay(1)

//Verify Authentication Failed
WebUI.setText(findTestObject('Object Repository/UI/Clearance/Login Page/tbUserID'), 'Gaci123')
WebUI.setText(findTestObject('Object Repository/UI/Clearance/Login Page/tbPassword'), 'Gaci123')
WebUI.click(findTestObject('Object Repository/UI/Clearance/Login Page/btnSubmit'))
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Login Page/authentication Failed'), 2)
WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/UI/Clearance/Login Page/tbUserID'), GlobalVariable.webUserName)
WebUI.setEncryptedText(findTestObject('Object Repository/UI/Clearance/Login Page/tbPassword'), GlobalVariable.webPassword)
WebUI.click(findTestObject('Object Repository/UI/Clearance/Login Page/cbRememberPwd'))
WebUI.click(findTestObject('Object Repository/UI/Clearance/Login Page/btnSubmit'))
WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Insured Search/Page_Insured Search/txtInsuredSearch'), 
    10)

WebUI.closeBrowser()