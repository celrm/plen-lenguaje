package ast;

public abstract class EMono extends E {
   private E opnd1;
   public EMono(E opnd1) {
     this.opnd1 = opnd1;
   }
   public E opnd1() {return opnd1;}  
}
