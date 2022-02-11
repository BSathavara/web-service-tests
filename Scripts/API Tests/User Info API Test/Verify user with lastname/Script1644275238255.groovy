import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

response = WS.sendRequest(findTestObject('API Requests/User Info/get user with lastname', [('userToken') : GlobalVariable.token]))

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
WS.verifyEqual(id, '6859ac20-c592-493e-86dc-c34ce9c6cb31')
WS.verifyEqual(username, 'KETZNERB')
WS.verifyEqual(displayName, 'Brad Ketzner')
WS.verifyEqual(fname, 'Brad')
WS.verifyEqual(lname, 'Ketzner')
WS.verifyEqual(type, 'Workforce')
WS.verifyEqual(pageNumber, '1')
WS.verifyEqual(pageSize, '50')
WS.verifyEqual(totalItems, '1')
WS.verifyEqual(pageCount, '1')