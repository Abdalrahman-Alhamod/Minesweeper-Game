# Minesweeper-Game

The Minesweeper Game is a classic computer game where the player must uncover hidden mines on a grid without triggering any of them. It challenges the player's deduction and logical thinking skills.

## Table of Contents

- [Game Rules](#Game-Rules)
- [Features](#Features)
- [Screenshots](#Screenshots)
- [Technologies Used](#Technologies-Used)
- [Usage](#usage)
- [Classes](#classes)
- [Customization](#customization)
- [Installation](#installation)
- [Contributing](#contributing)

## Game Rules

- The game is played on a square grid consisting of cells.
- Some cells contain hidden mines, while others are safe.
- The player's objective is to uncover all safe cells without detonating any mines.
- Each safe cell reveals a number indicating the count of adjacent cells containing mines.
- The player can use this information to deduce the positions of the mines.
- If a mine is triggered, the game ends, and the player loses.
- If all safe cells are uncovered, the game ends, and the player wins.

## Features

- **Customizable Grid**: Allow the player to choose the size of the grid and the number of mines.
- **Cell Interactions**: Implement the ability for the player to uncover cells, flag potential mines, and remove flags.
- **Game Status**: Display the current status of the game, including the number of mines remaining and the elapsed time.
- **User Input Validation**: Validate user input to ensure the game remains fair and consistent.
- **Win/Loss Conditions**: Determine and handle game termination based on win or loss conditions.
- **High Scores**: Track and display high scores achieved by players.
- **User Interface**: Create a user-friendly interface with appropriate graphics and controls.

## Screenshots

> ![Screenshot 2023-09-12 033009](https://github.com/Abdalrahman-Alhamod/Minesweeper-Game/assets/137921143/b08b3bbe-7e27-4581-a871-e492170f47e8)

> ![Screenshot 2023-09-12 033311](https://github.com/Abdalrahman-Alhamod/Minesweeper-Game/assets/137921143/2c431d69-8a66-4a6d-8711-fa6dc5e30003)

> ![Screenshot 2023-09-12 033126](https://github.com/Abdalrahman-Alhamod/Minesweeper-Game/assets/137921143/73853524-e9c9-441b-921c-3d0a20b330e0)

## Technologies Used

- **Programming Language**: Java
- **Dependencies**: Java 9 or above.
- **User Interface**: Java Swing.

## Usage

To start playing Minesweeper, you can simply run the `Game.java` file, which will launch the game interface. Use the mouse or arrow keys to navigate the game grid and left-click or press the Enter key to reveal a cell. Right-click or press the Spacebar to flag or unflag a cell as a mine. The game will end when you either reveal all non-mine cells or accidentally uncover a mine.

## Classes

The repository provides the following classes:

- `Grid`: Represents the Minesweeper game board, which contains a grid of cells. It handles cell initialization, mine placement, and cell interaction.
- `Cell`: Represents an individual cell on the game board. It keeps track of its status (covered, revealed, flagged) and whether it contains a mine.
- `Game`: Manages the overall game flow, including initializing the board, handling player input, and updating the game state.
- `GUI`: Implements the user interface for the game, displaying the game board and handling user interactions.

## Customization

The Minesweeper-Game repository allows you to customize various aspects of the game:

- Board size: You can adjust the size of the game board by modifying the `WIDTH` and `HEIGHT` constants in the `Board` class.
- Difficulty level: The number of mines on the board can be adjusted by changing the `MinesNumber` constant in the `Grid` class.
- GUI appearance: You can modify the appearance of the game interface by editing the `GUI` class.

## Installation

You can use the Instalation file provided :
> [Windows 32-bit Installer](https://github.com/Abdalrahman-Alhamod/Minesweeper-Game/releases/download/v1.5.0/Minesweeper_Windows_x32_Installer.exe)

> [Windows 64-bit Installer](https://github.com/Abdalrahman-Alhamod/Minesweeper-Game/releases/download/v1.5.0/Minesweeper_Windows_x64_Installer.exe)

> [Unix Installer](https://github.com/Abdalrahman-Alhamod/Minesweeper-Game/releases/download/v1.5.0/Minesweeper_Unix_Installer.sh)

## Contributing

Contributions to the Minesweeper-Game repository are welcome! If you have any ideas for improvements, bug fixes, or new features, feel free to open an issue or submit a pull request. Please make sure to follow the repository's code formatting and documentation guidelines.





