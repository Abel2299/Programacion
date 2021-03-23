    /**
     * Write a description of class MedidasEstadisticas here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    import java.util.Random;
    import java.util.Arrays;
    public class CuadernoNotas
    {
        public final static int Nota_Minima=0;
        public final static int Nota_Maxima=10;
        private int [] notas;
        
        public CuadernoNotas(int numeroAlumnos){
            if(numeroAlumnos<0){
                throw new IllegalArgumentException("Numero de alumnos negativo");
            }
            notas= new int[numeroAlumnos];
        }
        
        public int[] getNotas(){
            return this.notas;
        }
        
        public void setNotas(int[] notas){
        
        }
        
        public void generarNotasAleatorias(){
            Random aleatorio=new Random();
            int numeroAleatorio;
            for(int i=0;i<notas.length;i++){
                notas[i]=aleatorio.nextInt(numeroAleatorio=Nota_Maxima-Nota_Minima)+Nota_Minima;
        }
            
        }
        
        public int getNota(int posicion){
            return notas[posicion];
        }
        
        public void setNota(int posicion, int nota){
            if(posicion<0 || nota<0){
                throw new IllegalArgumentException("No son valores válidos");
            }
            notas[posicion]=nota;
        }
        
        public float media(){
            float media,acumuladorMedia=0f;

                for(int i=0;i<notas.length;i++){
                    acumuladorMedia+=notas[i];
                }        
                media=acumuladorMedia/notas.length;
           
            return media;
        }
       
        /*public float mediana(){
            float mediana;
            Arrays.sort(notas);

            
            return mediana;
        }*/
        
        public int rango(){
            int rango,notaAlta, notaBaja;
            
            Arrays.sort(notas);
            
            notaBaja=notas[0];
            notaAlta=notas[notas.length-1];
            
            rango=notaAlta-notaBaja;
            
            return rango;
        }
    
    /*public int[] frecuencias(){
        int [] array;
        array = new int [notas.length-1];
        
        
        
        return array;
    }*/
}
