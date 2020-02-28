#CVurl-RX

**CVurl-RX** is a reactive wrapper for CVurl.

## Requirements
**CVurl-RX** is written in java 11 and can be used with any jdk11 and higher.

## Dependencies
CVurl-RX includes following dependencies:
```xml
        <!--(1)-->
       <dependency>
           <groupId>com.github.corese4rch</groupId>
           <artifactId>cvurl-io</artifactId>
           <version>${cvurl-io.version}</version>
       </dependency>
        <!--(2)-->
       <dependency>
           <groupId>io.reactivex.rxjava3</groupId>
           <artifactId>rxjava</artifactId>
           <version>${rxjava.version}</version>
        </dependency>
```

## How to use CVurl-RX
To use CVurl-RX you just need to wrap you Request into RxRequest using static 
factory method RxRequest.rx(request)
```java
    //create new instance of CVurl
    CVurl cVurl = new CVurl();

    //build your request
    Request request = cVurl.get("www.testurl.com").queryParam("param1", "value1").create();

    //now you can wrap you request in RxRequest on which you can call
    //different request sending methods that return RxJava Single
    RxRequest.rx(request).asString()
            .subscribe(stringResponse -> System.out.println("SUCCESS"));

    //or using static import and building request on the fly
    rx(cVurl.get("www.testurl.com")
            .queryParam("param1", "value1"))
            .asString()
            .subscribe(stringResponse -> System.out.println("SUCCESS"));
```