/*
 * Copyright (c) 2010 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */
package fr.uga.pddl4j.heuristics.relaxation;
import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.util.BitExp;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;
import fr.uga.pddl4j.util.BitVector;
import java.util.ArrayList;
import java.util.List;
/**
 * This class will display the critical path based on the Delta Algorithm from the Automated Planning book. Automated Planning: Theory & Practice
 * Book by Dana S. Nau, Malik Ghallab, and Paolo Traverso (Chapter 9). At the minute it has a variation of the sum heuristic and max heuristic and 
 * the final method will have the critical path. 
 * @author Aaron Boyd
 * @version 1.0 20.08.2010
 */
public final class CriticalPath extends RelaxedGraphHeuristic {
 private BitExp[] precond;
 private BitExp[] effect;
 private BitExp[] neffect;
 private int [] pGoal;
 private final int k = 2;
 private int goalCard;
 private int critical;
 
 public CriticalPath(CodedProblem problem) {
  super(problem);
  super.setAdmissible(true);
 }

 @Override
 public int estimate(BitState state, BitExp goal) throws NullPointerException {
  super.setGoal(goal);
  this.goalCard = super.getGoal().cardinality();
  goalCard = goal.cardinality();
  int startPoint = 0;
  this.precond = new BitExp[startPoint];
  this.effect = new BitExp[startPoint];
  this.neffect = new BitExp[startPoint];
  BitVector p_goal = super.getGoal().getPositive();
  
        if(this.goalCard <= k){ 
        //Get the initial state and the postitive goal    
        BitVector ppk = new BitVector(state);
        for (int p = ppk.nextSetBit(0); p >= 0; p = ppk.nextSetBit(p + 1)) {
            this.pGoal[p] = 0;
            p_goal.get(p);
        }
        //Compute the positive preconditions
        for (BitOp op: this.getOperators()) {
        final BitExp pre = new BitExp(op.getPreconditions());
        BitVector precon = pre.getPositive();
        for (int p = precon.nextSetBit(0); p >= 0; p = precon.nextSetBit(p + 1)) {
            this.precond[p].getPositive().set(p);
        }
         //Get the positive and negative effects       
        BitExp effects = op.getCondEffects().get(0).getEffects();
        BitVector positiveEffect = effects.getPositive();
        BitVector negativeEffect = effects.getNegative();
        BitVector newProp = new BitVector();
        for (int p = newProp.nextSetBit(0); p >= 0; p = newProp.nextSetBit(p + 1)) {
            positiveEffect.or(this.effect[p].getPositive());
            negativeEffect.or(this.effect[p].getNegative());
        }
        final BitVector n_pos = negativeEffect;
        for (int p = n_pos.nextSetBit(0); p >= 0; p = n_pos.nextSetBit(p + 1)) {
            this.neffect[p].getNegative().set(p);
            n_pos.or(this.neffect[p].getNegative());
        }
        //A is relevant for G only if positive effect does not equal zero and negative effect equals zero
           if(this.effect.length !=0 && this.neffect.length ==0){     
              //Remove the precondition and positive effect from the goal
                p_goal.andNot(positiveEffect);
                p_goal.andNot(precon);
        }
                 critical++;
        }
        return critical;
      
        }else{
        //place the cardinality of the goal in to an array
        int [] combinations = new int [goalCard];
        int m = combinations.length;
        //Generate all subsets from the array
        int list = (1 << m);
        for(int i = 0; i<list; i++){
            List<Integer> sub = new ArrayList<>();
            for(int j=0; j<m; j++){
            if((i &(1<<j)) >0)
                sub.add(j);
        }
        //if the subset size equals k, print subset
        if(sub.size() == k) {
        //System.out.println(sub);
        //Maximum distance to the goal 
         critical = this.getMaxValue();
        }
        }
        }
       
      return super.isGoalReachable() ? critical : Integer.MAX_VALUE;
 }
}
                       