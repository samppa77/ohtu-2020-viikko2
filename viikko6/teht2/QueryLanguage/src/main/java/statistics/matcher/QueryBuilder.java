/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author sampo
 */
public class QueryBuilder {
    
    private Matcher matchers;

    public QueryBuilder() {
//        this.matchers = new All();
    }

    public Matcher build() {
        this.matchers = new All();
        return this.matchers;
    }

    public QueryBuilder playsIn(String team){
        this.matchers = new PlaysIn(team);
        return this;            
    }
    
    
    
//    public Matcher build(){
//        return this.matchers;
//    }
    
}
