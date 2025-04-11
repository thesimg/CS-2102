import java.util.ArrayList;
import java.util.List;

public class Main {

        /*
       Learning Objectives:
       - How to employ the strategy pattern
       - breaking computation into single-purpose classes
       - composing them back together in "wrapper" classes
       - use the strategy pattern as an example of the last SOLID Principle
         - Dependency inversion:
         - if you care about "flexibility"
           depend on abstractions (interfaces), not specific implementations
       Discussion Questions:
       - https://www.japantrendshop.com/img/takaratomy/life-size-pokemon-gashapon-machine-1.jpg
       - What invariants are on the Gachapon's data?
       - Why would we want to restrict access?
       - Is Toy mutable or immutable? why would we care?
       Strategy Pattern:
       - https://www.youtube.com/watch?v=TyqDOOpJlcA
       - What if we want to:
         - customize more than 1 thing (both the toy bin & the money handling)
         - swap out components *at runtime*
       Instructions:
       1. - Make an interface for what we can do with a List<Toy>
          - Make Gachapon use that interface instead of handling the List<Toy> itself
       2. - Make an interface for handling the money
          - Make Gachapon use that interface instead of handling the money values itself
       Vocabulary:
       - Strategy pattern: using composition rather than inheritance to swap out method implementations at runtime
       - composition: objects storing other objects as fields
       Potential (Final) Exam question:
       - compare and contrast the Template Method Pattern and the Strategy Pattern
     */

    public static void main(String[] args){
        //generated with the help of ChatGPT4.0
        List<Toy> pokemonToys = new ArrayList<>();

        // A pool of Pokemon names
        String[] pokemonNames = {"Pikachu", "Charizard", "Bulbasaur", "Squirtle", "Jigglypuff",
                "Eevee", "Snorlax", "Mewtwo", "Gengar"};

        // Creating 100 Pokemon toys with possible repeats
        for (int i = 0; i < 100; i++) {
            String name = pokemonNames[i % pokemonNames.length];
            int rarity = i % 11;
            pokemonToys.add(new Toy(name, rarity));
        }

        Gachapon g = new Gachapon(pokemonToys);


        // method chaining (Used in the builder pattern a lot):
        System.out.println(g.loadQuarter().loadQuarter().loadQuarter().loadQuarter().receiveToys());

    }


}
