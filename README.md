# Triangle coding challenge 

## Requirements 
Write a program that will determine the type of a triangle. 
- It should take the lengths of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene.
- We are looking for solutions that showcase problem solving skills and structural considerations that can be applied to larger and potentially more complex problem domains. 
- Pay special attention to tests, readability of code and error cases.
- The solution must be implemented in Java.

![alt tag](https://2.bp.blogspot.com/-9aI6coFWyf8/Uj721_acrfI/AAAAAAAAF60/w0l9iyaas5w/s1600/Triangle+sides.png)


# Solution

## Shape abstract class
The decision to create a Shape abstract class was to provide some functionality for extending the API with more shapes in the future. For now, the only method i would want in all shapes the **`getArea()`**, which is also an abstract class, leavning the implementation for the concrete class. 

## Static factory method vs public constructor 

1. Factory methods for the construction of new Triangles provide a better naming convention. They will describe exactly what is needed for the construction of a Triangle, so for a future implementation, one cound create a factory construction method **`createWithAngles(...)`** instead of **`createWithLengths(...)`**.

2. Another advantage is that for multithreaded systems, the static factory method can be synchronized, thereby providing thread-safety to the construction of new Triangle objects. 


## Immutable Triangle instances 
All fields are defined as final, making Triangle instances immutable. This implementation extends what was discussed under the Static factory method section, providing a better foundation in case of future multi-threading. 

## Enum for readability 
The type of the Triangle (equilateral, isosceles or scalene) is implemented as an Enum. This increases the readability throughout the API. 

## Comparable interface 
The Triangle class implements Comparable. This was done to facilitate the need of sorting and ordering in future development. Here, Triangles are sorted according the areas, but this can be changed. So for future use, if one had a list **`List<Triangle> triangles`** it would be enough to sort using **`Collections.sort(triangles)`**. 


# Using Gradle 

### Windows 
Gradle can be run using either the <tt> gradle </tt>  or <tt> gradlew </tt> command. 

### Linux and MacOS 
Gradle can be run using either the <tt> ./gradle </tt>  or <tt> ./gradlew </tt> command. 


## Javadoc 

Gradle has built in support for compiling javadoc comments to html. If you run <br/>
<tt> gradlew javadoc </tt> <br/>
the html will be written to <tt> build/docs/javadoc/index.html </tt>. Use this to verify that your
documentation of your public API is suffcient.

## Unit Testing 

Gradle has built in support for jUnit. If you run <br/>
<tt> gradlew test </tt> <br/>
all the tests in the <tt> src/test </tt> subtree will be run. To measure the coverage of your test suite,
you can use jacoco by running: <br/>
<tt> gradlew test jacocoTestReport </tt> <br/>
, which generates a coverage report in <tt> build/reports/jacoco/test/html/index.html </tt>

### Mutation Testing 

The PI-Test plugin for Gradle was activated for this challenge, which performs mutation testing and calculates a mutation coverage of a Gradle-based project. 
PItest can be run using <br/>
<tt> gradlew pitest </tt> <br/>

