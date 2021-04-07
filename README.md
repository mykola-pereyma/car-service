# heycar - backend challenge

## Task:
Create a platform that can receive the listings from the dealers through different providers, and make them available in the platform.

## Out of scope
* Authentication
* Authorization
* Data removal
* High-load optimizations
* Performance monitoring

## High-level architecture
* Containerized http-based microservice serving and receiving listings data.
* In-memory database H2 with default transactions configurations will be used for the demo purposes.
* Solution wil have basic server side validation for requests correctness.

## Technology stack
* Docker
* Java 11
* SpringBoot
* H2 database
* Opencsv
* Junit

## Build prerequisites
* Java 11
* Maven
* git
* Docker

## Build and run steps
1. Clone the repository: git clone https://github.com/mykola-pereyma/car-service.git
2. Build a package: mvn package
3. Build a Docker image: docker build -t demo/car-service .
4. Run a docker container: docker run -p 8080:8080 demo/car-service

## Test car-service API
Default database contains three listings for two dealers.
* Get all listings: curl --request GET "http://localhost:8080/search"
* Query specific listings: curl --request GET "http://localhost:8080/search?make=VW&model=Golf&color=Blue&year=2017"
* Add/Update 3 listings for a dealer D2:
  curl --header "Content-Type: application/json" \
  --request POST \
  --data '[{"code":"C3","make":"Audi","model":"Golf","color":"White","year":2015,"kw":100,"price":12500},{"code":"C4","make":"VW","model":"Passat","color":"Red","year":2018,"kw":150,"price":16500},{"code":"C5","make":"VW","model":"Golf","color":"Blue","year":2017,"kw":120,"price":14500}]' \
  http://localhost:8080/vehicle_listings/D2
* Add/Update listings for the dealer D1 with csv(considering csv file is located in specified path):
  curl -X POST -H 'Content-Type: application/octet-stream' --data-binary @listings.csv http://localhost:8080/upload_csv/D1

## Potential improvements
* Add more request validation
* Add monitoring 
* Use production grade database
* Make search pagable and more efficient
* Agree csv format and use bean mapping to handle cvs data
* Add testing for the repository, more tests to the controller
* If necessary add API description or swagger, or make HAL REST API
