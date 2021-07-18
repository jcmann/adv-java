package java112.project3;

/**
 *  This is a JavaBean to demonstrate using beans with JSP.
 *
 *@author    eknapp
 */
public class BeanOne {

    private String data;

    /**
     *  Constructor for the BeanOne object
     */
    public BeanOne() {
        data = "default value";
    }

    /**
     *  Gets the Data attribute of the BeanOne object
     *
     *@return    The Data value
     */
    public String getData() {
        return data;
    }

    /**
     *  Sets the Data attribute of the BeanOne object
     *
     *@param  data  The new Data value
     */
    public void setData(String data) {
        this.data = data;
    }
}
