
package relation;

import java.util.*;


public class Function extends Relation{
    public Function() {
    	this.domain=null;
    	this.codomain=null;
    }
    public Function(ArrayList<Integer>domain,ArrayList<Integer>codomain) {
    	this.domain=domain;
    	this.codomain=codomain;
    }
    public int getImage(int x){
    	if(this.ddef.contains(x)){
    		int i = this.ddef.indexOf(x);
    		return this.range.get(i);		
    	}
    	else
    	return -1;
    }
    public int getPreimage(int y){
    	if(this.range.contains(y)){
    		int i = this.range.indexOf(y);
    		return this.ddef.get(i);		
    	}
    	else
    		return -1;
    }  
    public boolean addElement(int x,int y){
    	boolean b=false;
    	if((this.domain.contains(x))&&(this.codomain.contains(y))) {
                if(!this.ddef.contains(x)){
                    this.ddef.add(x);
                    this.range.add(y);
                    b=true;
                }
    	}
    	for(int i=0;i<this.ddef.size();++i){
    		rel.add("("+this.ddef.get(i)+","+this.range.get(i)+")");
    	}
    	return b;
    }
    public boolean isLeftTotal(){
           return this.domain.equals(this.ddef) || this.domain.size() == this.ddef.size();
    }
    public boolean isRightTotal(){
            return this.codomain.equals(this.range) || this.codomain.size() == this.range.size();
    }
    public boolean isInjective(){
    	Set<Integer> ab=new HashSet<>();
    	for(int i=0;i<this.range.size();++i)
    		ab.add(this.range.get(i));
    	if(isLeftTotal() && this.domain.size() == ab.size()){
            return true;	
    	}
    	else
            return false;		
    } 
    public boolean isSurjective(){
        if(this.codomain.equals(this.range) || this.codomain.size() == this.range.size())
            return true;
        else
            return false;							         
    }	
    public boolean isBijective(){
    	return (this.isInjective() &&this.isSurjective());
    }
    public Function composite(Function g){	
    	Function GoF=new Function();
    	if(this.range.equals(g.ddef)){
    		GoF.ddef.addAll(this.ddef);
    		GoF.range.addAll(g.range);
    	}
    	return GoF;
    }
    public String toString() {
    	String s="{ ";
    	for(int i=0;i<this.ddef.size();++i){
                s+="\n,";
    		s+="("+this.ddef.get(i)+","+this.range.get(i)+")";
    	}
    	return s+=" }";			
    }
}
