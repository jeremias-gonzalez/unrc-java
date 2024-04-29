/**
 * Fecha: clase cuyos objetos representan fechas calendarias, para el 
 * calendario gregoriano. Esta clase implementa una variedad de 
 * funcionalidades sobre fechas, como comparaciones, cómputos de días,
 * etc.
 * 
 * @author N. Aguirre 
 * @version 0.1
 */
public class Fecha
{
    // dia de la fecha
    private int dia;
    
    // mes de la fecha
    private int mes;
    
    // año de la fecha
    private int anho;

    /**
     * Constructor por defecto, para la clase fecha.
     * Crea como fecha por defecto la fecha inicial del 
     * calendario gregoriano (15/10/1582)
     */
    public Fecha()
    {
        dia = 15;
        mes = 10;
        anho = 1582;
    }

    /**
     * Constructor de la clase Fecha, que recibe la fecha a 
     * crear como parámetro. La fecha no puede ser previa
     * al 15/10/1582. Debe tenerse en cuenta la creación de
     * fechas válidas, en relación a número de días en los
     * meses, años bisiestos, etc.
     */
    public Fecha(int nuevoDia, int nuevoMes, int nuevoAnho)
    {
        assert dia<= 1582;
        dia=nuevoDia;
        mes= nuevoMes;
        anho=nuevoAnho;
        
        
    }
    
    /**
     * Retorna el dia de la fecha
     */
    public int obtenerDia() {
        // Implementar este método, reemplazando la línea siguiente
        return dia;
    }
    
    /**
     * Retorna el mes de la fecha
     */
    public int obtenerMes() {
        
        return mes;
    }
    
    /**
     * Retorna el año de la fecha
     */
    public int obtenerAnho() {
        
        return anho;
    }
    
    /**
     * Cambia el día de la fecha. El nuevo día debe ser válido
     * para el mes y año actuales.
     */
    public void cambiarDia(int nuevoDia) {
        dia= nuevoDia;
    }
    
    /**
     * Cambia el mes de la fecha. El nuevo mes debe ser válido
     * para el día y año actuales.
     */
    public void cambiarMes(int nuevoMes) {
        mes = nuevoMes;
    }
    
    /**
     * Cambia el año de la fecha. El nuevo año debe ser válido
     * para el día y mes aactuales.
     */
    public void cambiarAnho(int nuevoAnho) {
        anho=nuevoAnho;
    }
    
    /**
     * Chequea si la fecha es igual a otra fecha dada
     */
    public boolean equals(Fecha otraFecha) {
        // Implementar este método, reemplazando la línea siguiente
        return true;
    }
    
    /**
     * Chequea si la fecha es anterior a otra fecha dada
     */
    public boolean esAnterior(Fecha otraFecha) {
      if(anho <= otraFecha.obtenerAnho())
      {
          if(mes <=otraFecha.obtenerMes())
          {
              if(dia <= otraFecha.obtenerDia())
              {
                  return false;
              }
              else
              {
                  return true;  
              }
          }
          else
          {
              return true;
          }
      }
      else
      {
        return true;
      }
    }
    
    /**
     * Computa distancia en días entre dos fechas.
     * El parámetro otraFecha debe corresponder a una fecha igual o 
     * posterior a la fecha del objeto.
     */
    public int cantidad(Fecha otraFecha) {
    // Implementar este método, reemplazando la línea siguiente
     int dias = 0;
    
    // Creamos una copia temporal de la fecha actual
    int diaTemp = this.dia;
    int mesTemp = this.mes;
    int anhoTemp = this.anho;
    
    // Mientras la fecha temporal no sea igual a otraFecha
    while (diaTemp != otraFecha.dia || mesTemp != otraFecha.mes || anhoTemp != otraFecha.anho) {
        // Avanzamos un día en la fecha temporal
        diaTemp++;
        
        // Si superamos la cantidad de días en el mes actual, avanzamos al siguiente mes
        if (diaTemp > cantDias(mesTemp, anhoTemp)) {
            diaTemp = 1;
            mesTemp++;
            
            // Si superamos diciembre, avanzamos al siguiente año
            if (mesTemp > 12) {
                mesTemp = 1;
                anhoTemp++;
            }
        }
        
        // Incrementamos el contador de días
        dias++;
    }
    
    return dias;

    }
   
    
    /**
     * Computa la cantidad de días de un mes dado. El parámetro
     * debe corresponder a un mes válido.
     */
    private int cantDias(int unMes, int unAnho) 
    {
        assert (unMes >=1 && unMes <=12):"mes invalido";
        if( unMes == 2)
        {
            if(esBisiesto(unAnho))
            {
                return 29;
            }
            else
            {
                return 28;
            }
        }
        else
        {
            if(unMes == 1 || unMes == 3 || unMes == 5 || unMes == 7 || unMes == 8 || unMes == 10 || unMes == 12)
            {
                return 31;
            }
            else
            {
                return 30;
            }
        }
    }
    
    /**
     * Decide si un año dado es bisiesto o no. Un año es bisiesto
     * si es múltiplo de 4, salvo los múltiplos de 100 que no son 
     * múltiplos de 400.
     * El parámetro debe corresponder a un año válido.
     */
    private boolean esBisiesto(int unAnho) 
    {
        assert (unAnho> 1582):"El año es invalido";
        return ((unAnho % 4 == 0 && unAnho % 100 != 0) || (unAnho % 400 == 0));
       
    }
    
    
}

