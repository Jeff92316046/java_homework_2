public class test {
    public static void main(String[] args) {
        int i=1,s1=0, s2=0, n=11;
      System.out.print(demoD(7,9));   }
           static int demoD(int M,int N)     {
          int Result;
          if ( N == 1)
               Result = M;        
          else
              Result = M + demoD(M,N-1); 
          return  Result;}
}
