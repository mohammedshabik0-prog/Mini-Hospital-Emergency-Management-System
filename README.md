# Mini Hospital Emergency Management System

## CIT300 - Data Structures and Algorithms

### Assignment Title
Mini Hospital Emergency Management System Using Data Structures

## 1. Introduction

The Mini Hospital Emergency Management System is a Java console-based application developed to demonstrate the practical use of fundamental data structures.

The system manages patient records, emergency patients, completed treatments, and patient visit histories.

The following data structures are implemented:

- Binary Search Tree (BST)
- Queue
- Stack
- Singly Linked List

## 2. Features

### Patient Records - Binary Search Tree

The system allows users to:

- Register a new patient
- Search for a patient using Patient ID
- Delete a patient
- Display all patients in ascending Patient ID order

Each patient contains:

- Patient ID
- Patient Name
- Age
- Contact Number
- Medical Condition

### Emergency Patient Queue

The emergency queue allows users to:

- Add patients to the waiting queue
- Remove the next patient for treatment
- Display waiting patients
- Handle an empty queue

The queue follows FIFO (First-In, First-Out).

### Treatment History - Stack

The treatment stack allows users to:

- Add completed treatment records
- Remove the most recently completed treatment
- Display treatment records
- Handle an empty stack

The stack follows LIFO (Last-In, First-Out).

### Patient Visit History - Singly Linked List

Each patient has a visit history.

The system allows users to:

- Add a visit
- Remove a visit
- Search for a visit
- Display visit history

Each visit contains:

- Visit ID
- Visit Date
- Doctor Name
- Diagnosis
- Treatment

## 3. Technologies Used

- Java
- Object-Oriented Programming
- Data Structures and Algorithms
- Git
- GitHub
- Visual Studio Code

## 4. Project Structure

```text
MiniHospitalEmergencyManagementSystem
│
├── src
│   ├── Main.java
│   │
│   ├── model
│   │   ├── Patient.java
│   │   ├── Visit.java
│   │   └── TreatmentRecord.java
│   │
│   ├── bst
│   │   ├── PatientNode.java
│   │   └── PatientBST.java
│   │
│   ├── queue
│   │   └── EmergencyQueue.java
│   │
│   ├── stack
│   │   └── TreatmentStack.java
│   │
│   └── linkedlist
│       ├── VisitNode.java
│       └── VisitLinkedList.java
│
├── README.md
└── .gitignore
