public class UsaAccesoMenu {
    public static void main(String[] args) {
        AccesoMenu accesoMenu = new AccesoMenu();
        
        try {
            accesoMenu.conectar();
            
            System.out.println("Insertando un men� nuevo...");
            accesoMenu.insertarMenu();

            System.out.println("Buscando un men� espec�fico...");
            accesoMenu.buscarMenu("Nombre del Men�");

            System.out.println("Actualizando precios de los men�s...");
            accesoMenu.actualizaPrecio(10);

            System.out.println("Buscando men�s m�s baratos que un precio...");
            accesoMenu.buscarMasBaratoQue(20);

            System.out.println("Borrando un men� espec�fico...");
            accesoMenu.borrarMenu("Nombre del Men�");
            
        } catch(Exception e) {
            System.err.println("Ocurri� un error durante la operaci�n: " + e.getMessage());
            e.printStackTrace();
        } finally {
            accesoMenu.desconectar();
        }
    }
}

