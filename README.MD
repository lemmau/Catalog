# Notes about the project

The project was organized into a project with two individual Maven modules (Core, Adapter) for purposes of loose coupling and implementation independence.
The business logic is in the Core module, while the persistence and endpoint implementation are in the Adapter module.
## Deploy
- The project must be compiled to generate the war that will be deployed on a server. It can be done from an IDE or with the command mvn clean install on the root module of the project
- The compiled file is located in the "target" directory of the Adapter module
- Deploy the war on a Tomcat server
- Execute via postman or http client the requests. The URLs must contain the path that Tomcat adds from the name of the deployed war file.

## Notes
- In-memory H2 database was used for simplicity

## Design Patterns & Principles used
- FactoryMethod variant
- SOLID Principles
- Inversion of Control
- Repository Pattern
- Adapter Pattern
- Dependency Injection
- Patterns provided by Spring (Singleton, State, etc)