package toastGame;

public class Tory {
    private Toast criteria;

    public Tory() {
        //creates the Tory object
        //sets Tory's toast criteria to be plain toast
        
        this.criteria = new Toast();
    }
    
    public Toast createCriteria() {
        //creates a randomized Toast object to judge upon and returns it
        //should create toast objects based on difficulty of the game (implement this later)
        
        this.criteria.clear();
        //This is where we would randomly get rid of toppings and set the toastiness of the criteria
        return this.criteria
    }
    
    public Toast getCriteria() {
        //returns a toast object of Tory's current criteria
        
        return this.criteria;
    }
 
    public String judgeToast(Toast userToast) {
        //takes in the user's toast and judges it based on Tory's current criteria (implement later)
        //Could judge differently based on difficulty of level
        
        return '';
    }
    
}