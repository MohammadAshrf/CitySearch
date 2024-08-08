# City Search Application

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction
The **City Search Application** is a simple yet powerful Android application that allows users to search for cities and view their details, including coordinates, country, and more. This project demonstrates the use of Android Jetpack components, MVVM architecture, and Hilt for dependency injection.

## Features
- Search for cities by name
- Display a list of cities with their respective details
- View city location on Google Maps

## Technologies Used
- **Kotlin**
- **Android Jetpack**
  - **Compose** for building UI
  - **ViewModel** for managing UI-related data
  - **LiveData** for observable data holders
  - **Navigation** for in-app navigation
- **Hilt** for dependency injection
- **Gson** for JSON parsing
- **Coroutines** for asynchronous programming

## Architecture
The project follows the **MVVM (Model-View-ViewModel)** architecture pattern:
- **Model:** Represents the data and business logic of the application. This includes the City data model and repository for data fetching.
- **View:** The UI layer of the application built with Jetpack Compose.
- **ViewModel:** Manages the UI-related data in a lifecycle-conscious way. The ViewModel interacts with the repository to fetch data and exposes it to the UI via LiveData or StateFlow.
