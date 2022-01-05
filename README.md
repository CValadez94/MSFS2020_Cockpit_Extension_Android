# MSFS-2020 Cockpit Expansion

Android app interface to view and control aircraft cockpit controls in Microsoft Flight Simulator 2020 (MSFS2020). A flask server runs locally on port 5000 as a REST API in JSON format.

Based on:
- [Cockpit Companion](https://github.com/hankhank10/MSFS2020-cockpit-companion)
- [Python-SimConnect](https://github.com/odwdinc/Python-SimConnect) library which provides a python wrapper for SimConnect.

## Features
- Cockpit tab to trigger events to the simulator such as:
	- Toggle buttons for Lights, Alternator, Battery, Avionics, etc.
- Monitor tab to view simulation variables such as:
	- Current left/right fuel levels


## Requirements

- [Python 3+](https://www.python.org/downloads/windows/)
- [Flask](https://github.com/pallets/flask)
- [Python-SimConnect-Expansion](https://github.com/CValadez94/Python-SimConnect-Expansion.git)
- *TODO: Add Android app requirements*

## Installation

- Download and install a 64 bit version of [Python 3+ for Windows](https://www.python.org/downloads/windows/)
- Open a Windows command prompt by clicking on the start menu and typing `cmd`
- Install Flask: `pip install -U Flask`
- Install Python-SimConnect-Expansion: `pip install <download_path>\Python-SimConnect-Expansion`
- *TODO: Add Android app installation steps*

## How to Run

- Ensure that MSFS2020 is running and that you are in an aircraft on a runway
- Navigate to the directory you installed the repo to and run the program with `python glass_server.py`
- Run the Android app
- *TODO: Will need to add instructions for user to input ip of the local host running the python script*


## API documentation
See [Python-SimConnect](https://github.com/odwdinc/Python-SimConnect) for API documentation


## Events and Variables
Below are links to the Microsoft documentation 

-[Microsoft Simulator SDK Documentation](https://docs.flightsimulator.com/html/index.htm?#t=Introduction%2FIntroduction.htm)
-[Event IDs](https://docs.microsoft.com/en-us/previous-versions/microsoft-esp/cc526980(v=msdn.10))
-[Simulation Variables](https://docs.microsoft.com/en-us/previous-versions/microsoft-esp/cc526981(v=msdn.10))
