Kredily Automation Testing
📌 Project Overview

This project automates the process of scheduling a demo on the Kredily platform using Selenium WebDriver in Java. It covers user login, navigating to demo scheduling, selecting dates and time slots, filling out forms, and confirming the schedule. The automation ensures consistency, efficiency, and reduces manual effort.

⚙️ Technologies Used

Java

Selenium WebDriver

ChromeDriver (can be extended to other browsers)

IntelliJ IDEA / Eclipse

Maven (for dependency management)

🔧 Features

Automates login and demo scheduling on Kredily

Selects available dates and time slots dynamically

Fills out the form with user details

Handles popups and modals using frame switching and JavaScript executor

Captures dynamic elements and ensures they are interactable

Provides a robust solution to prevent ElementClickInterceptedException

🛠️ Setup Instructions
Prerequisites

Java 8 or higher installed

Maven installed

Chrome browser installed

ChromeDriver compatible with your Chrome version

Installation Steps

Clone the repository:

git clone https://github.com/Jagadeesh5242/Automation-Testing-Kredily.git


Import the project into IntelliJ IDEA or Eclipse as a Maven project.

Ensure chromedriver.exe is in your system PATH or provide the path in the code:

System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");


Update login credentials in the code with your own (currently placeholders are used).

Running the Test

Run the KredilyDemoTest.java class directly from your IDE.

The script will open Chrome, navigate to Kredily, and perform the demo scheduling workflow automatically.

⚡ Notes

The code handles popups, frames, and dynamic buttons.

If elements fail to click, it uses JavaScript fallback to ensure interaction.

Adjust Thread.sleep() durations if necessary depending on your network speed.
