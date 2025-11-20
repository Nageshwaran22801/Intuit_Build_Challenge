# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.2/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.2/gradle-plugin/packaging-oci-image.html)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)


# Producer–Consumer & Sales Analysis – Spring Boot Module

This Spring Boot module contains two independent assignments:

# Assignment 1: Producer–Consumer System

This assignment demonstrates classic producer–consumer architecture using:

- Manual Wait/Notify Version
- BlockingQueue Version

Both versions show:

Thread Synchronization

Inter-thread Communication

Shared Resource Handling

Coordinated Data Flow

Multi-threading Best Practices

## 1. Features (Producer–Consumer)
  Manual Version (Low-Level Synchronization)

Uses wait() and notify()

Uses a LinkedList as shared buffer

Producer reads from source list → puts into queue

Consumer reads from queue → stores into destination list

BlockingQueue Version (High-Level Synchronization)

Uses ArrayBlockingQueue

put() auto-waits when queue is full

take() auto-waits when queue is empty

No need for synchronized/locks manually

## Project Structure (Assignment 1)
src/main/java/com/example/demo/producer/manual/
ProducerConsumer.java
Producer.java
Consumer.java

src/main/java/com/example/demo/producer/blocking/
BlockingProducerConsumer.java
BlockingProducer.java
BlockingConsumer.java

src/test/java/com/example/demo/producer/
ProducerConsumerTest.java
BlockingProducerConsumerTest.java

## How It Works
Manual Version Flow:
SOURCE LIST → PRODUCER THREAD → SHARED QUEUE → CONSUMER THREAD → DESTINATION LIST

Blocking Version Flow:
SOURCE LIST → PRODUCER (queue.put()) → BLOCKING QUEUE → CONSUMER (queue.take()) → DESTINATION LIST

## Sample Output (Assignment 1)
[Manual Producer] Produced: 1
[Manual Consumer] Consumed: 1
[Blocking Producer] Produced: 1
[Blocking Consumer] Consumed: 1
...

# Assignment 2: Sales Analysis Module

This module demonstrates CSV reading, Java Streams, Functional Programming, Grouping, Aggregation, and JUnit test-driven validation.

Your updated data is used in this README as referenced.

## 2. Features (Sales Analysis)

CSV File Parsing

Convert CSV → POJO (SalesRecord)

Streams-based Analytics

Functional Programming & Lambdas

Grouping & Aggregation

JUnit Testing

Consolidated Reporting in Console

## Project Structure (Assignment 2)
src/main/java/com/example/demo/sales/
SalesRecord.java
SalesAnalysisService.java


File path - src/main/resources/sales_data.csv 

src/test/java/com/example/demo/sales_analysis/
SalesAnalysisTest.java

## Setup Instructions

Clone the repository

Place sales_data.csv in:

src/main/resources/

Build with Maven/Gradle

Run using:

mvn spring-boot:run

Or run the runner class:

SalesAnalysisRunner.java

## Sample Output (Based on Your Updated Data)
=== SALES ANALYSIS REPORT ===

Total Sales: 4537723.50

Sales By Product:
{Montana=661708.75, Velo=738517.75, Amarilla=527437.50,
Carretera=131793.75, Paseo=1476034.25, VTT=402177.50}

Units Sold By Country:
{Canada=7004.0, France=4575.0, USA=5204.0, Mexico=6290.0, Germany=5028.5}

Highest Selling Product:
Paseo

# FINAL DELIVERABLES (Both Assignments)

✔ Complete Source Code
✔ Manual Producer–Consumer (Wait/Notify)
✔ BlockingQueue Producer–Consumer
✔ Sales CSV Analysis Module
✔ JUnit Test Cases
✔ README Documentation
✔ Console Output Results
