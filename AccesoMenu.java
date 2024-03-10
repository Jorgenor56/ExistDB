import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XPathQueryService;
import org.xmldb.api.modules.XUpdateQueryService;

public class AccesoMenu {
    private Collection col = null;
    private XPathQueryService servicio;

    public void insertarMenu() {
        String xUpdate = "<xu:modifications version='1.0' xmlns:xu='http://www.xmldb.org/xupdate'>" +
                         "  <xu:append select='/tuColeccion'>" +
                         "    <xu:element name='menu'>" +
                         "      <nombre>Nombre del Menú</nombre>" + 
                         "      <precio>10</precio>" +
                         "    </xu:element>" +
                         "  </xu:append>" +
                         "</xu:modifications>";

        try {
            XUpdateQueryService updateService = (XUpdateQueryService) col.getService("XUpdateQueryService", "1.0");
            updateService.update(xUpdate);
            System.out.println("Menú insertado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar menú.");
            e.printStackTrace();
        }
    }

    public void buscarMenu(String nombre) {
        try {
            ResourceSet result = servicio.query("for $menu in //menu[nombre='" + nombre + "'] return $menu");
            ResourceIterator it = result.getIterator();
            while (it.hasMoreResources()) {
                System.out.println(it.nextResource().getContent());
            }
        } catch (Exception e) {
            System.err.println("Error al buscar menú.");
            e.printStackTrace();
        }
    }

    public void borrarMenu(String nombre) {
        String xUpdate = "<xu:modifications version='1.0' xmlns:xu='http://www.xmldb.org/xupdate'>" +
                         "  <xu:remove select='//menu[nombre=\"" + nombre + "\"]'/>" +
                         "</xu:modifications>";
        try {
            XUpdateQueryService updateService = (XUpdateQueryService) col.getService("XUpdateQueryService", "1.0");
            updateService.update(xUpdate);
            System.out.println("Menú borrado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al borrar menú.");
            e.printStackTrace();
        }
    }

    public void actualizaPrecio(int incremento) {

        System.out.println("Actualiza precio no implementado. Depende de la estructura del XML y la lógica específica.");
    }

    public void buscarMasBaratoQue(int precio) {
        try {
            ResourceSet result = servicio.query("for $menu in //menu[precio < " + precio + "] order by $menu/precio return $menu");
            ResourceIterator it = result.getIterator();
            while (it.hasMoreResources()) {
                System.out.println(it.nextResource().getContent());
            }
        } catch (Exception e) {
            System.err.println("Error al buscar menús más baratos que " + precio);
            e.printStackTrace();
        }
    }
}

