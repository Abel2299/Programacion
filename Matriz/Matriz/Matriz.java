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
        int [] colum1, colum2;        
        colum1=getColumna(columna1);
        colum2=getColumna(columna2);
        for(int i=0;i<filas;i++){
            elementos[i][columna1]=colum2[i];
            elementos[i][columna2]=colum1[i];
        }
    }
    
    /*public Matriz borrarColumna(int columna){
        
    }*/
    
    public Matriz sumar(Matriz otraMatriz){
        int fila1=0,columna1=0;
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
    }
    
    public Matriz trasponer(){
       Matriz trasponer ;
       trasponer=new Matriz(filas,columnas);
       for(int i=0;i<filas;i++){
           for(int j=0;j<columnas[i];j++){
		
            }	
	}
	return trasponer;
    }
}
