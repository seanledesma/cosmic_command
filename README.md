CosmicCommand.png<img width="1014" alt="image" src="https://user-images.githubusercontent.com/87875153/229626192-e7fc6825-53fa-47e7-9e38-15e0ff0e1e44.png">



Final project done in collaboration with PeppersOnlyPizza for our Data Structures and Algorithms class.


[![Click here to see a video demo of Cosmic Command](http://img.youtube.com/watch?v=chQ3ZE_LCj8/0.jpg)](https://www.youtube.com/watch?v=chQ3ZE_LCj8 "Cosmic Command")

```markdown
# Cosmic Command

A space-themed strategy game built with JavaFX where players compete against AI opponents for control of planetary bases. Developed by Braden Tolman & Sean Ledesma.

## macOS Setup Guide

### Prerequisites
- Java Development Kit (JDK) 21 or later
- Apache Maven

### Installation Steps

1. Install Homebrew if you don't have it:
```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

2. Install OpenJDK 21:
```bash
brew install openjdk@21
sudo ln -sfn $(brew --prefix)/opt/openjdk@21/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-21.jdk
```

3. Install Maven:
```bash
brew install maven
```

### Running the Game

1. Clone this repository:
```bash
git clone https://github.com/yourusername/cosmic-command.git
cd cosmic-command
```

2. Compile and run:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="application.Main"
```

### Troubleshooting

- Verify Java and Maven installation:
```bash
java --version
mvn --version
```
- Make sure you're running the commands from the project root directory
- If you get compilation errors, ensure you have JDK 21 or later set as your Java version

## Game Description

Cosmic Command is a turn-based strategy game where players must conquer space bases while defending against two AI opponents. Each base has troops and health points, and players must strategically choose which bases to attack or defend.

### Features
- Turn-based strategic gameplay
- Multiple difficulty settings (Easy, Medium, Hard)
- Two AI opponents with adjustable difficulty
- Resource management (troops and base health)
- Graph-based map layout for strategic depth

### How to Play

1. **Starting the Game**
   - Click "New Game" from the title screen
   - Select your preferred difficulty level using the radio buttons

2. **Game Controls**
   - Use "Select" buttons to choose your attacking base
   - Use "Attack" buttons to choose your target base
   - Click "Next Round" to end your turn

3. **Gameplay Mechanics**
   - Each base starts with health points and troops
   - You can only attack bases connected to your current positions
   - Troops will automatically regenerate each turn if under the cap
   - Win by capturing all enemy bases

### Technologies Used
- Java 21
- JavaFX for GUI
- Princeton's algs4 library for graph algorithms
- Maven for build management

## Credits
- Developed by Braden Tolman & Sean Ledesma
- Built using JavaFX and Princeton's algs4 library

## License
[Your chosen license]
```

This README provides installation instructions, gameplay details, and technical information while keeping it straightforward and focused. You can customize the license section and GitHub URLs as needed.

Do you want me to add or modify any sections?