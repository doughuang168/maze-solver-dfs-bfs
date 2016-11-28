# maze-solver-dfs-bfs
Use Depth First-Search(dfs) and Breadth First-Search(bfs) to solve perfect maze


## Local Build
Download complete source thru Github:

- git clone https://github.com/doughuang168/maze-solver-dfs-bfs.git
 
- cd maze-solver-dfs-bfs


- In command windows type "./gradlew build" in Linux environment or ".\gradlew.bat build" in windows environment. In Linux make sure gradlew is exechtable or "chmod +x gradlew"


- In command windows type "cp build/distributions/Maze-1.0-SNAPSHOT.zip targetDir" in Linux environment or "copy build\distributions\Maze-1.0-SNAPSHOT.zip targetDir" in windows environment.  targetDir is the folder hold built artifact.


- cd targetDir


- In command windows type "unzip Maze-1.0-SNAPSHOT.zip" or "tar xvf Maze-1.0-SNAPSHOT.tar"

- cd Maze-1.0-SNAPSHOT

- "cp lib/*.jar ." or "copy lib\\*.jar ."

- java -jar Maze-1.0-SNAPSHOT.jar -classpath "."  com.doughuang168.maze.MazeApplication.class


- java -jar Maze-1.0-SNAPSHOT.jar -classpath "."  com.doughuang168.maze.MazeApplication.class path/to/maze.json
 


- Java 8 and gradle are required for build and run



-  maze.json allow user supply NxN perfect maze use JSON representation. A maze is classified as ‘perfect’ if it does not contain loops.
 
## Maze JSON format

{

	"maze": [ 
				{"mazeRow":[ "x", "x", "s", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"]},
                {"mazeRow":[ "x", " ", " ", "x", " ", "x", " ", "x", " ", " ", " ", " ", " ", " ", " ", "x"]},
                {"mazeRow":[ "x", " ", " ", "x", " ", "x", " ", " ", " ", "x", " ", " ", " ", "x", " ", "x"]},
                {"mazeRow":[ "x", " ", "x", "x", " ", "x", " ", "x", "x", "x", "x", "x", " ", "x", " ", "x"]},
                {"mazeRow":[ "x", " ", " ", " ", " ", "x", " ", " ", " ", "x", " ", "x", " ", "x", " ", "x"]},
                {"mazeRow":[ "x", " ", "x", "x", "x", "x", "x", " ", "x", "x", " ", "x", "x", "x", " ", "x"]},
                {"mazeRow":[ "x", " ", " ", " ", " ", " ", " ", " ", "x", " ", " ", "x", " ", " ", " ", "x"]},
                {"mazeRow":[ "x", "x", "x", " ", "x", "x", "x", "x", "x", " ", "x", "x", "x", "x", "x", "x"]},
                {"mazeRow":[ "x", " ", " ", " ", " ", "x", " ", " ", " ", " ", "x", " ", "x", " ", " ", "x"]},
                {"mazeRow":[ "x", " ", "x", "x", "x", "x", " ", "x", " ", " ", "x", " ", " ", " ", " ", "x"]},
                {"mazeRow":[ "x", " ", " ", " ", " ", "x", " ", "x", " ", "x", "x", " ", "x", "x", "x", "x"]},
                {"mazeRow":[ "x", " ", "x", " ", " ", " ", " ", "x", " ", " ", " ", " ", " ", " ", " ", "x"]},
                {"mazeRow":[ "x", " ", "x", "x", "x", "x", " ", "x", " ", " ", "x", "x", "x", "x", " ", "x"]},
                {"mazeRow":[ "x", " ", "x", " ", " ", " ", " ", " ", " ", "x", "x", " ", " ", "x", " ", "x"]},
                {"mazeRow":[ "x", " ", "x", " ", "x", "x", "x", " ", " ", " ", " ", " ", " ", "x", " ", "x"]},
                {"mazeRow":[ "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "e", "x", "x", "x"]}
			]
}			
