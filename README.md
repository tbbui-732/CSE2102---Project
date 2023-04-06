# CSE2102: Introduction to Software Engineering

## Project - Video Inventory System
In this project, you will build an interactive system (command-line based) for managing the inventory for a video streaming service, such as Netflix. This system will be built incrementally following a process that is similar to the agile approach. Each sprint will be 1 week long, and will culminate with a demo in the lab.

## Specified Sprints
- Located in the project_info PDF

## Test Driver Specifications
### The goal of the test driver is to test the accessor, mutator and constructor methods in your classes. Implement the test driver in the following steps:
1. Prompt the user whether they want to build a TV show or a movie.
2. Collect the attributes of the TV show or a Movie based on the answer to question #1.
The user should be prompted to input one attribute at a time.
3. Instantiate the TV show or Movie based on the attributes collected in Step 2.
4. Print the contents of the TV show/Movie built in step #2.
5. Prompt the user if they want to change any attribute of the TV show/Movie. For the sake
of simplicity, we will assume that the user can change only one of the attributes of the
TV show or Movie.
6. If the answer to question in #5 is yes, then further ask the user which attribute they
want to change.
7. If the answer to question in #5 is no, then the driver exits.
8. Print the old value stored of the attribute, and ask for the new value.
9. Set the attribute to its new value, and print the TV show or the Movie.
10. Exit

### Note, one run of the test driver will build exactly one instance of a TV show or a movie, and will implement no more than one change of an attribute. No error checking is necessary, assume that the user always provides correct inputs.

### Aside
#### Write functions in this order to have some standards (lol)
    show_id      
    type         
    title        
    director     
    country      
    release_year 
    rating       
    duration   (shows: seasons, movies: minutes)
    genre        
