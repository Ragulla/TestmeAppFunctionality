

Feature: TestMe Functionality

 #@register
  #Scenario: Registration 
  #  Given User must be in registration page
   # When Enter user credentials "ReekkHGFdfHJGDSFSj8yuhasri","Rekha","Sri","rekha123","rekha123","rekhasri@gmail.com","8778470814","08/10/1997","1/1,T-Nagar,Chennai", "yellow"
    #Then  User registered successsfully

 @login
 Scenario Outline: Login
    Given User must be in Login page
    When  Enter "<username>" and "<password>" and click login
    Then  User logged in successfully
    
    Examples:
     |username||password|
     |lalitha||password123|
     
 #@search
 #Scenario: Search
  #  Given User must be logged in
   # When  Search for the product "headphone" 
    #Then  The product entered is searched
    
 @AddToCart  
 Scenario: User moves to cart with outing the item
    Given user registered into TestMeApp
    When user search a particular product like headphones
    Then TestMeApp doesnt display cart icon
 
    