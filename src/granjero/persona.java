/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granjero;

import javax.swing.JOptionPane;

/**
 *
 * @author AnToNiO
 */
class persona {
    public persona(){
   
    
    }
    public static void llevarGallina(boolean t, escenario pantalla){
       
        if (pantalla.cosasDejadas.contains("lobo")&&pantalla.cosasDejadas.contains("maiz")){
            
            pantalla.cosasDejadas.remove("gallina");
           pantalla.gallina.setBounds(600, 120, 94,92);
           llevar(pantalla);
            pantalla.cosasLlevadas.add("gallina");
         
    }if(pantalla.cosasLlevadas.contains("lobo")&&pantalla.cosasLlevadas.contains("maiz")&&pantalla.bote.getBounds().x!=450){
        llevar(pantalla);
        pantalla.gallina.setBounds(600, 120, 94,92);
        System.out.println("felicidades");
    
    
    } else if(pantalla.cosasLlevadas.contains("lobo")&&pantalla.cosasLlevadas.contains("maiz")&&pantalla.bote.getBounds().x==450)
    { JOptionPane.showMessageDialog( null, "Regrese el bote","INVALIDO", JOptionPane.INFORMATION_MESSAGE );}
    }
    
    public static void regresarGallina(boolean t, escenario pantalla){
       
        if (pantalla.cosasLlevadas.contains("gallina")){
            
            pantalla.cosasLlevadas.remove("gallina");
            pantalla.gallina.setBounds(0, 120, 94,92);
            regresar(true,pantalla);
            pantalla.cosasDejadas.add("gallina");
            
            } 
    }

    public static void regresarMaiz(boolean t, escenario pantalla){
       
        if (pantalla.cosasLlevadas.contains("maiz")){
            
            pantalla.cosasLlevadas.remove("maiz");
            pantalla.maiz.setBounds(0, 240, 94,92);
            regresar(true,pantalla);
            pantalla.cosasDejadas.add("maiz");
            
            } 
    }
 public static void nuevo(escenario pantalla){
     int valor=JOptionPane.showConfirmDialog(null,"Jugar de nuevo","Intentalo nuevamente",JOptionPane.YES_NO_OPTION);
     if (valor==JOptionPane.YES_OPTION){
         escenario nuevo= new escenario();
        nuevo.setVisible(true);
        pantalla.dispose(); 
                 
     }else{System.exit(0);}
 }

    
    public static void llevar(escenario pantalla){
      pantalla.bote.setBounds(450, 290, 130,105);
      if(pantalla.cosasDejadas.contains("lobo")&&
              pantalla.cosasDejadas.contains("gallina")){
          
          JOptionPane.showMessageDialog( null, "PERDISTE. El lobo se comio a la gallina","FIN DEL JUEGO", JOptionPane.INFORMATION_MESSAGE );
       nuevo(pantalla);
          
          
      }else if(pantalla.cosasDejadas.contains("gallina")&&
              pantalla.cosasDejadas.contains("maiz")){
          JOptionPane.showMessageDialog( null,"PERDISTE. La gallina se comio el maiz","FIN DEL JUEGO",  JOptionPane.INFORMATION_MESSAGE );
       nuevo(pantalla);
          
          
      }else if(pantalla.cosasLlevadas.contains("gallina")&&
              pantalla.cosasLlevadas.contains("maiz")&&
              pantalla.cosasLlevadas.contains("lobo")){
          JOptionPane.showMessageDialog( null,"Felicidades", "GANASTE", JOptionPane.INFORMATION_MESSAGE );
          
          //escenario juegoNuevo= new escenario();
      }
      
    }

    public static void regresar(boolean t, escenario pantalla){
         pantalla.bote.setBounds(150, 290, 130,105);
         if(pantalla.cosasLlevadas.contains("lobo")&&
            pantalla.cosasLlevadas.contains("gallina")&& 
            pantalla.bote.getBounds().x==150){
                JOptionPane.showMessageDialog( null, "Perdiste. El lobo se comio a la gallina","FIN DEL JUEGO", JOptionPane.INFORMATION_MESSAGE );
                nuevo(pantalla);
         
         }else if(pantalla.cosasLlevadas.contains("gallina")&&
                 pantalla.cosasLlevadas.contains("maiz")&&
                 pantalla.bote.getBounds().x==150){
                        JOptionPane.showMessageDialog( null, "Perdiste. La gallina se comio el maiz", "FIN DEL JUEGO", JOptionPane.INFORMATION_MESSAGE );
                          nuevo(pantalla);
         }
    }

    public static void llevarLobo(boolean t, escenario pantalla){
        if(pantalla.bote.getBounds().x!=450){
                
                pantalla.lobo.setBounds(600,30,97,92);
         pantalla.cosasDejadas.remove("lobo");
         pantalla.cosasLlevadas.add("lobo");
          llevar(pantalla);
          
        }else{
        JOptionPane.showMessageDialog( null, "Regrese el bote","INVALIDO", JOptionPane.INFORMATION_MESSAGE );
        
        }   
    }

    public static void llevarMaiz(boolean t, escenario pantalla){
        if(pantalla.bote.getBounds().x!=450&&
                pantalla.cosasDejadas.contains("lobo")&&
                pantalla.cosasLlevadas.contains("gallina")){
            pantalla.maiz.setBounds(600, 240, 90,72);
        llevar(pantalla);
        pantalla.cosasDejadas.remove("maiz");
        pantalla.cosasLlevadas.add("maiz");
        
        
        }else if(pantalla.cosasDejadas.contains("lobo")&&
                pantalla.cosasDejadas.contains("gallina")){
                pantalla.maiz.setBounds(600, 240, 90,72);
                llevar(pantalla);
                nuevo(pantalla);
        }
    
    }
}
