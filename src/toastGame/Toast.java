/**
 * Toast.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Date: Feb 28, 2016
 * 
 * Beginning of the model for Toast (INCOMPLETE)
 */

package toastGame;

import java.util.*;

public class Toast {
    private ArrayList<Topping> toppings;
    private int toastiness;

    /**
     * Creates the toast object with no toppings and 0 toastiness
     */
    public Toast() {
        this.toppings = new ArrayList<Topping>();
        this.toastiness = 0;
    }
    
    public void addTopping(Topping topping) {
        //adds the topping listed to the toast
        //might want to check (with assert?) that the topping being added is a legitimate topping option
        
        this.toppings.add(topping);
    }
    
    public ArrayList<Topping> getToppings() {
        //returns the current toppings on the toast in a list of strings
        //if topping become their own class, this would be adjusted to return a list of topping objects. But I don't know if that will be necessary...
        
        return this.toppings;
    }
    
    public void toast(int toastiness) {
        //toasts the Toast based on toastiness
        //should check somewhere (perhaps this will be done somewhere else) to ensure that the int is >= 0, and that it isn't less than the current toastiness
        
        this.toastiness = toastiness;
    }
    
    public int getToastiness() {
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