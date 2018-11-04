# XtendSearch

Extensible Robust Enterprise Search Server

## Getting Started

1. You need to install JDK 8 to build and run this project.
2. Docker is used for packaging the application into a distributable image. (optional) 

While it is completely possible to work on this project without any sophisticated
pre-requisites to work with the code, it is recommended to use an IDE supporting
Gradle (such as Eclipse or IntelliJ IDEA). It will make your life easier.

* [Instructions for IntelliJ IDEA](https://spring.io/guides/gs/intellij-idea/)
* [Instructions for Eclipse](http://www.vogella.com/tutorials/EclipseGradle/article.html#import-an-existing-gradle-project)

You can also use other code editors like Visual Studio Code or Atom, albeit with
a little more manual effort.

### Running the project

Copy `application.properties.dist` to `application.properties` and make necessary changes.

Make sure you have Elastic Search running on port 9200 & 9300 on `localhost`.

The easiest way is to get docker and launch elasticsearch with:

```
docker run -p 9200:9200 -p 9300:9300 elasticsearch:6.4.2
```

From the command line, run:
```
./gradlew bootRun
```

Else, use your IDE to start the project. The server will be available at
http://localhost:8080/

