# Counting-cycles-in-a-graph
JAVA programs to count the number of cycles in a directed and undirected graph using Depth First Search and Maze colouring method.


For Undirected Graphs

PROPOSED APPROACH: 

Using the Graph colouring method, mark all the vertices of different cycles with unique numbers. Once the graph traversal is completed, push all similarly marked numbers to an adjacency list and perform the operations required.

ALGORITHM:
•	Insert the edges into an adjacency list.
•	Call the DFS function which uses the colouring method to mark the vertex.
•	Whenever there is a partially visited vertex, backtrack till the current vertex is reached and mark all of them with cycle numbers. Once all the vertices are marked, increase the cycle number.
•	Once DFS is completed, iterate for the edges and push the same marked number edges to another adjacency list.
•	Display the number of cycles accordingly


For Directed Graphs:

PROPOSED APPROACH: 

Depth First Traversal can be used to detect cycles in a Graph. DFS for a connected graph produces a tree. There is a cycle in a graph only if there is a back edge present in the graph. A back edge is an edge that is from a node to itself (self-loop) or one of its ancestors in the tree produced by DFS. To detect cycles, we can check for cycle in individual trees by checking back edges.

The idea is to do DFS of a given graph and while traversing, assign one of the below three colours to every vertex.

WHITE: Vertex is not process yet. Initially, all vertices are WHITE

GREY: Vertex is being processed. 

BLACK: Vertex and all its descendants are processed.


ALGORITHM:

1.	Create a recursive function that takes the edge and colour array (this can also be kept as a global variable)
2.	Mark current nide as GREY.
3.	Traverse all the adjacent nodes and if any node is marked GREY, then return true as a loop is bound to exist.
4.	If any adjacent vertex is WHITE then call the recursive function for that node. If the function returns true. Return true.
5.	If no adjacent node is grey or has not returned true, then mark the current node as BLACK and return false.
