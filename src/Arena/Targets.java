package Arena;
import Controllers.ArenaController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Targets {
    ArenaController arenaController;
    public int targetId = 0;
    HashMap<Integer, List<Double>> targetsPos = new HashMap<Integer, List<Double>>();
    HashMap<Integer, Double> targetsHealth = new HashMap<Integer, Double>();
    int points = 0;


    /**
     * Adds target on given position with given health.
     *
     * @param x x-pos
     * @param  y y-pos
     * @param h health
     */
    public void addTarget(double x, double y, double h){
        targetsPos.put(targetId, Arrays.asList(x, y));
        targetsHealth.put(targetId, h);
        targetId++;
    }

    /**
     * Decrease hp of enemy while hit, or deletes it if hp drop below 0.
     *
     * @param id of hit target.
     */
    public void targetHit(int id){
        targetsHealth.put(id, targetsHealth.get(id) - 10);
        if(targetsHealth.get(id) <= 0){
            arenaController.writeOut("You killed target nr " + id);
            deleteTarget(id);
        }else{
            arenaController.writeOut("You hit target nr " + id);
        }
    }

    /**
     * Deletes enemy it if their hp drop below 0.
     *
     * @param id of target to delete.
     */
    public void deleteTarget(int id){
        arenaController.setPoints(++points);
        targetsPos.remove(id);
        targetsHealth.remove(id);
    }

    /**
     * @return enemy position.
     */
    public HashMap<Integer, List<Double>> returnTargetsPos(){
        return targetsPos;
    }

    /**
     * @return enemy health.
     */
    public HashMap<Integer, Double> returnTargetsHealth(){ return targetsHealth; }

    /**
     * Sets controller for GUI manipulation.
     * @param arenaController given controller
     */
    public void setController(ArenaController arenaController) {
        this.arenaController = arenaController;
    }

}
