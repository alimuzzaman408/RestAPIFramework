Feature: Validate Place API

@AddPlace
Scenario Outline: Place has added successfully by using Add Place API
Given Add place payload "<name>" "<address>"
When User call "AddPlaceAPI"  with "post" Request
Then Response of the API call status code 200
And "status" in the response body is "OK"
And "scope" in the response body is "APP"
And verify place_ID created map to "<name>" using "GetPlaceAPI"


Examples: 
    
    |name|address|
    |Einstein|Newyork,USA|
    
  @DeletePlace  
 Scenario: Verify If Delete place Functionality is working properly
 
 Given deletePLace payload
 When User call "deletePlaceAPI"  with "post" Request
 Then Response of the API call status code 200
 And "status" in the response body is "OK" 
 

 
    
 