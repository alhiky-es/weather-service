# Weather Service API

A simple Spring Boot-based REST API that provides weather information based on latitude and longitude coordinates. The API uses the National Weather Service (NWS) API to retrieve weather data, including a short forecast and a temperature categorization.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Customization](#customization)

## Features
- Retrieves weather forecast data based on latitude and longitude coordinates.
- Provides a short forecast (e.g., "Partly Cloudy") for the specified location.
- Classifies temperature as "hot," "cold," or "moderate" based on defined thresholds.

## Requirements
- **Java 11** (or higher)
- **Maven** for dependency management and build (if you plan to build the project with Maven)
- Internet connection for the application to call the National Weather Service API.

## Installation

### Step 1: Clone the Repository
```bash
git clone 
cd weather-service