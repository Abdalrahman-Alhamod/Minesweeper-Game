# Minesweeper-Game

The Minesweeper-Game repository is a comprehensive collection of classes and functions for building the classic Minesweeper game. It provides a modular and extensible framework that allows you to create, manage, and play Minesweeper games with ease. This README will guide you through the repository's structure, functionality, and usage.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Classes](#classes)
- [Functions](#functions)
- [Customization](#customization)
- [Contributing](#contributing)
- [License](#license)

## Installation

You can use the Instalation file provided 


## Usage

To start playing Minesweeper, you can simply run the `main.py` file, which will launch the game interface. Use the mouse or arrow keys to navigate the game grid and left-click or press the Enter key to reveal a cell. Right-click or press the Spacebar to flag or unflag a cell as a mine. The game will end when you either reveal all non-mine cells or accidentally uncover a mine.

## Classes

The repository provides the following classes:

- `Board`: Represents the Minesweeper game board, which contains a grid of cells. It handles cell initialization, mine placement, and cell interaction.
- `Cell`: Represents an individual cell on the game board. It keeps track of its status (covered, revealed, flagged) and whether it contains a mine.
- `Game`: Manages the overall game flow, including initializing the board, handling player input, and updating the game state.
- `UI`: Implements the user interface for the game, displaying the game board and handling user interactions.

## Functions

The repository also includes several utility functions:

- `validate_coordinates`: Validates the user input for cell coordinates.
- `count_adjacent_mines`: Counts the number of mines in the neighboring cells of a given cell.
- `reveal_empty_cells`: Recursively reveals all adjacent empty cells when an empty cell is revealed.

## Customization

The Minesweeper-Game repository allows you to customize various aspects of the game:

- Board size: You can adjust the size of the game board by modifying the `WIDTH` and `HEIGHT` constants in the `Board` class.
- Difficulty level: The number of mines on the board can be adjusted by changing the `NUM_MINES` constant in the `Board` class.
- UI appearance: You can modify the appearance of the game interface by editing the `UI` class.

## Contributing

Contributions to the Minesweeper-Game repository are welcome! If you have any ideas for improvements, bug fixes, or new features, feel free to open an issue or submit a pull request. Please make sure to follow the repository's code formatting and documentation guidelines.

## License

The Minesweeper-Game repository is licensed under the MIT License. For more information, please see the [LICENSE](LICENSE) file.





