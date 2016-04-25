# play-simple-webdav

This repository contains a simple read-only WebDAV implementation to be used in a Java 8 [Play](https://www.playframework.com/) application. 

It was originally developed in the context of [geo-publisher](https://github.com/IDgis/geo-publisher) and was eventually
also used in [geoportaal](https://github.com/IDgis/geoportaal).

# usage

## gradle

The WebDAV functionality can be incorporated into your application by addding a single dependency:

```gradle
repositories {
  mavenCentral()
  maven {
		name "typesafe-maven-release"
		url "https://repo.typesafe.com/typesafe/maven-releases"
	}
	ivy {
		name "typesafe-ivy-release"
		url "https://repo.typesafe.com/typesafe/ivy-releases"
		layout "ivy"
	}
	maven {
		name "idgis-public"
		url "http://nexus.idgis.eu/content/groups/public/"
	}
}

dependencies {
  play 'nl.idgis.dav:play-simple-webdav_2.11:1.0.0'
}
```

## router

The WebDAV functionality is implemented as a router with a few abstract methods to be implemented 
by the application developer:

```java
public class DemoWebDAV extends extends SimpleWebDAV {

  public DemoWebDAV() {
    this("/");
  }
  
  public DemoWebDAV(String prefix) {
    super(prefix);
  }
  
  @Override
  public DemoWebDAV withPrefix(String prefix) {
    return new DemoWebDAV(prefix);
  }
  
  /***
   * Called to fetch a list of resources in the WebDAV folder. 
   */
  @Override
  public Stream<ResourceDescription> descriptions() {
    // ...
  }
  /***
   * Called to fetch the properties of a resource. 
   */
  @Override
  public Optional<ResourceProperties> properties(String name) {
    // ...
  }
  
  /*** 
   * Called to fetch the content of a resource. 
   */
  @Override
  public Optional<Resource> resource(String name) {
	  // ...
  }
}
```

## route

Incorporate your WebDAV router in a static router by adding a line to your router configuration:

```
GET   /foo    controllers.Foo.fetch
->    /demo   DemoWebDAV
POST  /bar    controllers.Bar.process
```
