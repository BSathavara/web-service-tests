<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Invalid producer API token</name>
   <tag></tag>
   <elementGuidId>9e5beb99-59ff-4be6-be50-b38f45aee99a</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IkVEMTFCNzg3RUNENkMwN0M1NUY3RDgzRDY1MDREOEE1QkE2NUZGOTRSUzI1NiIsInR5cCI6ImF0K2p3dCIsIng1dCI6IjdSRzNoLXpXd0h4Vjk5ZzlaUVRZcGJwbF81USJ9.eyJuYmYiOjE2NDM2NDc2MzgsImV4cCI6MTY0MzY0OTQzOCwiaXNzIjoiaHR0cHM6Ly90ZXN0My5nYW1jdXN0b20uY29tL2lkZW50aXR5YXBpIiwiYXVkIjpbIjUwMyIsIjUxOSIsIjUxMCIsIjUxNiJdLCJjbGllbnRfaWQiOiJzZXJ2aWNlVGVzdGVyIiwiaWF0IjoxNjQzNjQ3NjM4LCJzY29wZSI6WyJwcm9kdWNlcmluZm9hcGktZnVsbCIsInVzZXJpbmZvYXBpLWZ1bGwiXX0.c2YZ9WVw3b_JdjHj5_FYR-EYTn-bDbz3mGJnT-z1Wx5Z3Xyj0ZG7DbHxzVKP3EF5TB2AFzKf-MoOQNgYj0HpOTJjCt1T2mEwCHD6KneEc_CqJICvUq6lcaorjslKjD5maLr1_pMPkEAG2Zqe5BuzfJiF2LxquGOL8gog7Lzz5m-VQkg-JqtrmE3nlTOoJ3ddYZXIcIBqcTSPxaPSgqfS3NNTN-HiTcXxUsuk_JJxBQjYD0BSP76YA-xv9Kw3c0pESGf5MPkTifdmNbDO81uiq-xMnzuvXr5_MX4SpoYlavOh5VkygiFjcif8cfmpKI-X2HoZcn0M3KffXm1V3XmjNb</value>
   </httpHeaderProperties>
   <katalonVersion>8.2.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://tapi4.gamcustom.net/producerapi/v1/producers</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
