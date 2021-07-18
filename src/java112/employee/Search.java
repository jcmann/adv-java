package java112.employee;

import java.util.ArrayList;
import java.sql.*;

/**
 * Represents all information about a search.
 *
 * @author jcmann
 */
public class Search {

    /**
     * What type of search is being performed.
     */
    private String searchType;

    /**
     * The term being searched for.
     */
    private String searchTerm;

    /**
     * A list of all results found by the search.
     */
    private ArrayList<Employee> results;

    /**
     * Represents whether any search results were found.
     */
    private boolean employeesFound;

    /**
     * Instantiates a new Search. Empty, no-arg constructor.
     */
    public Search() {
        this.results = new ArrayList<Employee>(); 

    }

    /**
     * Instantiates a new Search with all instance variables set
     * with the provided params.
     *
     * @param searchType         the search type
     * @param searchTerm         the search term
     * @param results            the results
     * @param employeesFound the were employees found
     */
    public Search(String searchType, String searchTerm, ArrayList<Employee> results,
                  boolean employeesFound) {
        this(); 
        this.searchType = searchType;
        this.searchTerm = searchTerm;
        this.results = results;
        this.employeesFound = employeesFound;
    }

    /**
     * Add found employee.
     *
     * @param employee the employee to be added to the results list 
     */
    public void addFoundEmployee(Employee employee) {

        results.add(employee); 

    }

    /**
     * Overrides the default toString method to output all the instance
     * variables.
     *
     * @return A string representing that instance.
     */
    @Override
    public String toString() {
        return "Search{" +
                "searchType='" + searchType + '\'' +
                ", searchTerm='" + searchTerm + '\'' +
                ", results=" + results +
                ", employeesFound=" + employeesFound +
                '}';
    }

    /**
     * Gets search type.
     *
     * @return the search type
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * Sets search type.
     *
     * @param searchType the search type
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     * Gets search term.
     *
     * @return the search term
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * Sets search term.
     *
     * @param searchTerm the search term
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     * Gets results.
     *
     * @return the results
     */
    public ArrayList<Employee> getResults() {
        return results;
    }

    /**
     * Sets results.
     *
     * @param results the results
     */
    public void setResults(ArrayList<Employee> results) {
        this.results = results;
    }

    /**
     * Returns the instance variable employeesFound, which
     * represents whether at least one employee matching the search
     * conditions was found.
     *
     * @return employeesFound instance variable
     */
    public boolean isEmployeesFound() {
        return this.employeesFound; 
    }

    /**
     * Sets wereEmployeesFound to a boolean representing whether
     * any employees matching the search conditions were found
     *
     * @param employeesFound whether or not there are search results
     */
    public void setEmployeesFound(boolean employeesFound) {
        this.employeesFound = employeesFound;
    }
}
