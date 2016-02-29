package toastGame;

import java.util.*

public class Toast {
    private ArrayList<String>;
    private int toastiness;

    public Toast() {
        //creates the toast object
        //Toast starts out plain (0 toastiness and no toppings)
        
        this.toppings = new ArrayList<String>();
        this.toastiness = 0;
    }
    
    public void addTopping(String topping) {
        //adds the topping listed to the toast
        //might want to check (with assert?) that the topping being added is a legitimate topping option
        
        this.toppings.add(topping);
    }
    
    public ArrayList<String> getToppings() {
        //returns the current toppings on the toast in a list of strings
        //if topping become their own class, this would be adjusted to resturn a list of topping objects. But I don't know if that will be necessary...
        
        return this.toppings;
    }
    
    public void toast(int toastiness) {
        //toasts the Toast based on toastiness
        //should check somewhere (perhaps this will be done somewhere else) to ensure that the int is >= 0, and that it isn't less than the current toastiness
        
        this.toastiness = toastiness;
    }
    
    public int get toastiness() {
        //returns toastiness
        
        return this.toastiness;
    }
    
    public void clear() {
        //resets toastiness to 0 and toppings list to empty
        //The user should not be able to clear their toast when making it
        
        this.toastiness = 0;
        this.toppings.clear();
    }
    
}