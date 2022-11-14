Feature: Salesforce_LeadManagement
Scenario: TC001_Create New Lead
When User send POST request
Then Validate the POST response 


Scenario: TC002_Update Lead
When User send PATCH request
Then Validate the PATCH response 

Scenario: TC003_Get Lead detail before Delete
When User send GET request
Then Validate the GET response

Scenario: TC004_Delete Lead
When User send DELETE request
Then Validate the DELETE response  

Scenario: TC003_Get Lead detail after Delete
When User send GET request
Then Validate the GET response after delete