# Lab 5 -- Neo4j

1.
```neo4j
MATCH (m:Movie)
RETURN  m
```
2.
```neo4j
MATCH (p:Person{name:"Hugo Weaving"})-[:ACTED_IN]->(m:Movie)
RETURN  p,m
```
3.
```neo4j
MATCH (p:Person{name:"Hugo Weaving"})-[:ACTED_IN]->
(m:Movie)<-[:DIRECTED]-(directors:Person)
RETURN  directors,m
```
4.
```neo4j
MATCH (p:Person{name:"Hugo Weaving"})-[:ACTED_IN]->
(m:Movie)<-[:ACTED_IN]-(coactors:Person)
RETURN  coactors,m
```
5.
```neo4j
MATCH (mm:Movie)<-[:ACTED_IN]-(a:Person)-[:ACTED_IN]->(m:Movie)
WHERE m.title CONTAINS "Matrix"
RETURN  mm,a
```
6.
```neo4j
MATCH (actor:Person)-[:ACTED_IN]->(movie:Movie)
RETURN actor, COUNT(movie) AS movieCount ORDER BY movieCount desc
```

7.
```neo4j
MATCH (person:Person)-[:DIRECTED]->(movie:Movie)<-[:WROTE]-(person:Person)
RETURN person, movie
```

8.
```neo4j
MATCH (keanu:Person)-[:ACTED_IN]->(movie:Movie)<-[:ACTED_IN]-(hugo:Person)
WHERE hugo.name = "Hugo Weaving" AND  keanu.name = "Keanu Reeves"
RETURN hugo, movie, keanu
```

9.
```neo4j
CREATE (mov:Movie{title:"Captain America: The First Avenger"})
CREATE (dir:Person{name:"Joe Johnston"})
CREATE (dir)-[:DIRECTED]->(mov)
CREATE (wr1:Person{name:"Christopher Markus"})
CREATE (wr1)-[:WROTE]->(mov)
CREATE (wr2:Person{name:"Stephen McFlee"})
CREATE (wr2)-[:WROTE]->(mov)
CREATE (wr3:Person{name:"Joe Simon"})
CREATE (wr3)-[:WROTE]->(mov)
CREATE (act1:Person{name:"Chris Evans"})
CREATE (act1)-[:ACTED_IN]->(mov)
CREATE (act2:Person{name:"Samuel L. Jackson"})
CREATE (act2)-[:ACTED_IN]->(mov)
CREATE (act3:Person{name:"Hugo Weaving"})
CREATE (act3)-[:ACTED_IN]->(mov)
return mov, dir, wr1,wr2,wr3,act1,act2,act3
```
