# MSFS-2020 Cockpit Expansion


Android app interface to view and control aircraft cockpit controls in Microsoft Flight Simulator 2020 (MSFS2020). A flask server runs locally on port 5000 as a REST API in JSON format.

Based on:
- [Cockpit Companion](https://github.com/hankhank10/MSFS2020-cockpit-companion)
- [Python-SimConnect](https://github.com/odwdinc/Python-SimConnect) library which provides a python wrapper for SimConnect.

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
- *TODO: Add Android app installation steps

## How to Run

- Ensure that MSFS2020 is running and that you are in an aircraft on a runway
- Navigate to the directory you installed the repo to and run the program with `python glass_server.py`
- Run the Android app
- *TODO: Will need to add instructions for user to input ip of the local host running the python script


## API documentation

#### `http://localhost:5000`
Method: GET

Variables: None

Description: Web interface with moving map and aircraft information

#### `http://localhost:5000/dataset/<dataset_name>`
Method: GET

Arguments to pass:

|Argument|Location|Description|
|---|---|---|
|dataset_name|in path|can be navigation, airspeed compass, vertical_speed, fuel, flaps, throttle, gear, trim, autopilot, cabin|

Description: Returns set of variables from simulator in JSON format


#### `http://localhost:5000/datapoint/<datapoint_name>/get`
Method: GET

Arguments to pass:

|Argument|Location|Description|
|---|---|---|
|datapoint_name|in path|any variable name from MS SimConnect documentation|

Description: Returns individual variable from simulator in JSON format


#### `http://localhost:5000/datapoint/<datapoint_name>/set`
Method: POST

Arguments to pass:

|Argument|Location|Description|
|---|---|---|
|datapoint_name|in path|any variable name from MS SimConnect documentation|
|index (optional)|form or json|the relevant index if required (eg engine number) - if not passed defaults to None|
|value_to_use (optional)|value to set variable to - if not passed defaults to 0|

Description: Sets datapoint in the simulator


#### `http://localhost:5000/event/<event_name>/trigger`
Method: POST

Arguments to pass:

|Argument|Location|Description|
|---|---|---|
|event_name|in path|any event name from MS SimConnect documentation|
|value_to_use (optional)|value to pass to the event|

Description: Triggers an event in the simulator

## Events and Variables

Below are links to the Microsoft documentation 

[Microsoft Simulator SDK Documentation](https://docs.flightsimulator.com/html/index.htm?#t=Introduction%2FIntroduction.htm)

[Event IDs](https://docs.microsoft.com/en-us/previous-versions/microsoft-esp/cc526980(v=msdn.10))

[Simulation Variables](https://docs.microsoft.com/en-us/previous-versions/microsoft-esp/cc526981(v=msdn.10))
