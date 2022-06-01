# Reflection on my Intended Design

## Task 2 - Reflecting on Initial Design

* [1]There is one class which is missing in my diagram, the subclass of “Tile” that is “Free”. I excluded it because nothing happens on that object. However, there is no property to be bought from, but it should exist as a subclass of the tile so that a player can visit there.
[2] There were no extra classes used in my design in each of the diagrams (object, class, and sequential diagram). This could be because I simply had no experience of that game in real life, so that would help me extend my idea and add extra classes on the design. Although I learned lately that I could add classes like “jail” which exist in the real game.
[3] That might not be considered as a major difference, but the “ConsoleUi” class was written as I used “UI” instead. The rest are the same. The classes have names which fit to their content and normally define the operations they contain.
[4] The player and property classes should have a direct association relation which is missed in my design. Game and human player had to have an association relation instead of dependency, as a human Player does not depend on the game's existence. However, it is a dependency relation in my design.
[5] Dependency/association relations are used in my design diagram to connect the objects based on the relation they have, if the existence of a class affects the other classes which connect to, it is used a dependency relation otherwise association.
[6] I have managed to divide the complexity into which most of the classes have similar attributes(fields) and operations(methods).
[7] In the object diagram, two attributes of the human player “name” & “fund” are missing in my design.
[8] There is one difference in the sequential diagram: the “fund” message which was supposed to be sent from the human player to the UI, but it is sent to the “start” class in my design.
[9] I believe I have done a good job as this is the initial design, Although I missed some operations (methods) which had to exist and implement the functions further.
[10] I have learned that designing requires creativity and flexibility much more than I thought before and it is a time-consuming task.


