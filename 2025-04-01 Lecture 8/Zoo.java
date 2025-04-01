import java.util.LinkedList;
import java.util.List;
public class Zoo {
    public List<Cageable> animals;
    public Zoo(List<Cageable> animals){
        this.animals = animals;
    }

    /**
     * Produces the list of animals that fit in the Exhibit
     * @param exhibitSideLength assuming a square exhibit enclosure
     * @return the list of animals that fit in the exhibit.
     */
    public List<String> allThatFit(int exhibitSideLength){
        List<String> fit = new LinkedList<>();
        for(Cageable animal : this.animals){
            if(animal.fitInExhibit(exhibitSideLength)){
                fit.add(animal.name());
            }
        }
        return fit;
    }
}
