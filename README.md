# City Search Application

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Video Demo](#video-demo)

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
  - **StateFlow** for observable data holders
  - **Navigation** for in-app navigation
- **Hilt** for dependency injection
- **Gson** for JSON parsing
- **Coroutines** for asynchronous programming

## Architecture
The project follows the **MVVM (Model-View-ViewModel)** architecture pattern:
- **Model:** Represents the data and business logic of the application. This includes the City data model and repository for data fetching.
- **View:** The UI layer of the application built with Jetpack Compose.
- **ViewModel:** Manages the UI-related data in a lifecycle-conscious way. The ViewModel interacts with the repository to fetch data and exposes it to the UI via LiveData or StateFlow.

## Video Demo

[City Search Application Demo](https://github-production-user-asset-6210df.s3.amazonaws.com/67472054/356040047-ae937164-60cc-4c2d-a591-6b6e7d742de2.mp4?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAVCODYLSA53PQK4ZA%2F20240808%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240808T002702Z&X-Amz-Expires=300&X-Amz-Signature=ef2e4dff6814c08685e52c55772f3be68448cf091cc93e0bf4f9fa77045abb3d&X-Amz-SignedHeaders=host&actor_id=67472054&key_id=0&repo_id=839579992)
