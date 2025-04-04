import java.util.*;

public class Main {
    public static void main(String[] args){
        List<FilmEntry> entries = new LinkedList<>();
        entries.add(new FilmEntry("Pinocchio",0, 2002));
        entries.add(new FilmEntry("Speed 2: Cruise Control",4, 1997));
        entries.add(new FilmEntry("Pokémon: The First Movie",16, 1998));
        MockRottenTomatoes mRT = new MockRottenTomatoes(entries);
        System.out.println(mRT.averageScore());

        PromptRottenTomatoes pRT = new PromptRottenTomatoes(2);
        System.out.println(pRT.averageScore());

        CSVRottenTomatoes csvRT = new CSVRottenTomatoes("deniro.csv", ";");
        System.out.println(csvRT.averageScore());


//        RandomRottenTomatoes rrt = new RandomRottenTomatoes();
//        System.out.println(rrt.averageScore());

        /* Lecture 10:
         * Learning Objectives
         - Students will be able to follow code reuse between parent and child classes (inheritance)
         - Students will be able to setup "Subclass Responsibilities" between parent and child classes
         - [optional] Students will begin understanding of programming for applications
         * In-class lecture Plan:
         - Examine example code to see how abstract classes/methods are useful
         - Quiz Question: In the code above, what are the method calls that get made (and in what order)
         - Example Exam Question/Activities:
           - Sketch out the code as a UML Diagram
           - Interfaces and Inheritance are both OO design tools that help us
               extend existing code rather than modifying it when our programs need to change.
             Right now, RottenTomatoes.java makes some assumptions about the data,
               and leaves some as subclass responsibility
             - What is an example of what could change such that
               we would want to make an interface with averageScore() and populateData()?
             - What is an example of what could change such that
               a fourth subclass is more appropriate than an interface?
         */
    }
}
