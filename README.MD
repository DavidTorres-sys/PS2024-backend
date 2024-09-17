# RED VIAL MEDELLIN

## Description
RedVialMed is a web-based system designed to manage the road network infrastructure in Medellín. 
The system allows for the management and visualization of road segments and their associated elements, 
such as curbs and roads. The project uses the Play Framework with Java and integrates 
PostgreSQL as the database, utilizing JPA for persistence.


## Features
- CRUD Operations: Manage road segments and their associated elements (e.g., curbs, roads).
- Relational Data: Supports fetching associated elements when retrieving road segments.
- Backend Framework: Play Framework with Java and Guice.
- Database: PostgreSQL using JPA for ORM (Object Relational Mapping).

## Technologies Used
- Play Framework
- Java
- PostgreSQL
- JPA
- Guice
- Docker

## Installation
1. Clone the repository.
2. Install dependencies: Ensure you have SBT installed, then run:
```bash
sbt compile
```
3. run the following commands in the terminal:
```bash
docker-compose -f docker/Docker-compose.yml up --build
```
4. Tables creation: you can enter to pgAdmin and create the tables with the following script:
```
    conf/db/script.sql
```

## Usage

1. Segment Management: Create, read, update, and delete segments.

- GET /segments: Fetch all segments.
- POST /segments: Create a new segment.
- GET /segments/:id: Fetch a specific segment and its associated elements.
- PUT /segments/:id: Update a segment.
- DELETE /segments/:id: Delete a segment.

## Examples
- Create a new segment:

Headers
```
Content-Type: application/json
Accept: application/json
Origin: http://localhost:3000
```
Body
```json
{
  "segmentNumber": 98595,
  "nomenclature": "Alpha",
  "length": 100.5,
  "createdAt": "2024-09-13T10:00:00",
  "updatedAt": "2024-09-13T12:00:00",
  "curbs": [
    {
      "material": "Concrete",
      "length": 5.0,
      "createdAt": "2024-09-13T10:00:00",
      "updatedAt": "2024-09-13T12:00:00"
    }
  ],
  "roads": [
    {
      "pavementType": "Asphalt",
      "length": 5.0,
      "createdAt": "2024-09-13T10:00:00",
      "updatedAt": "2024-09-13T12:00:00"
    }
  ]
}

```




