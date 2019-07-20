package relation;

import java.util.*;

public class RST_Relation extends Relation {

    public RST_Relation() {
        this.domain = null;
        this.codomain = null;
    }

    public RST_Relation(ArrayList<Integer> domain, ArrayList<Integer> codomain) {
        this.domain = domain;
        this.codomain = codomain;
    }

    public boolean isReflexive() {
        int x;
        boolean b = false;
        for (int i = 0; i < this.domain.size(); ++i) {
            x = this.domain.get(i);
            if (rel.contains("(" + x + "," + x + ")")) {
                b = true;
            } else {
                b = false;
                break;
            }
        }
        return b;
    }

    public boolean isSymmetric() {
        int x, y;
        boolean b = false;
        for (int i = 0; i < this.ddef.size(); ++i) {
            x = this.ddef.get(i);
            y = this.range.get(i);
            if (rel.contains("(" + x + "," + y + ")")) {
                if (rel.contains("(" + y + "," + x + ")")) {
                    b = true;
                } else {
                    b = false;
                    break;
                }
            } else {
                b = true;
            }
        }
        return b;
    }

    public boolean isTransitive() {
        int x, y, z;
        boolean b = false;
        for (int i = 0; i < this.ddef.size(); ++i) {
            for (int j = 0; j < this.ddef.size(); ++j) {
                x = this.ddef.get(i);
                y = this.range.get(i);
                z = this.range.get(j);
                if (rel.contains("(" + x + "," + y + ")") && rel.contains("(" + y + "," + z + ")")) {
                    if (rel.contains("(" + x + "," + z + ")")) {
                        b = true;
                    } else {
                        b = false;
                        break;
                    }
                } else {
                    b = true;
                }
            }
        }
        return b;
    }

    public boolean isEquivalence() {
        return this.isReflexive() && this.isSymmetric() && this.isTransitive();
    }

    public String printEqClasses() {
        ArrayList<String> Eq = new ArrayList<>();
        String s = "";
        if (isEquivalence()) {
            ArrayList<Integer> x = new ArrayList<>();
            for (int i = 0; i < this.ddef.size(); ++i) {
                if(!x.contains(this.ddef.get(i))){
                   s += "[" + this.ddef.get(i) + "]={";
                    for (int j = 0; j < this.range.size(); ++j) {
                        if (this.ddef.get(i) == this.ddef.get(j) && rel.contains("(" + this.ddef.get(i) + "," + this.range.get(j) + ")")) {
                            s += "(" + ddef.get(i) + "," + range.get(j) + ")" + ",";
                        }
                    }
                    s += "}\n";
                    x.add(this.ddef.get(i)); 
                }
                
            }

            return s;
        } else {
            s = "doesn't Equivalence Relation ";
            return s;
        }

    }
}
