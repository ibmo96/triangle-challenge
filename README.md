# Triangle coding challenge 

## Requirements 
Write a program that will determine the type of a triangle. 
- It should take the lengths of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene.
- We are looking for solutions that showcase problem solving skills and structural considerations that can be applied to larger and potentially more complex problem domains. 
- Pay special attention to tests, readability of code and error cases.
- The solution must be implemented in Java.

![alt tag](https://2.bp.blogspot.com/-9aI6coFWyf8/Uj721_acrfI/AAAAAAAAF60/w0l9iyaas5w/s1600/Triangle+sides.png)



## Using Gradle 

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

