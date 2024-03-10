public class UsaAccesoMenu {
    public static void main(String[] args) {
        AccesoMenu accesoMenu = new AccesoMenu();
        
        try {
            accesoMenu.conectar();
            
            System.out.println("Insertando un menú nuevo...");
            accesoMenu.insertarMenu();

            System.out.println("Buscando un menú específico...");
            accesoMenu.buscarMenu("Nombre del Menú");

            System.out.println("Actualizando precios de los menús...");
            accesoMenu.actualizaPrecio(10);

            System.out.println("Buscando menús más baratos que un precio...");
            accesoMenu.buscarMasBaratoQue(20);

            System.out.println("Borrando un menú específico...");
            accesoMenu.borrarMenu("Nombre del Menú");
            
        } catch(Exception e) {
            System.err.println("Ocurrió un error durante la operación: " + e.getMessage());
            e.printStackTrace();
        } finally {
            accesoMenu.desconectar();
        }
    }
}

