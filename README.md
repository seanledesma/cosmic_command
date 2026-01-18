<img width="1014" alt="Cosmic Command Screenshot" src="https://user-images.githubusercontent.com/87875153/229626192-e7fc6825-53fa-47e7-9e38-15e0ff0e1e44.png">

[![Build Cosmic Command](https://github.com/seanledesma/cosmic_command/actions/workflows/build.yml/badge.svg)](https://github.com/seanledesma/cosmic_command/actions/workflows/build.yml)

# Cosmic Command

A space-themed turn-based strategy game built with JavaFX where players compete against AI opponents for control of planetary bases.

**Developed by Braden Tolman & Sean Ledesma**

[![Video Demo](http://img.youtube.com/vi/chQ3ZE_LCj8/0.jpg)](https://www.youtube.com/watch?v=chQ3ZE_LCj8 "Cosmic Command Video Demo")

## Download

Pre-built installers are available for all platforms - no Java installation required:

| Platform | Download |
|----------|----------|
| macOS | [Cosmic Command.dmg](https://github.com/seanledesma/cosmic_command/releases/latest) |
| Windows | [Cosmic Command.exe](https://github.com/seanledesma/cosmic_command/releases/latest) |
| Linux | [cosmic-command.deb](https://github.com/seanledesma/cosmic_command/releases/latest) |

## Running from Source

### Prerequisites
- Java Development Kit (JDK) 21 or later
- Apache Maven

### Quick Start

```bash
# Clone the repository
git clone https://github.com/seanledesma/cosmic_command.git
cd cosmic_command

# Install the algs4 library to your local Maven repository
mvn install:install-file -Dfile=lib/algs4.jar -DgroupId=edu.princeton.cs -DartifactId=algs4 -Dversion=1.0.0.0 -Dpackaging=jar

# Build and run
mvn clean package
java -jar target/cosmic-command-1.0-SNAPSHOT.jar
```

Or use the run script (macOS/Linux):
```bash
./run.sh
```

### Building Native Installers

To create a platform-specific installer on your machine:

```bash
# Build the JAR first
mvn clean package

# Create installer (macOS)
jpackage --type dmg --name "Cosmic Command" --input target \
  --main-jar cosmic-command-1.0-SNAPSHOT.jar --main-class application.Launcher \
  --icon icon.icns --dest build --app-version 1.0.0

# Create installer (Windows)
jpackage --type exe --name "Cosmic Command" --input target \
  --main-jar cosmic-command-1.0-SNAPSHOT.jar --main-class application.Launcher \
  --icon icon.ico --dest build --app-version 1.0.0 --win-menu --win-shortcut

# Create installer (Linux)
jpackage --type deb --name "cosmic-command" --input target \
  --main-jar cosmic-command-1.0-SNAPSHOT.jar --main-class application.Launcher \
  --icon icon.png --dest build --app-version 1.0.0
```

### macOS Setup (if you need to install Java/Maven)

```bash
# Install Homebrew
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# Install OpenJDK 21
brew install openjdk@21
sudo ln -sfn $(brew --prefix)/opt/openjdk@21/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-21.jdk

# Install Maven
brew install maven
```

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
   - Troops automatically regenerate each turn (capped at 300)
   - Win by capturing all enemy bases

## Technologies Used
- Java 21
- JavaFX for GUI
- Princeton's algs4 library for graph algorithms
- Maven for build management
- GitHub Actions for CI/CD

## License

This project is open source. See the repository for license details.
