# RoomOptimizer

## Idea
A workforce optimization tool for allocating cleaning resources in a structure. Structures are all of varying size (measured in rooms). The
workforce is made up of Senior Cleaners and Junior Cleaners. Senior Cleaners have a
higher work capacity than Junior Cleaners. It is free to decide how many Senior and Junior
Cleaners are to be sent to clean a structure but there always needs to be at least one Senior cleaner at
every structure to lead the juniors. 

## Goal
Minimize overcapacity at every structure.

Given an array of structure sizes (in no. of rooms) as well as work capacities of Junior and Senior
Cleaners, it is needed to present the optimal numbers of Juniors and Seniors for every structure.

## Input:
- array of rooms (int) for every structure
- cleaning capacity Junior Cleaner (int)
- cleaning capacity Senior Cleaner (int)
There are no cleaning providers with more than 100 structures in their portfolio. None of the structures
will have more than 100 rooms.

## Output:
- array of maps which include the optimal number of Juniors and Seniors for every structure

## Build and run

```yaml
mvn clean install spring-boot:run
```

or 

```yaml
mvn clean install
java -jar <jar location>/RoomOptimizer-1.0.jar 
```

## REST API

Optimizer available via the following URI

```yaml
http://localhost:8080/allocate/resources 
```
The call is made as a POST call with the fowllowing body

```yaml
{ "rooms": [24, 120], "senior": 11, "junior": 6 }
```
Response is also in json forma.

Successfull response (200
```yaml
[
    {
        "senior": 2,
        "junior": 1
    },
    {
        "senior": 2,
        "junior": 1
    }
]
```
Big structure response(404)
```yaml
"Too big structure"
```
