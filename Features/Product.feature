Feature: Product 

@Sanity
Scenario: Add new Product
  Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com" and Password as "admin" 
	And Click on Login 
 	And Click on Catalog And Product 
 	And Click on Add new Product button
	And Enter Product Name "Gramaxone" 
	And Enter Product Description
	And Click on Save button
	Then user can view confirmation message "The new product has been added successfully"
	And close browser 
	
@Sanity
Scenario: Delete Product
  Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com" and Password as "admin" 
	And Click on Login 
 	And Click on Catalog And Product 
	And Click on Search icon
	And Enter Search Product Name "Gramaxone" 
	And Click on Search button
	Then user should search Product name is search table
	And Click on Select CheckBox
	And Click on Delete button
	And Click on Confirm Delete
	Then Delete Confirm message "No data available in table"
	And close browser 
	