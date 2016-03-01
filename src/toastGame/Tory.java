/**
 * Tory.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Date: Feb 28, 2016
 * 
 * Beginning of the model for Tory (incomplete)
 */

package toastGame;

public class Tory {
    private Toast criteria;

    /**
     * Instantiates Tory object, which has a (plain) Toast object as it's criteria
     */
    public Tory() {
        //sets Tory's toast criteria to be plain toast
        this.criteria = new Toast();
    }
    
    /**
     * Changes the criteria Toast to have a randomized set of toppings
     * @return			the criteria Toast object
     */
    public Toast createCriteria() {
        //creates a randomized Toast object to judge upon and returns it
        //should create toast objects based on difficulty of the game (implement this later)
        
        this.criteria.clear();
        //This is where we would randomly get rid of toppings and set the toastiness of the criteria
        return this.criteria;
    }
    
    public Toast getCriteria() {
        //returns a toast object of Tory's current criteria
        
        return this.criteria;
    }
 
    /**
     * Takes user's Toast object and judges it in accordance with Tory's criteria Toast object
     * @param userToast
     * @return
     */
    public String judgeToast(Toast userToast) {
        //takes in the user's toast and judges it based on Tory's current criteria (implement later)
        //Could judge differently based on difficulty of level
        
        return "";
    }
    
}