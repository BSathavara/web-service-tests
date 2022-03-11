import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Page Header/companyLogo'), 10)

WebUI.setText(findTestObject('Object Repository/UI/Clearance/Login Page/tbUserID'), GlobalVariable.webUserName)

WebUI.setEncryptedText(findTestObject('Object Repository/UI/Clearance/Login Page/tbPassword'), GlobalVariable.webPassword)

WebUI.click(findTestObject('Object Repository/UI/Clearance/Login Page/cbRememberPwd'))

WebUI.click(findTestObject('Object Repository/UI/Clearance/Login Page/btnSubmit'))

WebUI.verifyElementPresent(findTestObject('Object Repository/UI/Clearance/Insured Search/Page_Insured Search/txtInsuredSearch'), 
    10)

WebUI.closeBrowser()