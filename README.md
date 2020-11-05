# Yelp-Exercise
Build to test some functionalities of Yelp and report the results in this repository.
--------------------------------------------------------------------------------------
# Scenario tested:

1) Go to Yelp page (https://www.yelp.com/) and test searching combinations 
2) Search made: Restaurants Pizza.
3) Report: No. Results without any filter.
4) Search with some random filtering parameters (parametrized through TestNG framework). Parameters used to filter results: {'Feautures','Neighborhood'}
    
    Combinations tested:
      1- {"GoodForKids","CA:San_Francisco::Outer_Sunset"}
      2- {"RestaurantsGoodForGroups","CA:San_Francisco::Inner_Richmond"}
      3- {"GoodForMeal.dinner","CA:San_Francisco::Stonestown"}
      
5) For each combination, No. of Results and No. of Stars were reported.
6) For each combination, information (website page, telephone, address) and reviews were extracted from the first result of parametrized search.
7) All reports are available under the file 'sample-report.html' within this repository.


# Exercise criteria met:

1) Test input was parametrized.
2) Tests were iterated 3 times each and were independent.
3) Page Object Model was implemented.
4) XPath, CSS, LinkText locators were used and are easily changeable from one place
5) Report Sample is provided together with this repository.
 
