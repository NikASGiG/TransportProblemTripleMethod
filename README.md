# TransportProblemTripleMethod
Transport Problem Triple Method is a GUI Java application for solving linear programming problems.This project is designed to solve the transportation problem by determining the initial solution using three methods:
1. North-West Corner Method
2. Least Cost Method
3. Vogel's Approximation Method

The number of variables, coefficients of the objective function, and constraints are input by the user. The output is displayed on the screen with the option to export to an XLS file.

# Features
User-Friendly Interface: An intuitive and easy-to-use interface for inputting problem data and viewing results.
Multiple Solving Methods: The application supports three different methods for solving the transportation problem.
Customizable Input: Users can customize the number of variables, coefficients of the objective function, and constraints.
Export Results: Users can export the results to an XLS file for further analysis or documentation.

# Installation
To use Transport Problem Triple Method, you will need to have Java and Maven installed on your system. Once you have those installed, you can clone the repository and build the project with Maven.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

git clone https://github.com/NikASGiG/TransportProblemTripleMethod.git

cd TransportProblemTripleMethod

mvn package

# Usage
To run the Transport Problem Triple Method application, navigate to the target directory and run the .jar file.

cd target

java -jar TransportProblemTripleMethod-1.0-lab2.jar

Once the application is running, you can enter your linear programming problem into the input fields and click the buttons to solve it using the three methods  algorithm. Also you can do report in "report***.xls" files. View the results on the screen or export to an XLS files.

# License
This project is licensed under the Apache License 2.0
