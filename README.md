This project is a Java based control program for a Swiftbot that autonomously searches for light sources using camera input. The program processes images, analyzes light intensity, and directs the Swiftbot to move towards the brightest area. Additionally handle user input via a command-line interface (CLI).

Features
  Light Detection: Analyzes camera input to determine the brightest direction (left, center, or right).
  Randomized Search: Changes direction randomly when no light is detected within a set time frame.
  Command-Line Interface (CLI): User-friendly interaction with error handling and the ability to export logs.
Usage:
  Press button 'A' on the Swiftbot to start the program.
  The robot will take a picture, process the light intensity, and move in the appropriate direction.
  If an obstacle is detected, the Swiftbot will pause and inform the user.
  Press button 'X' to stop the program, with an option to view or save the log.
