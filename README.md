# JavaRPG
A little project i've worked on, it's a console game based on the idea of a Brackeys tutorial.  
Not really that related to the tutorial they made. The closest to it is the fact that there is a wizard class, but still I got the idea from them.  
It's getting pretty close to be finished

There is (not really rn) a `doc/` with hopefuly meaningful explanations of most of the code

## Running
To run the game either execute the run.sh or follow the steps bellow

```
git clone https://github.com/Thastertyn/JavaRPG
cd [Directory you cloned to]
mkdir build/
javac -cp src/ src/*.java -d build/
cd build/
echo "Manifest-Version: 1.0" > MANIFEST.MF
echo "Class-Path: ." >> MANIFEST.MF
echo "Main-Class: App" >> MANIFEST.MF
jar cvmf MANIFEST.MF Game.jar App.class
```
(Thank you tecmint)