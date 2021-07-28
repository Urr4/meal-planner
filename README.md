# Meal-Planner Backend
This application is designed to be a simple playground for a Spring Boot Microservice running on Kubernetes.

## Deployments
All related deployment descriptors can be found in <a>https://github.com/Urr4/deployments.

## Get it running locally
To start locally, use the `dev`-Profile.
In the dev-Profile the service expects an LDAP-Server and a PostgreSQL Database to be reachable locally.
Either you forward those from your cluster using
* `kubectl port-forward -n infrastructure service/postgres 5432:5432`
* `kubectl port-forward -n infrastructure service/openldap 389:389`

or you have an instance of each running locally in docker.

### Port-forwarding
When using port-forwarding to point the Service to the Kubernetes infrastructure, you need to pass the following env-variables:
* `SPRING_DATASOURCE_USERNAME` found in secret-value `dev-db-secret[username]` in the same namespace as the app.
* `SPRING_DATASOURCE_PASSWORD` found in secret-value `dev-db-secret[password]` in the same namespace as the app.
* `SPRING_LDAP_PASSWORD` found in secret-value `dev-ldap-secret[password]` in the same namespace as the app.

### Local infrastructure
If you want to run them locally, you can use the `dev`-Profile, but should read the following:

* LDAP:
  * The LDAP-Server should hold the Domain `dc=urr4,dc=com`
  * The Service expects the LDAP to be accessible using the `admin` user.
  * The Service expects an env-variable `SPRING_LDAP_PASSWORD` holding the password for the `admin` user
  * The Service wants to access the LDAP-Server using port 389 and the non-secure `ldap` protocol.
    
* PostgreSQL
  * The application expects env-variables `SPRING_DATASOURCE_USERNAME` and `SPRING_DATASOURCE_PASSWORD` holding the username and password for the PostgreSQL-Server 
  * The Service will try to access using port 5432
  * The Service expects a database named `home`.
  * In dev-Profile, the Service will `Update` DB-schemas
  
## Release
If you want to release the application, edit the `distributeDockerImage.sh`.
This will build the application and docker-image for arm32v7 and push the docker-image to the `08021986` repository.
    