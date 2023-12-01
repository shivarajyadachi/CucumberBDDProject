Feature:Category

@Sanity
Scenario: Successfull add of new category
Given User Launch Chrome browser 
When User opens URL "http://admin-demo.nopcommerce.com/login" 
And User enters Email as "admin@yourstore.com" and Password as "admin" 
And Click on Login 
And Click on Catalog And Category
And Click on AddNew Category button
And enter Catergory Name "SlamBook"
And select parent category from dropDownList "Books"
And click on upload file button
And click on save button
Then confirm successful message "The new category has been added successfully."
And close browser
 
 @Sanity
Scenario: search Catergory successfully 
Given User Launch Chrome browser 
When User opens URL "http://admin-demo.nopcommerce.com/login" 
And User enters Email as "admin@yourstore.com" and Password as "admin" 
And Click on Login 
And Click on Catalog And Category
And enter Catergory Name for search "SlamBook"
And click on search icon
Then confirm categoy is available
And close browser

@Sanity
Scenario: Delete Category Successfully
Given User Launch Chrome browser 
When User opens URL "http://admin-demo.nopcommerce.com/login" 
And User enters Email as "admin@yourstore.com" and Password as "admin" 
And Click on Login 
And Click on Catalog And Category
And enter Catergory Name for search "SlamBook"
And click on search icon
And select the category to be deleted "SlamBook"
And click on delete selected button
And confirm delete yes button
And enter Catergory Name for search "SlamBook"
And click on search icon
Then confirm category deleted
And close browser