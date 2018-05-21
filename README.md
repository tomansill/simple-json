# SimpleJSON
A simple and easy-to-use JSON for Java. This library gives you a single Java class called 'SimpleJSON' and this class is all you'll ever need. You do not need to do any type castings. You are not required to set up try and catch blocks for exception, althrough you can catch unchecked exception if you need to. You can do much more and type less with SimpleJSON. There's a caveat, SimpleJSON is less 'safe' meaning you'll more likely encounter a runtime error if you use SimpleJSON incorrectly.

If you want non-POJO (Plain Old Java Object) JSON library, doesn't want boilerplate code of using Map<String,something>, and want something simple and quick, then this library is a right choice for you.

### Features
- Non-POJO JSON object
- Very easy to use
- No dependency
- No type casting needed
- Only throws unchecked exception - no try and catch block required
- Less boilerplate code

### Usage
TODO

### Build
Building the application is pretty easy. You will need [Java 8](http://www.oracle.com/technetwork/java/javase/overview/index.html) and [Maven](https://maven.apache.org/) installed on your computer before you can build the library.

1) Clone the Github repository:
```sh
git clone https://github.com/tomansill/simple-json
cd simple-json
```
2) Build and package using Maven:
```sh
mvn package
```

Maven will take care of everything. This creates `SimpleJSON-*.*.*.jar` in target directory in the project directory. You can use the `.jar` for your project. 

License
----
GPL-3.0

Author
----
Tom Ansill
