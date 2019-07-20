
package relation;

import java.util.*;

public class Relation {
    ArrayList<Integer>domain=new ArrayList<>();
    ArrayList<Integer>codomain=new ArrayList<>();
    ArrayList<Integer>ddef=new ArrayList<>();
    ArrayList<Integer>range=new ArrayList<>();
    ArrayList<String>rel=new ArrayList<>();
    boolean[][] m;
          
    public Relation() {
    	this.domain=null;
    	this.codomain=null;
    }
    public Relation(ArrayList<Integer>domain,ArrayList<Integer>codomain) {
    	this.domain=domain;
    	this.codomain=codomain;
    }
    public void setDomain(ArrayList<Integer>domain) {
    	this.domain=domain;
        if(this.codomain != null){
            m = new boolean[this.domain.size()][this.codomain.size()];
        }
    }
    public void setCodomain(ArrayList<Integer>codomain) {
    	this.codomain=codomain;
        if(this.domain != null){
            m = new boolean[this.domain.size()][this.codomain.size()];
        }
    }
    public void setDomain(int a,int b) {     
    	for(int i=a;i<=b;++i)
    		this.domain.add(i);
        if(this.codomain != null){
            m = new boolean[this.domain.size()][this.codomain.size()];
        }
    }
    public void setCodomain(int a,int b) {     
    	for(int i=a;i<=b;++i)
    		this.codomain.add(i);
        if(this.domain != null){
            m = new boolean[this.domain.size()][this.codomain.size()];
        }
    }
     public ArrayList<Integer> getDomain() {
        return this.domain;
    }

    public ArrayList<Integer> getCodomain() {
        return this.codomain;
    }
    public Set<Integer> domainOfDef() {
    	Set<Integer> ab=new HashSet<>();
    	for(int i=0;i<this.ddef.size();++i)
    		ab.add(this.ddef.get(i));
    return ab;
    }
    public Set<Integer> Range() {
    	Set<Integer> ab=new HashSet<>();
    	for(int i=0;i<this.range.size();++i)
    		ab.add(this.range.get(i));
    	return ab;
    }
    private int getPos(int a,ArrayList<Integer>s) {
    	return s.indexOf(a);
    }
    public boolean addElement(int x,int y) {
    	boolean b=false;
            if(!this.rel.contains("(" + x + "," + y + ")")){
                this.ddef.add(x);
                this.range.add(y);
                m[getPos(x,this.domain)][getPos(y,this.codomain)] = true;
                this.rel.add("("+ x +","+ y +")");
                b=true;
        }
    	for(int i=0;i<this.ddef.size();++i){
    		
    	}
    	return b;	
    }
    public boolean isElement(int x, int y){
        return (this.ddef.contains(x) && this.range.contains(y));
    }
    public String toString() {
    	String s="";
    	for(int i=0;i<this.ddef.size();++i){
            if(i%2==0){s+="\n;";
    		s+="("+this.ddef.get(i)+","+this.range.get(i)+")";}
    	}	
    	return s;			
    }
}

