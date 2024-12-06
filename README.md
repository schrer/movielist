# movielist - inject framework showcase

This is movielist, a web application that provides some endpoints for keeping track of movies.
It's not really usable, it is just a showcase and testbed for my [dependency injection library](https://github.com/schrer/inject)

It uses Javalin to serve HTTP endpoints and my injection library to instantiate handlers, a repository and some configuration values.

## Build requirements
To be able to build and run it you need to clone the injection library and push it into your local maven repository, as it is not published anywhere as a JAR.

```bash
git clone https://github.com/schrer/inject.git
cd inject
./gradlew build publishToMavenLocal
```