# p1_spring_angular

To setup the environment follow the below steps:

<ul>
    <li><b>Step 1</b> - CD to backend/docker directoty</li>
    <li><b>Setp 2</b> - Execute: docker-compose --env-file ../env/.env up -d </li>
    <li><b>Step 3</b> - After docker is setup then run maven on root directory of backend (mvn spring-boot:run)</li>
    <li><b>Step 4</b> - Run client application (npm run start)</li>
</ul>


Goals
    1. Create a connection between DB and Spring Application
    2. Use this connection and define the right architecture of your spring project. By doing that, results from these queries needs to be served in a RESTful way.
    3. Consume the results coming from the endpoints and visualize them in the Angular App. 
    
Tasks
Following the above goals:
Build a home Page in Angular with a redirection menu that holds one menu item for every task that 
follows below
    1. Create a new screen to:
        a. Fetch the name, area, country_code2 of all countries and display them in ordered list.
        b. When clicking on one of the countries, it should redirect the user to another page that displays all spoken languages in this country.
    2. Create a new screen with a table in Angular with the following columns:
        a. name,
        b. country_code3,
        c. year,
        d. population and
        e. gdp
for all the countries and their country stats where the record shown for each country is the maximum 
gdp per population ratio along the years.
    3. Create a new screen that shows a table with columns name from continents table, name from regions table, name from country table, year, population and gdp from country stats table. On top of the table is a search filter area containing, a dropdown selection with all regions as well as date From and date to filters for the year of country stats. User can filter out the results of the table by using these filters.
    
Optional: Pagination of results will have a positive impact.
