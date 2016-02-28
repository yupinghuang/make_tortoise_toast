package toastGame;

public class Toast {

    public Toast() {
        //creates the toast object
    }
    
    public void addTopping(String topping) {
        //adds the topping listed to the toast
    }
    
    public String[] getToppings() {
        //returns the current toppings on the toast in a list of strings
        //if topping become their own class, this would be adjusted to resturn a list of topping objects. But I don't know if that will be necessary...
    }
    
    public void toast(int toastiness) {
        //toasts the Toast based on toastiness
        //should check somewhere (perhaps this will be done somewhere else) to ensure that the int is >= 0, and that it isn't less than the current toastiness
    }
    
    public int get toastiness() {
        //returns toastiness
    }
    
    
    
}