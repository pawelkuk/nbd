# Lab 6 -- Neo4j


1.
```neo4j
MATCH 
    (t1{name:"Darjeeling"}),
    (t2{name:"Sandakphu"}),
    p= allShortestPaths((t1)-[*]-(t2))
RETURN p
```

2.
```neo4j
MATCH 
    (t1{name:"Darjeeling"}),
    (t2{name:"Sandakphu"}),
    p= allShortestPaths((t1)-[*]-(t2))
    WHERE all(r IN relationships(p) WHERE r.winter = 'true')
RETURN p
```
3.a
```neo4j
MATCH 
    (t1{name:"Darjeeling"}),
    (t2{name:"Sandakphu"}),
    p= (t1)-[*]->(t2)
RETURN 
    p AS shortestPath,
    reduce(dist=0, r in relationships(p) | dist + r.distance) 
        AS totalDist
ORDER BY totalDist ASC

```


3.b
```neo4j
MATCH 
    (t1{name:"Darjeeling"}),
    p= (t1)-[:twowheeler*{summer:'true'}]->(t2)
RETURN 
    p
```

4.
```neo4j
MATCH 
    (a:Airport)-[:ORIGIN]-(f:Flight)
RETURN 
    a,count(f) AS outgoingflightsCount
ORDER BY 
    outgoingflightsCount desc
```

5.
```neo4j
MERGE 
	(f:Flight)<-[:ASSIGN]-(t:Ticket{class:'economy'})
with
	f
match
	(a:Airport{name:"LAX"})
call
	apoc.path.expandConfig(a, {
    	minLevel:2,
        //maxLevel:7,
        sequence:"Airport,ORIGIN,Flight,DESTINATION"
    })
yield
	path
with 
	path, reduce(price=0, n in [nn in nodes(path) WHERE 'Flight' IN LABELS(nn)] | price + n.price) 
        AS totalPrice
where 
	totalPrice <3000 and
    all(i in range(1, length(path)-1, 2) 
    	where nodes(path)[i].date + nodes(path)[i].duration< nodes(path)[i+2].date  
    )
return
	path, totalPrice
limit 200
```
6.
```neo4j
MERGE 
	(f:Flight)<-[:ASSIGN]-(t:Ticket{class:'economy'})
with
	f
match
	(lax:Airport{name:"LAX"})
match
	(day:Airport{name:"DAY"})
call
	apoc.path.expandConfig(lax, {
    	minLevel:2,
		//maxLevel:10,
        sequence:"Airport,ORIGIN,Flight,DESTINATION",
        endNodes:[day]
    })
yield
	path
with 
	path, reduce(price=0, n in [nn in nodes(path) WHERE 'Flight' IN LABELS(nn)] | price + n.price) 
        AS totalPrice
where
    all(i in range(1, length(path)-1, 2) 
    	where nodes(path)[i].date + nodes(path)[i].duration< nodes(path)[i+2].date  
    )
return
	path, totalPrice
order by totalPrice
```
7.
```neo4j
```
8.
```neo4j
```
9.
```neo4j
```
10.
```neo4j
```



