CosmicCommand.png<img width="1014" alt="image" src="https://user-images.githubusercontent.com/87875153/229626192-e7fc6825-53fa-47e7-9e38-15e0ff0e1e44.png">



Final project done in collaboration with PeppersOnlyPizza for our Data Structures and Algorithms class.


[![Click here to see a video demo of Cosmic Command](http://img.youtube.com/watch?v=chQ3ZE_LCj8/0.jpg)](https://www.youtube.com/watch?v=chQ3ZE_LCj8 "Cosmic Command")

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

2. Install OpenJDK 21:
```bash
brew install openjdk@21
sudo ln -sfn $(brew --prefix)/opt/openjdk@21/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-21.jdk
```

3. Install Maven:
```bash
brew install maven
```


## Running the Game

1. Open Terminal and navigate to your project directory:
```bash
cd path/to/cosmic-command
```

2. Clean and compile the project:
```bash
mvn clean compile
```

3. Run the game:
```bash
mvn exec:java -Dexec.mainClass="application.Main"
```

## Troubleshooting

- If you get path-related errors, ensure your project directory path doesn't contain spaces or special characters
- Make sure all resources (images, fxml files) are in their correct locations
- Verify that algs4.jar is present in the lib directory
- Check that Java and Maven are properly installed:
  ```bash
  java --version
  mvn --version
  ```

## Important Notes

- The game requires JDK 21 or later
- All file paths in FXML files should use the "@" notation (e.g., "@/maps/map-3.png")
- Resource files must be in the correct locations under src/main/resources
