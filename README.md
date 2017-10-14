# HackDTU  
This is a web-based solution for the lost/misplaced luggage problem encountered by every airport in the world.  
Our app contains three components- a server that maintains the databse, an android app and a web-app, both for the security personnel at the airport.  
When a person is issued his boarding pass, a QR code is attached to the boarding pass as well as the luggage.  
At the time of arrival, the passenger is required to get his baggage and his boarding pass scanned.  
If the QR codes match, he is allowed to pass. Their entry in the database is flagged.    
If someone leaves without getting their luggage scanned, they remain unflagged in the database and in case another passenger reports a missing luggage, a suspect list can be prepared based on the unflagged people in the databse.  
The same protocol for luggage tracking can be extended to keep track of unclaimed luggage.  
This system can also be used in other means of transport such as Sea Travel.
