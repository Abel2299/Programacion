import java.util.Random;
/**
 * Write a description of class Matriz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Matriz
{
    private int filas;
    private int columnas;
    private int [][] elementos;
    
    
    public Matriz(int filas, int columnas){
        if(filas<=0 || columnas<=0){
            throw new IllegalArgumentException("Fila o columna incorrecto");
        }
            this.filas=filas;
            this.columnas=columnas;
            elementos=new int [filas][columnas];
    }
    
    public int getFilas(){
        return filas;
    }
    
    public int getColumnas(){
        return columnas;
    }
    
    public int [][] getElementos(){
        return elementos;
    }
    
    public void llenarAleatorio(int limiteInferior, int limiteSuperior){
        Random aleatorio=new Random();
       
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                elementos [i][j]=aleatorio.nextInt(limiteSuperior-limiteInferior) + limiteInferior;
            }
        }
    }  
    
    public int [] getColumna(int columna){
        
        if(columna<columnas && columna>=0){
            int [] arrayColumna;
            arrayColumna = new int [filas];
            
            for(int i=0;i<elementos.length;i++){
                arrayColumna [i]=elementos[i][columna];
            }
    
            return arrayColumna;
        }   
        else{
            throw new IllegalArgumentException("Columna incorrecta");
        }
        
        /*
         * int[] col=null;
         * if(columnas<0 || columna>=columnas){
         *   throw new IllegalArgumentException("Fila o columna incorrecto");
        }
        
        col=new int[filas]
       for(int i=0;i<filas;i++){
                arrayColumna [i]=elementos[i][columna];
            }
         */
    }  
    
    public float [] calcularMediaColumnas(){
        float media,acumuladorColumna=0f;
        float [] arrayMedia;
        arrayMedia=new float[columnas];
        
        for(int j=0;j<columnas;j++){
            for(int i=0;i<filas;i++){
                acumuladorColumna+=elementos[i][j];
            }
            
            media=acumuladorColumna/filas;
            
            arrayMedia [j] = media;
            
            acumuladorColumna=0;
        }
    
        return arrayMedia;
    }
    
    public boolean existe(int n){
        boolean existe=false;
        for(int i=0;i<filas && !existe;i++){
            for(int j=0;j<columnas && !existe;j++){
                if(elementos[i][j]==n){
                    existe=true;
                }
            }   
        }
        
        return existe;
    }
    
    public void intercambiarColumnas(int columna1, int columna2){
        if(columna1<0 || columna1>=columnas || columna2<0 || columna2>=columnas){
            throw new IllegalArgumentException("Columna incorrecta");
        }
        int [] colum1, colum2;        
        colum1=getColumna(columna1);
        colum2=getColumna(columna2);
        if(colum1!=colum2){
            for(int i=0;i<filas;i++){
                elementos[i][columna1]=colum2[i];
                elementos[i][columna2]=colum1[i];
            }
        }
    }
    
    public Matriz borrarColumna(int columna){
        Matriz m=null;
        if(columna<0 || columna>=columnas){
            throw new IllegalArgumentException("Error en la columna");
        }
        if(columnas>1){
            m=new Matriz(filas,columnas);
                for(int j=0,k=0;j<columnas;j++){
                    if(j!=columna){
                    for(int i=0;i<filas;i++){
                        m.elementos[i][k]=elementos[i][j];
                    }
                    k++;
                }
            }
        }   
        return m;
    }
    
    public Matriz sumar(Matriz otraMatriz){
        /*int fila1=0,columna1=0;
        int filas=0,columnas=0;
        int filaN,columnaN;
        this.filas=filas;
        this.columnas=columnas;
        for(int j=0;j<columnas;j++){
            for(int i=0;i<filas;i++){
                filaN=filas+fila1;
                columnaN=columnas+columna1;
            }
        }
        return otraMatriz;
        */
        Matriz m=null;
        if(otraMatriz!=null){
            if(otraMatriz.filas!=filas ||otraMatriz.columnas!=columnas){
                throw new IllegalArgumentException("Matriz no valida");
            }
            m=new Matriz(filas,columnas);
            for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                m.elementos[i][j]=elementos[i][j]+otraMatriz.elementos[i][j];       
            }   
        }
        }
        
        
        return m;
    }
    
    public Matriz transponer(){
       Matriz transponer ;
       transponer=new Matriz(filas,columnas);
       for(int i=0;i<filas;i++){
           for(int j=0;j<columnas;j++){
               transponer.elementos[i][j]=elementos[i][j];
            }   
    }
    return transponer;
    }
    
    /*public boolean equals(Object obj){
        
    }*/
    
    public static boolean esSimetrica(Matriz matriz){
        boolean simetrica=false;
        
        if(matriz!=null){
            if(matriz.filas==matriz.columnas && matriz.equals(matriz.transponer())){
                simetrica=true;
            }
        }
        
        return simetrica;
    }
    
    public String toString(){
        StringBuilder sb=new StringBuilder();
        
        for(int[] fila:elementos){
            for(int elemento: fila){
                sb.append(elemento);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
