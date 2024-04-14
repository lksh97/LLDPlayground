## Elements of Low-Level Design

1. **Guiding principles** are rules that software engineers should generally follow, while design patterns serve as blueprints for thinking and problem-solving in software development.

    This includes SOLID, and tradeoffs between encapsulation, abstraction, inheritance, composition etc.

2. **Design patterns** are blueprints for thinking. Most of the problems we see on a daily basis, have been solved earlier.

The goal is to make the code readable, extensible.


## Programming is coding across time
The three key factors for evaluating code quality are readability, extensibility, and correctness.

- **Readability:** The video underscores the significance of writing code that is easily understood by oneself and fellow engineers. Readable code is crucial for debugging, making changes, and collaborating within a team. It is emphasized that unreadable code increases engineering costs and can negatively impact an organization.

- **Extensibility:** The code should be designed to be easily extended to accommodate changes in requirements over time. The ability to add new features without significant modifications to existing code reflects positively on team culture and the individual engineer.

- **Correctness:** Ensuring that the code is correct is essential for building a solid reputation as an engineer. Bugs that go unnoticed in production can incur high costs for organizations. Code reliability is likened to a fundamental responsibility across various engineering fields.


# What is an API (Appliction Programmable Interface)-
- APIs are endpoint that other developers can use to interact with your system.
- There is no other way to connect with your system except using API.
- They can change internal state of this system using API. - Let say it changes a variable/state directly if you don't wrap it inside a method and add validation to it.
- For our case think of APIs as method signatures ie First line of any function you write.
    - What is name of the function?
    - What it is returning.
    - What object does it expects.
    - What kind of errors can it give?

```java
public GameResult isComplete(Board board) {

}
```
- What stores the API in TurnedBasedGameAI project?
    - Obviously Main class.
- By clearly defining rules for every interaction through API's, you want to restrict access to the data structure.

- A direct access to an internal private data member of a object isn't a good practice.
    - The object may want to do some validations before allowing a user to get or set cell. Direct access doesn't need these validations. So to force validations (only user who is part of this game can make changes, etc...) we encapsulate data member access with methods (get and set).
    - Another reason could be concurrency. If we want the object to be protected from multiple people changing it at the same time, access to the object has to be restricted.


# SOLID Principle
- **S :** Single Responsibility Principle
- **O :** Open Closed Principle
- **L :** Liskov Substitution Principle
- **I :** Interface Segregation Principle
- **D :** Dependency Segregation Principle

## Single Responsibility Principle
- Single piece of Code
    - Responsibility of doing one thing but doing it well.
    - In **Unix programming**, small composable functions which put together can do many things.